<template>
    <div id="taskinfo" >
        <div style="height: 100%;" >
            <el-row style="background-image: url('/src/assets/bar.png');width: 100%;height: 60px;" >

                <el-col :span="4" class="height"><div class="height logo">
                    <div class="height center">Naive Tag</div>
                </div></el-col>

                <el-col :span="20" class="height"><div class="height">
                    <button type="text" class="height center back"  v-on:click="back">返回</button>
                </div></el-col>

            </el-row>
        </div>

        <div style="height: 20px">

        </div>

        <div style="padding-left: 50px;padding-right: 50px;">
            <div>
                <el-row>

                    <el-col :span="16" class="height"><div class="height">
                        <span class="title">{{taskName}}</span>

                        <div class="inline">
                            <label class="label type center">
                                <span class="label text">{{taskTypeName()}}</span>
                            </label>
                        </div>


                        <p></p>
                        <span>描述：{{taskDescription}}</span>
                        <p></p>
                        <span>总积分：{{averageScore}}分</span>
                        <span class="away">图片：{{getPicAmount()}}张</span>
                        <span v-if="finishedPicList" class="away">已标注：{{getPicFinishAmount()}}张</span>
                        <p></p>

                        <div v-if="payDay" class="date">
                            <span>End: {{payDay}}</span>
                        </div>

                        <div v-if="beginDate && endDate" class="date">
                            <span>Start: {{beginDate}}</span>
                            <span class="away">End: {{endDate}}</span>
                        </div>

                        <p></p>
                    </div></el-col>

                    <el-col :span="8"><div class="center" style="padding-top: 100px;">
                        <button v-if="canAccept === true" class="center button" v-on:click="accept()">接受</button>
                        <button v-else-if="canAccept === false && !state" class="center button accept">不可接受</button>
                        <button v-else-if="finishedPicList && unfinishedPicList.length === 0" class="center button" v-on:click="submit()">提交</button>
                        <button v-else-if="state" class="center button accept">{{getState()}}</button>
                    </div></el-col>

                </el-row>
            </div>

            <div>
                <p></p>
                <span>图片列表：</span>
                <p></p>

                <img v-if="picList" v-on:click="clickPicList(picture)" v-for="(picture, index) in picList"  :src="getPicSrc(picture)" alt="Image" style="padding: 10px;width: 15%;">
                <el-tabs v-if="unfinishedPicList && finishedPicList" v-model="activeName2" type="card">

                    <el-tab-pane label="未标注" name="first">
                        <img v-on:click="clickPicList(picture)" v-for="(picture, index) in unfinishedPicList"  :src="getPicSrc(picture)" alt="Image" style="padding: 10px;width: 15%;">
                    </el-tab-pane>
                    <el-tab-pane label="已标注" name="second">
                        <img v-on:click="clickPicList(picture)" v-for="(picture, index) in finishedPicList"  :src="getPicSrc(picture)" alt="Image" style="padding: 10px;width: 15%;">
                    </el-tab-pane>
                </el-tabs>
            </div>

        </div>

    </div>

</template>

<script>

    import simplenavi from './simpleNavi.vue'
    import Vue from 'vue'
    import {taskAccept} from '../../api/taskDetails.js'
    import {submit} from '../../api/workerSubmit.js'

    export default {

        components: {
            'simplenavi': simplenavi
        },

        props: {
            state: String, // 已经接受的任务unaccept
            taskName: String,
            taskType: Number,
            taskDescription: String,
            averageScore: Number,

            picList: Array,
            payDay: String, // 任务的最终截止时期
            canAccept: Boolean, // true or false  因为有的任务用户不可以接受

            finishedPicList: Array,
            unfinishedPicList: Array,
            beginDate: String,
            endDate: String, // 任务最终截止时期和任务的过期时间的较小值

            earnedScore: Number
        },

        data() {
            return {
                activeName2: 'first',
            };
        },

        methods: {

            back(){
                this.$router.push({ name: 'workerHome'});
            },

            clickPicList(picUrl){
                if(this.state && (this.state === "accept")){
                    this.$emit('tagPicList', picUrl+"");
                }
            },

            submit () {
                let result = submit(this.$route.params.taskId, res=> {
                    console.log("submit result: ");
                    console.log(res.result);
                    if(res.result){
                        this.$emit('refreshData');
                    }
                });
            },

            accept () {
                let result = taskAccept(this.$route.params.taskId, res=> {
                    console.log("accept result: ");
                    console.log(res.result);
                    if(res.result){
                        this.$emit('refreshData');
                        this.$message.info('点击任意一张图片开始进行标注！');
                    }
                });
            },

            getPicSrc: function (picUrl) {
                console.log("addPicSrc");
                return "http://localhost:8000/naive/" + picUrl;
            },

            getPicFinishAmount: function () {
                return this.finishedPicList.length;
            },

            getPicAmount: function () {
                if(this.picList){
                    return this.picList.length;
                }
                if(this.finishedPicList && this.unfinishedPicList){
                    return this.finishedPicList.length + this.unfinishedPicList.length;
                }
            },

            getState: function () {

                switch (this.state){
                    case "unaccept":
                        return "未接受";
                        break;
                    case "accept":
                        return "已接受";
                        break;
                    case "finish":
                        return "已完成";
                        break;
                    case "unpay":
                        return "未结算";
                        break;
                    case "fail":
                        return "已过期";
                        break;
                    default:
                        return "unknown";
                        break;
                }
            },

            taskTypeName: function () {
                switch (this.taskType){
                    case 100:
                        return "整体标"
                        break;
                    case 101:
                        return "整体注"
                        break;
                    case 200:
                        return "单框标"
                        break;
                    case 201:
                        return "单框注"
                        break;
                    case 300:
                        return "多框标"
                        break;
                    case 301:
                        return "多框注"
                        break;
                    case 400:
                        return "边界注"
                        break;
                    case 401:
                        return "边界标注"
                        break;
                    default:
                        break;
                }
            }
        }

    }

</script>

<style>

    .date {
        font-size: 20px;
    }

    .logo {
        text-align: center;
        font-size: 36px;
        color: white;
    }

    label {
        display:inline-block;
        border-radius: 8px;
        width: 45px;
        height: 18px;
        text-align: center;
    }

    .label.type {
        background-color:#336fff;
    }

    .label.text {
        color: white;
        font-size: 11px;

        display:flex;
        justify-content:center;
        align-items:center;
    }

    .button {
        width: 150px;
        height: 45px;
        color: #336fff;
        padding-left: 10px;
        background-color: white;
        border-radius: 10px 10px 10px 10px;
        font-size: 18px;
        border: none;
        border-color: #336fff;
        cursor: pointer;
        cursor: hand;

        text-align:center;
        border:1px solid #336fff;
        outline:none;
        box-shadow:none;
    }

    .button:hover {
        color: white;
        background-color: #336fff;
    }

    .button.accept {
        color: grey;
        border-color: grey;
        border:1px solid grey;
        cursor: default;
    }

    .button.accept:hover {
        background-color: white;
    }

    .back {
        color: white;
        padding-left: 10px;
        background-color: transparent;
        font-size: 14px;
        border: 0px;
        cursor: pointer;
        cursor: hand;
    }

    .back:hover {
        color: #336fff;
    }

    .title {
        font-size: 24px;
    }

    .center {
        display:flex;
        justify-content:center;
        align-items:center;
    }

    .height {
        height: 100%;
    }

    .inline {
        display:inline-block;
    }

    .away {
        padding-left: 50px;
    }

</style>