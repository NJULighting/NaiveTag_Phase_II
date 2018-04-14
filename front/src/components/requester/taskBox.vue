<template>
    <router-link to="taskDetail">
        <el-card style="margin-top: 20px">
            <el-container>
                <el-aside>
                    <el-progress type="circle" :percentage="task.process*100"></el-progress>
                </el-aside>

                <el-main style="height: 100%">

                    <el-row>
                        <el-col :span="3" class="text-col">
                            <span >{{task.taskName}}</span>
                        </el-col>
                        <el-col :span="8" offset="4"  class="text-col">
                       <span >
                           截止日期：{{task.endTime}}
                       </span>
                        </el-col>
                        <el-button icon="el-icon-download"  style="margin: 20px" @click.prevent="exportResult">下载结果</el-button>
                    </el-row>

                </el-main>
            </el-container>
        </el-card>
    </router-link>
</template>

<script>
    export default {
        name: "taskBox",
        props: ['task'],
        methods:{
            exportResult(){

            }
        }
    }
</script>

<style scoped>
    .text-col{
       margin-top: 30px;
    }

</style>