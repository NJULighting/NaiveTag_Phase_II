<template>
    <div>
        <el-row>
            <el-col :span="16" :offset="4">
                <!--// username:{{localStorage.username}}-->
                <task-box v-for="(item,key)  in taskList" :task="item" :key="key"></task-box>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import taskBox from './taskBox.vue'

    export default {
        name: "page1",
        components: {taskBox},
        data: function () {
            return {
                taskList: [
                    {
                        taskName: 'firstTask',
                        taskId: '001',
                        taskType: 101,
                        process: 0.4,
                        state: 'completed',
                        endTime:'2018-05-01'
                    },
                    {
                        taskName: 'secondTask',
                        taskId: '002',
                        taskType: 101,
                        process: 0.5,
                        state: 'underway',
                        endTime:'2018-05-01'
                    },
                    {
                        taskName: 'thirdTask',
                        taskId: '003',
                        taskType: 101,
                        process: 1,
                        state: 'completed',
                        endTime:'2018-05-01'
                    }
                ]
            }
        },
        created:function () {
            console.log(localStorage.username);

        }
    }
</script>

<style scoped>

</style>