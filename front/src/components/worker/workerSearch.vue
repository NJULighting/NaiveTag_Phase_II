<template>
    <div id="search">
        <div>
            <!--搜索结果-->
            <div style="width: 100%;text-align: center;padding-top: 40px;padding-bottom: 20px">
                <span v-if="taskList.length === 0" style="font-family: SimSun-ExtB;font-size: 30px">无</span><span style="font-family: SimSun-ExtB;font-size: 30px">搜索结果</span>
            </div>

            <div style="text-align: center">
                <taskblock v-for="(taskData,key) in taskList" v-bind:key="key" v-bind="taskData"></taskblock>
            </div>
        </div>
    </div>
</template>

<script>
    import {search} from '../../api/search.js'

    export default {


        created: function () {
            this.fetchKey();
        },

        watch: {
            // 如果路由有变化，会再次执行该方法
            '$route': 'fetchKey'
        },

        methods: {
            fetchKey () {
                let result = search(this.$route.params.key, res=> {
                    console.log("result:");
                    console.log(res);
                    this.taskList = res;
                });
            },
        },

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
                            "cover": "/src/components/test.jpg",
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
                            "cover": "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "/src/components/test.jpg",
                        },
                        {
                            "taskId": 100,
                            "taskType": 200,
                            "taskName": "区域标注任务（一）",
                            "averageScore": 103,
                            "payDay": "2018-3-22",
                            "picAmount": 78,
                            "cover": "/src/components/test.jpg",
                        },
                    ]
            }
        },

    }
</script>

<style>

</style>
