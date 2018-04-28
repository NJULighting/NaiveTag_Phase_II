<template>
    <router-link :to="{ name:'taskDetail', params: { taskId: this.task.taskId}}">
        <el-card style="margin-top: 20px">
            <el-container>
                <el-aside style="width: 200px">
                    <el-progress type="circle" :percentage="task.process*100"></el-progress>
                </el-aside>

                <el-main style="height: 100%">

                    <el-row>
                        <el-col :span="3" class="text-col" style="width: 30%">
                            <el-tag v-if="task.state==='completed'" type="success">已完成</el-tag>
                            <el-tag v-else>进行中</el-tag>
                            <span style="margin: 0 30px 0 60px">{{task.taskName}}</span>
                        </el-col>
                        <el-col :span="8" :offset="2" class="text-col">
                           <span>
                               截止日期：{{task.endDate}}
                           </span>
                        </el-col>
                        <el-button icon="el-icon-download" style="margin: 20px" @click.prevent="exportResult"
                        v-if="isCompleted" >下载结果
                        </el-button>
                    </el-row>
                </el-main>
            </el-container>
        </el-card>
    </router-link>
</template>

<script>
    import {getUrl} from "~/api/tool";

    export default {
        name: "taskBox",
        props: ['task'],
        data: function () {
            return {

            }
        },
        computed:{
            isCompleted: function () {
                return this.task.state==='completed';
            }
        },
        methods: {
            exportResult() {
                $.get(getUrl('requester/download.html'), {taskId: this.task.taskId}, res => {

                    let link = document.createElement('a')
                    link.style.display = 'none'
                    link.href = getUrl(res);
                    link.setAttribute('download','*');
                    document.body.appendChild(link);
                    link.click()

                });
            }
        },
        created: function () {
        }
    }
</script>

<style scoped>
    .text-col {
        margin-top: 30px;
    }

</style>