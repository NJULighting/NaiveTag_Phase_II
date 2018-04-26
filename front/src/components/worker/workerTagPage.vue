<template>
    <div id="tagPage">
        <simplenavi></simplenavi>
        <tag v-bind:tagType="tagData.tagType"
             v-bind:options="options"
             v-bind:picUrl="getPicUrl"
             :label.sync="tagData.label"
             :points.sync="tagData.points"
             :frames.sync="tagData.frames"
             @lastPic="lastPic"
             @nextPic="nextPic"></tag>
    </div>
</template>

<script>

    import simplenavi from './simpleNavi.vue'
    import tag from './workerTagInfo.vue'
    import {taskInfo} from '../../api/tagPage.js'
    import {getLabelInfo} from '../../api/tagPage.js'
    import {save} from '../../api/tagPic.js'
    import {next} from '../../api/tagPic.js'
    import {previous} from '../../api/tagPic.js'

    export default {

        created: function () {
            this.fetchTagData();
        },

        computed: {
            getPicUrl(){
                return "http://localhost:8000/naive/" + this.picUrl;
            }
        },

        methods: {
            tagPicReflash(picUrl) {
                console.log("picUrl: " + picUrl);
                this.$router.push({ name: 'tag', params: { taskId: this.$route.params.taskId, picUrl: picUrl}});
            },

            lastPic: function () {
                console.log(this.tagData);
                this.saveData();
                let result = previous(this.$route.params.taskId,this.picUrl, res=> {
                    console.log("previousResult:");
                    console.log(res);
                    if(res.url){
                        this.tagPicReflash(res.url);
                    }else{
                        this.$message.info(res.description);
                    }
                });
            },

            nextPic: function () {
                console.log(this.tagData);
                this.saveData();
                let result = next(this.$route.params.taskId,this.picUrl, res=> {
                    console.log("previousResult:");
                    console.log(res);
                    if(res.url){
                        this.tagPicReflash(res.url);
                    }else{
                        this.$message.info(res.description);
                    }
                });
            },

            saveData(){
                console.log(this.tagData);
                var json = JSON.stringify(this.tagData);
                console.log("json: ");
                console.log(json);
                let result = save(this.$route.params.taskId,this.picUrl,json, res=> {
                    console.log("saveResult:");
                    console.log(res);
                });
            },

            fetchTagData () {
                this.picUrl = this.$route.params.picUrl;
                console.log("picUrl" + this.picUrl);
                let result = taskInfo(this.$route.params.taskId, res=> {
                    console.log("taskInfo:");
                    console.log(res);
                    if(res.classes){
                        this.options = this.changeToOptions(res.classes);
                    }
                    if(res.taskType){
                        this.taskType = res.taskType;
                    }
                    console.log("options:");
                    console.log(this.options);
                    this.fetchLabelDataByPicUrl(this.$route.params.picUrl);
                });
            },

            fetchLabelDataByPicUrl(picUrl) {
                let result = getLabelInfo(this.$route.params.taskId, picUrl, res=> {
                    console.log("getLabelInfo:");
                    console.log(res);
                    if(res){
                        this.tagData = res;
                    }else{
                        this.tagData.tagType = "t_" + this.taskType;
                    }
                });
            },

            changeToOptions(classes){
                var options = [];
                for(var value in classes){
                    options.push({
                        value: value,
                        label: classes[value],
                    })
                }
                return options;
            },
        },

        data() {
            return {
                taskType: null,
                picUrl: "",
                options: [
//                    {
//                    value: '0',
//                    label: '黄金糕'
//                }, {
//                    value: '1',
//                    label: '双皮奶'
//                }, {
//                    value: '2',
//                    label: '蚵仔煎'
//                }, {
//                    value: '3',
//                    label: '龙须面'
//                }, {
//                    value: '4',
//                    label: '北京烤鸭'
//                }
                ],
                tagData: {
                    "label": null,
                    "frames":[
                    ],
                    "tagType":"t_100",
                    //若能画，points必有
                    "points":[
                    ],
                },
            }
        },

        components: {
            'simplenavi': simplenavi,
            'tag': tag,
        },

        watch: {
            // 如果路由有变化，会再次执行该方法
            '$route': 'fetchTagData'
        },

    }

</script>

<style>

</style>
