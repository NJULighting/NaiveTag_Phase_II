<template>
    <div id="search">
        <div>
            <!--搜索结果-->
            <div style="width: 100%;text-align: center;padding-top: 40px;padding-bottom: 20px">
                <span style="font-family: SimSun-ExtB;font-size: 30px">搜索结果</span>
            </div>

            <div style="text-align: center">
                <taskblock v-for="(taskData,key) in taskList" v-bind:key="key" v-bind="taskData"></taskblock>
            </div>
        </div>
    </div>
</template>

<script>

    //import taskblock from './taskBlock.vue';

    export default {

//        components: {
//            taskblock: taskblock
//        },

        data() {
            return {

                taskList:
                    [
                        {
                            //taskType: 100,
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            //"actualScore": 89, // 实际得到的分数，有可能是-1，比如没有结算

                            "payDay": "2018-3-22",
                            "picAmount": 78,

                            //"process": 67,
                            "cover": "./src/components/test.jpg",
                            //"beginDate": "2018-3-22",
                            //"endDate": "2018-3-22",
                            //"state": "expired" // unpay、finish、doing、expired(等待结算、完成、进行、过期)
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "./src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "./src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "./src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "./src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "./src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "./src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "./src/components/test.jpg",
                        },
                    ]
            }
        },

    }
</script>

<style>

</style>
