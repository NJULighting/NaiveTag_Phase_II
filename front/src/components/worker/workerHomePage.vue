<template>
    <div id="page">

        <!--<button v-on:click="getRecommendation">button</button>-->
        <!--任务进行中-->
        <div style="width: 100%;text-align: center;padding-top: 40px;padding-bottom: 20px">
            <el-tooltip content="选择“历史任务”以查看更多" placement="right-start" effect="light">
                <span v-if="taskDoingList" style="font-family: SimSun-ExtB;font-size: 30px">任务进行中</span>
            </el-tooltip>
        </div>

        <div style="text-align: center;width: 100%">
            <div style="text-align: left">
                <taskblock v-for="(taskData,key) in taskDoingList" v-bind:key="key" v-bind="taskData"></taskblock>
            </div>
        </div>

        <!--任务推荐-->
        <div style="width: 100%;text-align: center;padding-top: 30px;padding-bottom: 20px">
            <span v-if="taskRecommendList" style="font-family: SimSun-ExtB;font-size: 30px">任务推荐</span>
        </div>

        <div style="text-align: center">
            <taskblock v-for="(taskData,key) in taskRecommendList" v-bind:key="key" v-bind="taskData"></taskblock>
        </div>

    </div>
</template>

<!--外部导入局部组件-->
<script>
    //引入
    //import taskblock from './taskBlock.vue';
    import {recommendation} from '../../api/recommendation.js'

    import {taskGoing} from '../../api/taskGoing.js'

    //注册
    export default {
        //mixins: [workerHomeData],

//        components: {
//            'taskblock': taskblock,
//        },

        created: function () {
            var count = 3;
            let result1 = taskGoing(count, res=> {
                console.log("taskGoing success");
                console.log(res);
                this.taskDoingList = res;
            });
            let result2 = recommendation(res=> {
                console.log("recommendation success");
                console.log(res);
                this.taskRecommendList = res;
            });
        },

        data() {
            return {
                taskDoingList: [
                    {
                        "taskId": 100,
                        "taskType": 200,
                        "taskName": "区域标注任务（一）",
                        "averageScore": 103,
                        "actualScore": 89,
                        "process": 67,
                        "cover" : "/src/components/test.jpg",
                    },
                    {
                        "taskId": 100,
                        "taskType": 200,
                        "taskName": "区域标注任务（一）",
                        "averageScore": 103,
                        "actualScore": 89,
                        "process": 67,
                        "cover" : "/src/components/test.jpg"
                    },
                    {
                        "taskId": 100,
                        "taskType": 200,
                        "taskName": "区域标注任务（一）",
                        "averageScore": 103,
                        "actualScore": 89,
                        "process": 67,
                        "cover" : "/src/components/test.jpg"
                    },
                    {
                        "taskId": 100,
                        "taskType": 200,
                        "taskName": "区域标注任务（一）",
                        "averageScore": 103,
                        "actualScore": 89,
                        "process": 67,
                        "cover" : "/src/components/test.jpg"
                    },
                    {
                        "taskId": 100,
                        "taskType": 200,
                        "taskName": "区域标注任务（一）",
                        "averageScore": 103,
                        "actualScore": 89,
                        "process": 67,
                        "cover" : "/src/components/test.jpg"
                    }
                ],
                taskRecommendList:
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
                            "cover" : "/src/components/test.jpg",
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
                            "cover" : "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover" : "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover" : "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover" : "/src/components/test.jpg",
                        }
                    ]
            }
        },

    }
</script>

<style>

</style>