<template>
    <el-col :span="8" :offset="8">
        <el-form :model="taskForm" :rules="rules" ref="taskForm" label-position='left' label-width="160px"
                 style="margin-top: 50px">
            <el-form-item label="任务名称">
                <el-input></el-input>
            </el-form-item>
            <el-form-item label="截止日期">
                <el-date-picker type="date" placeholder="选择日期" style="width: 100%"
                                v-model="taskForm.endDate">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="添加任务描述文件">
                <el-upload

                        action="http://localhost:8000/naive/requester/check.html"
                        :http-request="validateTask"
                        :limit="1"
                        :file-list="taskForm.taskDescription"
                         name="taskconf">
                    <el-button icon="el-icon-upload" style="width: 100%">上传</el-button>
                </el-upload>
            </el-form-item>
            <el-form-item label="筛选条件">
                <div>
                    <div class="filter-item">
                        工人RankRate
                        <el-input size="small" class="filter-input"></el-input>
                    </div>
                    <div class="filter-item">
                        工人平均得分
                        <el-input size="small" class="filter-input"></el-input>
                    </div>

                </div>
            </el-form-item>
            <el-form-item prop="score" label="悬赏金额">
                <el-input-number
                        v-model="taskForm.score"
                        :min="0"
                        :max="maxScore"
                        style="width: 100%">
                </el-input-number>
            </el-form-item>
            <el-form-item label="添加数据集">
                <el-upload
                        action="null"
                        :http-request="uploadDataSet"
                        :limit="1"
                        :file-list="taskForm.dataSet">
                    <el-button icon="el-icon-upload" style="width: 100%">点击上传</el-button>
                </el-upload>
            </el-form-item>
            <el-button type="primary" style="width: 100%">提交</el-button>
        </el-form>
    </el-col>
</template>

<script>

    import {uploadTaskDescription} from "../../api/createTask";
    import {fetchRequesterDetail} from "~/api/requesterDetail";
    import ElCollapseTransition from "element-ui/src/transitions/collapse-transition";

    export default {
        name: "page2",
        components: {ElCollapseTransition},
        data: function () {
            const validateNUmber = (rule, value, callback) => {
                const reg = /^[0-9]\d*$/;
                if (reg.test(value)) {
                    callback();
                } else {
                    callback(new Error('请输入自然数'));
                }
            };

            return {
                taskForm: {
                    endDate: '',
                    taskDescription: [],
                    dataSet: [],
                    score: '',

                },
                rules: {
                    score: [
                        {validator: validateNUmber, trigger: 'blur'}

                    ]
                },
                success: false,
                done: false,
                maxScore: 0,
                header:{

                }

            }
        },
        computed: {
            showSuccess: function () {
                return this.success * this.done;
            }
        },
        created: function () {
            fetchRequesterDetail(window.localStorage.username, res => {
                this.maxScore = res.score;
            })
        },
        methods: {
            validateTask(item) {
                uploadTaskDescription(item.file, res=> {
                    console.log(res)
                })
            },
            validate(response, file, fileList){
              console.log(response);
            },
            // validateTask(response, file, fileList){
            //   console.log(response);
            // },
            uploadDataSet(item) {

            }
        }
    }
</script>

<style scoped>
    .filter-input {
        width: 200px;
        float: right;

    }

    .filter-item {
        padding: 0;
    }
</style>