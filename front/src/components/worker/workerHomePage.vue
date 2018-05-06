<template>
    <div id="page" style="height: 100%;">


        <!--<button v-on:click="getRecommendation">button</button>-->
        <!--任务进行中-->
        <div v-if="taskDoingList && taskDoingList.length != 0" style="width: 100%;text-align: center;padding-top: 30px;">
            <el-tooltip content="“历史任务”可以查看更多哟 ˋ( ° ▽、° ) " placement="right-start" effect="light">
                <img src="../../assets/doing.png" style="height: 50px; width: auto;">
            </el-tooltip>
        </div>

        <div style="width: 100%;text-align: center">
            <div style="text-align: left">
                <taskblock v-for="(taskData,key) in taskDoingList" v-bind:key="key" v-bind="taskData"></taskblock>
            </div>
        </div>

        <!--任务推荐-->
        <div v-if="taskRecommendList && taskRecommendList != 0" style="width: 100%;height:100px;text-align: center;" class="center">
            <div>
                <div class="center">
                    <img src="../../assets/recommedation.png" style="height: 50px; width: auto;">
                    <img v-if="!this.isReflash" src="../../assets/reflash.png" style="width: 25px;height: auto;cursor: pointer;"
                         ondragstart="return false;"
                         oncontextmenu="return false;" @click="reTask">
                    <img v-if="this.isReflash" src="../../assets/reflash.gif" style="width: 25px;height: auto;cursor: pointer;"
                         ondragstart="return false;"
                         oncontextmenu="return false;" @click="reTask">
                    <div style="display: inline-block;cursor: pointer;" @click="reTask">
                        <span>换一波</span>
                        <span>{{faceText}}</span>
                    </div>

                </div>
            </div>
        </div>

        <div style="width: 100%;text-align: center">
            <div style="text-align: left">
                <taskblock v-for="(taskData,key) in taskRecommendList" v-bind:key="key" v-bind="taskData"></taskblock>
            </div>
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

        methods: {
            reTask: function() {
                console.log("reflash");
                this.faceText = 'Σ(っ °Д °;)っ';
                this.isReflash = true;
                let result2 = recommendation(res=> {
                    this.taskRecommendList = res;
                    let that = this;
                    setTimeout(function (){
                        console.log('执行了');
                        that.defaultReflash();
                    }, 1000);
                });
//                this.faceText = 'ԅ(¯﹃¯ԅ)';
//                this.isReflash = false;
            },

            defaultReflash: function() {
                this.faceText = 'ԅ(¯﹃¯ԅ)';
                this.isReflash = false;
            },
        },

        created: function () {
            var count = 3;
            let result1 = taskGoing(count, res=> {
//                console.log("taskGoing success");
//                console.log(res);
                this.taskDoingList = res;
            });
            let result2 = recommendation(res=> {
//                console.log("recommendation success");
//                console.log(res);
                this.taskRecommendList = res;
            });
        },

        data() {
            return {
                faceText: "ԅ(¯﹃¯ԅ)",
                isReflash: false,
                taskDoingList: [
//                    {
//                        "taskId": 100,
//                        "taskType": 200,
//                        "taskName": "区域标注任务（一）",
//                        "averageScore": 103,
//                        "actualScore": 89,
//                        "process": 67,
//                        "cover" : "/src/components/test.jpg",
//                    },
//                    {
//                        "taskId": 100,
//                        "taskType": 200,
//                        "taskName": "区域标注任务（一）",
//                        "averageScore": 103,
//                        "actualScore": 89,
//                        "process": 67,
//                        "cover" : "/src/components/test.jpg"
//                    },
//                    {
//                        "taskId": 100,
//                        "taskType": 200,
//                        "taskName": "区域标注任务（一）",
//                        "averageScore": 103,
//                        "actualScore": 89,
//                        "process": 67,
//                        "cover" : "/src/components/test.jpg"
//                    },
//                    {
//                        "taskId": 100,
//                        "taskType": 200,
//                        "taskName": "区域标注任务（一）",
//                        "averageScore": 103,
//                        "actualScore": 89,
//                        "process": 67,
//                        "cover" : "/src/components/test.jpg"
//                    },
//                    {
//                        "taskId": 100,
//                        "taskType": 200,
//                        "taskName": "区域标注任务（一）",
//                        "averageScore": 103,
//                        "actualScore": 89,
//                        "process": 67,
//                        "cover" : "/src/components/test.jpg"
//                    }
                ],
                taskRecommendList:
                    [
//                        {
//                            //taskType: 100,
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            //"actualScore": 89, // 实际得到的分数，有可能是-1，比如没有结算
//
//                            "payDay": "2018-3-22",
//                            "picAmount": 78,
//
//                            //"process": 67,
//                            "cover" : "/src/components/test.jpg",
//                            //"beginDate": "2018-3-22",
//                            //"endDate": "2018-3-22",
//                            //"state": "expired" // unpay、finish、doing、expired(等待结算、完成、进行、过期)
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "payDay": "2018-3-22",
//                            "picAmount": 78,
//                            "cover" : "/src/components/test.jpg",
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "payDay": "2018-3-22",
//                            "picAmount": 78,
//                            "cover" : "/src/components/test.jpg",
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "payDay": "2018-3-22",
//                            "picAmount": 78,
//                            "cover" : "/src/components/test.jpg",
//                        },
//                        {
//                            "taskId": 100,
//                            "taskType": 200,
//                            "taskName": "区域标注任务（一）",
//                            "averageScore": 103,
//                            "payDay": "2018-3-22",
//                            "picAmount": 78,
//                            "cover" : "/src/components/test.jpg",
//                        }
                    ]
            }
        },

    }
</script>

<style>

</style>