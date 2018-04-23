<template>
    <div class="taskBlock" id="app" v-on:click="showTask">

            <span class="taskTitle">{{taskName}}</span>
            <p></p>
            <img :src="getCover" alt="CoverImage">
            <p></p>

            <div>

                <!--积分和实际分数-->
                <div class="part score margin inline">
            <span>
                <span v-if="actualScore">
                    <span class="keynumber">{{taskActualScore()}}</span><!--
                 --><span class="y">/</span><!--
                --></span><!--
                --><span class="y">{{averageScore}}</span><!--
                --><span class="chinese">分</span>
            </span>
                </div>

                <!--标注类型和状态-->
                <div class="part inline">

                    <label class="label inline type">
                        <span class="label text">{{taskTypeName()}}</span>
                    </label>

                    <label v-if="state === 'doing'" class="label inline going">
                        <span class="label text">进行中</span>
                    </label>

                    <label v-else-if="state === 'finish'" class="label inline finish">
                        <span class="label text">已完成</span>
                    </label>

                    <label v-else-if="state === 'unpay'" class="label inline unclaimed">
                        <span class="label text">等待结算</span>
                    </label>

                    <label v-else-if="state === 'expired'" class="label inline expired">
                        <span class="label text">已过期</span>
                    </label>

                </div>

                <!--图片张数和截止日期-->
                <div>
                    <div class="part date margin inline" v-if="picAmount">
                        <span class="keynumber">{{picAmount}}</span>
                        <span>张</span>
                    </div>
                    <div v-if="payDay" class="part date margin inline keyword away">
                        <span class="keyword">End: </span>
                        <span>{{payDay}}</span>
                    </div>
                </div>

                <!--进度条-->
                <div v-if="process" class="part margin">
                    <el-progress :percentage="process" color="#336fff"></el-progress>
                </div>

                <!--开始日期、结束日期-->
                <div class="keyword">
                    <div v-if="beginDate" class="part margin date inline">
                        <span class="keyword">Start: </span>
                        <span>{{beginDate}}</span>
                    </div>
                    <div v-if="endDate" class="part margin date inline">
                        <span class="keyword">End: </span>
                        <span>{{endDate}}</span>
                    </div>

                </div>

            </div>

    </div>
</template>

<script type="text/javascript">
    import router from "../../router/index";
    import {taskName} from '../../api/taskName.js'

    export default {
       // props: ['taskType'],
        name: 'taskblock',
        props: {
            //taskType: 100,
            taskId: Number,
            taskType: Number,
            taskName: String,
            averageScore: Number,
            actualScore: Number, // 实际得到的分数，有可能是-1，比如没有结算
            payDay: String,
            picAmount: Number,
            process: Number,
            cover : String,
            beginDate: String,
            endDate: String,
            state: String // unpay、finish、doing、expired(等待结算、完成、进行、过期)
        },

        computed: {
            getCover: function () {
                return "http://localhost:8000/naive/" + this.cover;
            },
        },

        methods: {

            showTask: function () {
//                this.$router.push("/task");
                this.$router.push({ name: 'task', params: { taskId: this.taskId }});
            },

            taskActualScore: function () {
                if(this.actualScore === -1){
                    return "--"
                }else{
                    return this.actualScore
                }
            },

            taskTypeName: function () {
                let result = taskName(this.taskType);
                return result;
//                switch (this.taskType){
//                    case 100:
//                        return "整体标"
//                        break;
//                    case 101:
//                        return "整体注"
//                        break;
//                    case 200:
//                        return "单框标"
//                        break;
//                    case 201:
//                        return "单框注"
//                        break;
//                    case 300:
//                        return "多框标"
//                        break;
//                    case 301:
//                        return "多框注"
//                        break;
//                    case 400:
//                        return "边界注"
//                        break;
//                    case 401:
//                        return "边界标注"
//                        break;
//                    default:
//                        break;
//                }
            }
        }
    }
</script>

<style>
    p {
        margin: 10px;
    }

    img {
        width: 100%;
    }



    .taskBlock {
        font-family: Microsoft YaHei;
        border-radius: 10px 10px 10px 10px;
        background-color: #eeeeee;
        padding: 25px 25px 20px 25px;
        width: 15%;
        display:inline-block;
        margin: 15px;
        cursor: pointer;
        cursor: hand;
        text-align: left;
    }

    .taskTitle {
        font-family: SimSun-ExtB;
        font-size: 24px;
        width: 100%;
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

    .label.going {
        background-color:#00af43;
    }

    .label.finish {
        background-color:#f6b436;
    }

    .label.unclaimed {
        background-color:#7d7d7d;
    }

    .label.expired {
        background-color:#362e2b;
    }

    .label.text {
        color: white;
        font-size: 13px;
        font-family: Microsoft YaHei;
    }

    .part.margin {
        margin-bottom: 5px;
    }

    .inline {
        display:inline-block;
    }

    .part.score {
        text-align: left;
        vertical-align: middle;
    }

    .part.date {
        font-size: 18px;
    }

    .keynumber {
        color: #00af43;
        font-size: 24px;
    }

    .keyword {
        font-size: 22px;
        font-family: "Caviar Dreams";
    }

    .y {
        font-size: 24px;
        color: black;
    }

    .chinese {
        font-size: 18px;
        color: black;
    }

    .away {
        padding-right: 20px;
    }
</style>
