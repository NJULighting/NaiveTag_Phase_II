<template>
    <div style="margin-top: 30px">
           <el-col :offset="5">
               <el-tabs type="border-card" class="detail-container">
                    <el-tab-pane label="默认分析">
                        <div >
                            <sub-task v-for=" (item ,key) in taskList" :subTask=item :index="key" :key="key"></sub-task>
                        </div>
                    </el-tab-pane>
               </el-tabs>

           </el-col>


    </div>
</template>

<script>

    import subTask from "~/components/requester/subTask";
    import {getTaskDetail} from "~/api/taskDetail";

    export default {
        name: "TaskDetail",
        components: {subTask},
        data: function () {
            return {
                taskList: []
            }
        },
        created:function () {
            this.taskList=getTaskDetail('1')
        },
        methods:{

        }
    }
</script>

<style scoped>
        .detail-container{
            width: 800px;
           height: 100%;
        }
</style>