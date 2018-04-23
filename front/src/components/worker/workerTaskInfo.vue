<template>
    <div id="taskinfo" >
        <simplenavi></simplenavi>

        <div style="height: 20px">

        </div>

        <div style="padding-left: 50px;padding-right: 50px;">
            <div>
                <el-row>

                    <el-col :span="16" class="height"><div class="height">
                        <span class="title">{{taskName}}</span>

                        <label class="label type center inline">
                            <span class="label text">{{taskTypeName()}}</span>
                        </label>

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

            clickPicList(picUrl){
                if(this.state && (this.state === "accept")){
                    this.$emit('tagPicList', picUrl+"");
                }
            },

            accept () {
                let result = taskAccept(this.$route.params.taskId, res=> {
                    console.log("accept result: ");
                    console.log(res.result);
                    if(res.result){
                        this.$emit('refreshData');
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
        font-family: "Caviar Dreams";
    }

    .logo {
        text-align: center;
        font-family: 'Caviar Dreams';
        font-size: 36px;
        color: white;
    }

    label {
        margin-bottom: 5px;
        display:inline-block;
        border-radius: 13px 13px 13px 13px;
        width: 60px;
        height: 25px;
        text-align: center;
        vertical-align: middle;
    }

    .label.type {
        background-color:#336fff;
    }

    .label.text {
        color: white;
        font-size: 13px;
        font-family: Microsoft YaHei;
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
        font-size: 30px;
        font-family: SimSun-ExtB;
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