<template>
    <el-row>
        <el-col :span="18" :offset="3">
            <br>
            <task-box v-for="(item,key)  in taskList" :task="item" :key="key"></task-box>
        </el-col>
    </el-row>
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
                        taskId: '213213',
                        taskType: 101,
                        progress: 0.4,
                        state: 'completed'
                    },
                    {
                        taskName: 'secondTask',
                        taskId: '213213',
                        taskType: 101,
                        progress: 0.5,
                        state: 'underway'
                    },
                    {
                        taskName: 'thirdTask',
                        taskId: '213213',
                        taskType: 101,
                        progress: 1,
                        state: 'completed'
                    }
                ]
            }
        }
    }
</script>

<style scoped>

</style>