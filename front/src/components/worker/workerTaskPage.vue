<template>
    <div id="task">
        <taskinfo @refreshData="fetchDetails"
                  @tagPicList="tagPicList"
                  v-bind="taskData"></taskinfo>
    </div>
</template>

<script>

    import taskinfo from './workerTaskInfo.vue';
    import {taskDetails} from '../../api/taskDetails.js'

    export default {

        created: function () {
            // `this` 指向 vm 实例
            if(this.taskData.state && this.taskData.state === "accept"){
                this.$message.info('点击任意一张图片开始进行标注！');
            }

            this.fetchDetails();
        },

        watch: {
            // 如果路由有变化，会再次执行该方法
            '$route': 'fetchDetails'
        },

        methods: {

            tagPicList(picUrl) {
                console.log("picUrl: " + picUrl);
                this.$router.push({ name: 'tag', params: { taskId: this.$route.params.taskId, picUrl: picUrl}});
            },

            fetchDetails () {
                let result = taskDetails(this.$route.params.taskId, res=> {
                    console.log("taskDetail:");
                    console.log(res);
                    this.taskData = res;
                });
            },
        },

        components: {
            taskinfo : taskinfo,
        },

        data() {
            return {
                taskData: {
//                    "averageScore": 100.0,
//                    "finishedPicList": [],
//                    "unfinishedPicList": [
//                        "iznauy/董建华.jpg",
//                        "iznauy/伊丽莎白.jpg",
//                        "iznauy/华莱士.jpg",
//                        "iznauy/江泽民.jpg"
//                    ],
//                    "beginDate": "2018 4 21",
//                    "endDate": "2018 4 24",
//                    "state": "accept",
//                    "cover": "iznauy/董建华.jpg",
//                    "taskName": "黎明杀机_1",
//                    "taskType": 100,
//                    "taskDescription": null
                }
            }
        }

    }
</script>

<style>

</style>
