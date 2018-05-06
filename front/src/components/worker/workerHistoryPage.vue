<template>
    <div id="history">

        <!--历史人物记录-->
        <div style="width: 100%;text-align: center;padding-top: 30px;padding-bottom: 20px">
            <img src="../../assets/history.png" style="height: 50px; width: auto;">
        </div>

        <div style="text-align: center">
            <taskblock v-for="(taskData,key) in taskList" v-bind:key="key" v-bind="taskData"></taskblock>
        </div>

    </div>
</template>

<!--外部导入局部组件-->
<script>
    //引入
    import {history} from '../../api/workerHistory.js'

    //注册
    export default {

        created: function () {
            this.fetchTaskList();
        },

        methods: {
            fetchTaskList () {
                let result = history(res=> {
                    console.log("history:");
                    console.log(res);
                    this.taskList = res;
                });
            },
        },

        data () {
            return {

                taskList:
                    [
//                        {
//                            //taskType: 100,
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89, // 实际得到的分数，有可能是-1，比如没有结算
//
//                            //"payDay": "2018-3-22",
//                            //"picAmount": 78,
//
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "expired" // unpay、finish、doing、expired(等待结算、完成、进行、过期)
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "unpay"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "finish"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "doing"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "expired"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "expired"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "expired"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "expired"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "expired"
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "actualScore": 89,
//                            "process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            "beginDate": "2018-3-22",
//                            "endDate": "2018-3-22",
//                            "state": "expired"
//                        }
                    ]

            }
        },

    }
</script>

<style>

</style>