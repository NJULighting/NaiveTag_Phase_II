<template>
    <div id="task">
        <taskinfo v-if="!this.startTag"
                  @refreshData="fetchDetails"
                  @tagPicList="tagPicList"
                  @tagUnfinishedPicList="tagUnfinishedPicList"
                  @tagFinishedPicList="tagFinishedPicList"
                  v-bind="taskData"></taskinfo>
        <tagpage v-if="this.startTag"
                 v-bind:picUrl="this.picUrl"
                 v-bind:options="options"
                 :tagData.sync="tagData"
                 @lastPic="lastPic"
                 @nextPic="nextPic"></tagpage>
    </div>
</template>

<script>

    import tagpage from './workerTagPage.vue'
    import taskinfo from './workerTaskInfo.vue';
    import {taskDetails} from '../../api/taskDetails.js'

    export default {

        created: function () {
            // `this` 指向 vm 实例
            this.$message.info('点击任意一张图片开始进行标注！');
            this.fetchDetails();
        },

        watch: {
            // 如果路由有变化，会再次执行该方法
            '$route': 'fetchDetails'
        },

        methods: {

            lastPic: function () {
                if(this.picIndex >= 1){
                    this.picIndex --;
                    this.changePicUrlByIndex(this.picIndex);
                }else{
                    this.$message.info('这已经是第一张图片！');
                }
                console.log("lastPicIndex: " + this.picIndex);
            },

            nextPic: function () {
                if(this.picIndex <= this.getListLength()-2){
                    this.picIndex ++;
                    this.changePicUrlByIndex(this.picIndex);
                }else{
                    this.$message.info('这已经是最后一张图片！');
                }
                console.log("nextPicIndex: " + this.picIndex);
            },

            getListLength(){
                switch (this.picState){
                    case "picList":
                        return this.taskData.picList.length;
                        break;
                    case "unfinishedPicList":
                        return this.taskData.unfinishedPicList.length;
                        break;
                    case "finishedPicList":
                        return this.taskData.finishedPicList.length;
                        break;
                    default:
                        break;
                }
            },

            changePicUrlByIndex(index){
                switch (this.picState){
                    case "picList":
                        this.picUrl = this.addPicUrl(this.taskData.picList[index]);
                        break;
                    case "unfinishedPicList":
                        this.picUrl = this.addPicUrl(this.taskData.unfinishedPicList[index]);
                        break;
                    case "finishedPicList":
                        this.picUrl = this.addPicUrl(this.taskData.finishedPicList[index]);
                        break;
                    default:
                        break;
                }
            },

            addPicUrl(picUrl){
                return "http://localhost:8000/naive/" + picUrl;
            },

            tagPicList(index) {
                console.log("jumpToPicListIndex: " + index);
                this.picIndex = index;
                this.picState = "picList";
                this.changePicUrlByIndex(index);
                this.startTag = true;
            },

            tagUnfinishedPicList(index) {
                console.log("jumpToUnfinishedPicListIndex: " + index);
                this.picIndex = index;
                this.picState = "unfinishedPicList";
                this.changePicUrlByIndex(index);
                this.startTag = true;
            },

            tagFinishedPicList(index) {
                console.log("jumpToFinishedPicListIndex: " + index);
                this.picIndex = index;
                this.picState = "finishedPicList";
                this.changePicUrlByIndex(index);
                this.startTag = true;
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
            tagpage: tagpage,
        },

        data() {
            return {
                picIndex: 0,
                picState: "picList",
                picUrl: "../test.jpg",
                options: [{
                    value: '0',
                    label: '黄金糕'
                }, {
                    value: '1',
                    label: '双皮奶'
                }, {
                    value: '2',
                    label: '蚵仔煎'
                }, {
                    value: '3',
                    label: '龙须面'
                }, {
                    value: '4',
                    label: '北京烤鸭'
                }],
                tagData: {
                    "frames":[
                        {
                            "leftTop":{"x":23,"y":19},
                            "rightDown":{"x":100,"y":200},
                            "label":"黄金糕"
                        },
                        {
                            "leftTop":{"x":300,"y":192},
                            "rightDown":{"x":400,"y":650},
                            "label":"双皮奶"
                        },
                        {
                            "leftTop":{"x":500,"y":300},
                            "rightDown":{"x":800,"y":500},
                            "label":"蚵仔煎"
                        }
                    ],
                    "tagType":"t_300",
                    //若能画，points必有
                    "points":[
                        {"x":10,"y":10},
                        {"x":100,"y":10},
                        {"x":100,"y":100},
                        {"x":10,"y":100},
                    ],
                },
                startTag: false,
                taskData: {
                    "averageScore": 100.0,
                    "finishedPicList": [],
                    "unfinishedPicList": [
                        "iznauy/董建华.jpg",
                        "iznauy/伊丽莎白.jpg",
                        "iznauy/华莱士.jpg",
                        "iznauy/江泽民.jpg"
                    ],
                    "beginDate": "2018 4 21",
                    "endDate": "2018 4 24",
                    "state": "accept",
                    "cover": "iznauy/董建华.jpg",
                    "taskName": "黎明杀机_1",
                    "taskType": 100,
                    "taskDescription": null
                }
            }
        }

    }
</script>

<style>

</style>
