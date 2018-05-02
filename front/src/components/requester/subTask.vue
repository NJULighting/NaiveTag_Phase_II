<template>
    <el-container style="margin-top: 30px">
        <el-header style="height: auto">
            <el-row type="flex">
                <el-col :span="5">
                    <span>{{taskIndex}}.{{taskName}}</span>
                </el-col>
                <el-col :offset="12">
                    <el-progress class="subtask-progress" :text-inside="true" :stroke-width="18"
                                 :percentage="subTask.taskProcess*100"></el-progress>
                </el-col>
            </el-row>

        </el-header>
        <el-main>
            <div>
                <el-row type="flex">
                    <el-col>
                        <h4>任务描述:</h4>
                        <blockquote> {{subTask.taskInfo.description}}</blockquote>
                    </el-col>
                </el-row>
            </div>
            <el-collapse v-model="activeNames" style="margin-top: 30px">
                <el-collapse-item name="1" title="参与标注人员">
                    <el-table
                            :data="subTask.participants">

                        <el-table-column
                                prop="ability"
                                label="能力">
                        </el-table-column>
                        <el-table-column
                                prop="rankRate"
                                label="排名率">
                        </el-table-column>
                        <el-table-column
                                prop="rank"
                                label="排名">
                        </el-table-column>
                    </el-table>
                </el-collapse-item>
            </el-collapse>
        </el-main>
    </el-container>
</template>

<script>
    import {taskName} from "~/api/taskName";

    export default {
        name: "subTask",
        props: ['subTask', 'index'],
        data: function () {
            return {
                activeNames: ['1'],
                taskName: taskName(this.subTask.taskInfo.taskType),
                taskIndex: this.index + 1

            }
        },
        created: function () {
            console.log('subTask');
            console.log(this.subTask.participants);
            //console.log(Object.values(this.subTask));
        }
    }
</script>

<style scoped>
    .subtask-progress {
        width: 300px;
    }
</style>