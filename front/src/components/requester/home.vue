<template>
    <div>
        <el-row>
            <el-col :span="16" :offset="4">
                <div  v-if="taskList.length===0">
                    <h2> 您还没有任务，快去创建吧</h2>
                </div>
                <task-box v-for="(item,key)  in taskList" :task="item" :key="key"></task-box>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import taskBox from './taskBox.vue'
    import {fetchTaskList} from "~/api/requesterDetail";

    export default {
        name: "page1",
        components: {taskBox},
        data: function () {
            return {
                taskList: [

                ]
            }
        },
        created: function () {
            fetchTaskList(localStorage.username, res => {
                this.taskList = res;
            })

        }
    }
</script>

<style scoped>

</style>