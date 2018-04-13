<template>
    <div id="task">
        <taskinfo v-bind="taskData"></taskinfo>
    </div>
</template>

<script>

    import taskinfo from './workerTaskInfo.vue';

    export default {

        components: {
            taskinfo : taskinfo
        },

        created: function () {
            // `this` 指向 vm 实例
            this.$message.info('点击任意一张图片开始进行标注！');
        },

        data() {
            return {
                taskData: {
                    "taskState": "fail", // 已经接受的任务unaccept
                    "taskName": "区域标注任务（一）",
                    "taskType": 401,
                    "taskDescription": "这是一个区域标注类型的任务，标注者需要将目标区域画出，并写上详细描述",
                    "averageScore": 67,

//                    "picList": [
//                        "./src/components/test.jpg",
//                        "./src/components/test.jpg",
//                        "./src/components/test.jpg",
//                        "./src/components/test.jpg",
//                        "./src/components/test.jpg",
//                        "./src/components/test.jpg",
//                        "./src/components/test.jpg",
//                        "./src/components/test.jpg",
//                    ],
                    "payDay": "2018/4/12 22:22:22", // 任务的最终截止时期
                    "canAccept": "true", // true or false  因为有的任务用户不可以接受

                    "finishedPicList": [
                        "./src/components/test.jpg",
                        "./src/components/test.jpg",
                        "./src/components/test.jpg",
                        "./src/components/test.jpg",
                    ],
                    "unFinishedPicList": [
                        "./src/components/test.jpg",
                        "./src/components/test.jpg"
                    ],
                    "beginDate": "2018/4/12 22:22:22",
                    "endDate": "2018/4/12 22:22:22", // 任务最终截止时期和任务的过期时间的较小值
                    "earnedScore": 46.7
                }
            }
        }

    }
</script>

<style>

</style>
