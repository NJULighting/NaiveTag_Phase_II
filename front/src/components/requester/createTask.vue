<template>

    <el-col :span="8" :offset="8">
        <el-form :model="taskForm" :rules="rules" ref="taskForm" label-position='left' label-width="160px"
                 style="margin-top: 50px">
            <el-form-item label="任务名称" prop="taskName">
                <el-input v-model="taskForm.taskName" clearable></el-input>
            </el-form-item>
            <el-form-item label="截止日期" prop="endTime">
                <el-date-picker type="date" placeholder="选择日期" style="width: 100%"
                                value-format="yyyy-MM-dd"
                                v-model="taskForm.endTime"
                                :picker-opitons="pickerOptions">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="添加任务描述文件" prop="taskDescription">
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
                        工人排名比率
                        <el-slider size="small" v-model="taskForm.workerFilter.workerRankRate"
                                   :min="0"
                                   :max="1"
                                   :step="0.01"
                                   class="filter-input"></el-slider>
                    </div>
                    <div class="filter-item">
                        工人平均得分
                        <el-slider size="small" v-model="taskForm.workerFilter.averageScore"
                                   :min="0"
                                   :max="3"
                                   :step="0.01"
                                   class="filter-input"></el-slider>
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
            <el-form-item label="添加数据集" prop="fileList">
                <el-upload
                        action="null"
                        :http-request="uploadDataSet"
                        :limit="1">
                    <el-button icon="el-icon-upload" style="width: 100%">点击上传</el-button>
                </el-upload>
            </el-form-item>
            <el-button type="primary" style="width: 100%" @click="createTask">提交</el-button>
        </el-form>
    </el-col>
</template>

<script>

    import {uploadTaskDescription} from "../../api/createTask";
    import {fetchRequesterDetail} from "~/api/requesterDetail";
    import ElCollapseTransition from "element-ui/src/transitions/collapse-transition";
    import {uploadTask} from "~/api/createTask";

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

            const validateTaskConf = (rule, value, callback) => {
                if (this.validTask === true) {
                    callback();
                } else {
                    callback(new Error('请上传正确的任务描述文件'));
                }
            };


            const validateDataSet = (rule, value, callback) => {
                if (this.taskForm.fileList.length !== 0) {
                    callback();
                } else {
                    callback(new Error('请选择数据集'));
                }
            };

            return {
                taskForm: {
                    taskName: '',
                    endTime: '',
                    taskDescription: [],
                    fileList: [],
                    score: '',
                    workerFilter: {
                        workerRankRate: 1,
                        averageScore: 0.99,
                    },
                    file: undefined,
                    taskConf: undefined
                },
                dataSet: undefined,
                pickerOptions: {
                    disabledDate: (time) => {
                        console.log('picker');
                        return true;

                    }
                },
                rules: {
                    // taskName:[
                    //     {required:true,message:'请输入任务名称',trigger:'blur'}
                    // ],
                    // endDate: [
                    //     // {type: 'date', required: true, message: '请选择日期', trigger: 'blur'}
                    // ],
                    // fileList:[
                    //     {validator:validateTaskConf,trigger:'blur'}
                    //     ],
                    // taskDescription:[
                    //     {validator:validateDataSet,trigger:'blur'}
                    // ]


                },
                validTask: false,
                maxScore: 0,

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
                uploadTaskDescription(item.file, res => {
                    this.taskForm.taskConf = item.file;
                    if (res.result === 'valid') {
                        this.validTask = true;

                    } else {
                        alert('任务文件格式不正确');
                        this.validTask = false;
                    }
                })
            },
            uploadDataSet(item) {
                this.taskForm.file = item.file;
            },
            createTask() {
                // this.$refs['taskForm'].validate((valid)=>{
                //     console.log(valid)
                //     if (valid){
                //
                //     }
                // })

                console.log(this.taskForm.endTime);
                uploadTask(this.taskForm, res => {
                    if (res.result === 'success') {
                        this.$router.push('/requester/home');
                    } else {
                        alert('创建任务失败');
                    }
                })
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