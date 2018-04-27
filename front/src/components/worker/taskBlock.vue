<template>
    <div class="taskBlock" id="app" v-on:click="showTask">
        <div style="padding: 10px">
            <el-card :body-style="{ padding: '0px' }">

                <img :src="getCover" alt="CoverImage" class="image">

                <div style="padding: 14px;">

                    <span>{{taskName}}</span>

                    <!--标注类型和状态-->
                    <div class="inline">

                        <label class="label type">
                            <span class="label text">{{taskTypeName()}}</span>
                        </label>

                        <label v-if="state === 'doing'" class="label going">
                            <span class="label text">进行中</span>
                        </label>

                        <label v-else-if="state === 'finish'" class="label finish">
                            <span class="label text">已完成</span>
                        </label>

                        <label v-else-if="state === 'unpay'" class="label unclaimed">
                            <span class="label text">等待结算</span>
                        </label>

                        <label v-else-if="state === 'expired'" class="label expired">
                            <span class="label text">已过期</span>
                        </label>

                    </div>

                    <div class="bottom clearfix">

                        <!--积分和实际分数-->
                        <div>
                        <span v-if="actualScore">
                            <span style="color: #00af43;">{{taskActualScore()}}</span><!--
                            --><span>/</span><!--
                        --></span><!--
                        --><span>{{averageScore}}分</span>

                            <div class="inline" style="float: right" v-if="picAmount">
                                <span>{{picAmount}}张</span>
                            </div>

                        </div>

                        <!--图片张数和截止日期-->


                        <div class="bottom">
                            <time v-if="payDay" class="time"  style="float: right">PAYDAY：{{payDay}}</time>
                        </div>

                        <!--进度条-->
                        <div v-if="process || process === 0" class="part margin">
                            <el-progress :percentage="getProcess" color="#336fff"></el-progress>
                        </div>

                        <!--开始日期、结束日期-->
                        <div class="bottom">
                            <time v-if="beginDate" class="time" style="float: left">FROM：{{beginDate}}</time>
                            <time v-if="endDate" class="time" style="float: right">TO：{{endDate}}</time>
                        </div>

                    </div>
                </div>

            </el-card>
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

            getProcess: function () {
                return this.process*100;
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
    img {
        width: 100%;
    }

    .taskBlock {
        display:inline-block;
        cursor: pointer;
        cursor: hand;
        text-align: left;
        width: 20%;
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
        font-size: 11px;

        display:flex;
        justify-content:center;
        align-items:center;
    }

    .part.margin {
        margin-bottom: 5px;
    }

    .inline {
        display:inline-block;
    }

    .time {
        font-size: 13px;
        color: #999;
    }

    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }

    .image {
        width: 100%;
        display: block;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }

</style>
