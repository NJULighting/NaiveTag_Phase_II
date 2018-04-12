<template>
    <div id="task" >
        <div style="height: 100%; position: fixed; top:0; left:0; right:0;" >
            <el-row style="background-image: url('./src/assets/bar.png');width: 100%;height: 60px;" >

                <el-col :span="4" class="height"><div class="height logo">
                    <div class="height center">Naive Tag</div>
                </div></el-col>

                <el-col :span="20" class="height"><div class="height">
                    <button type="text" class="height center back">返回</button>
                </div></el-col>

            </el-row>
        </div>

        <div style="height: 70px">

        </div>

        <div style="padding-left: 50px;padding-right: 50px;">
            <div>
                <el-row>

                    <el-col :span="16" class="height"><div class="height">
                        <span class="title">区域标注任务（一）</span>

                        <label class="label type center inline">
                            <span class="label text">区域注</span>
                        </label>

                        <p>描述：这是一个区域标注类型的任务，标注者需要将目标区域画出，并写上详细描述</p>
                        <span>总积分：67</span>
                        <span class="away">图片：88张</span>
                        <p></p>

                        <div class="date">
                            <span>End: xxxx/xx/xx xx:xx:xx</span>
                        </div>

                        <div class="date">
                            <span>Start: xxxx/xx/xx xx:xx:xx</span>
                            <span class="away">End: xxxx/xx/xx xx:xx:xx</span>
                        </div>

                        <p></p>
                    </div></el-col>

                    <el-col :span="8"><div class="center" style="padding-top: 100px;">
                        <button class="center button">接受</button>
                        <button class="center button accept">已接受</button>
                    </div></el-col>

                </el-row>
            </div>

            <div>
                <el-tabs v-model="activeName2" type="card">
                    <el-tab-pane label="未标注" name="first">
                        <img v-for="picture in finishedPicList"  :src="picture" alt="Image">
                    </el-tab-pane>
                    <el-tab-pane label="已标注" name="second">已标注</el-tab-pane>
                </el-tabs>
            </div>

        </div>

    </div>

</template>

<script>

    import task_block from '../taskBlock.vue';

    export default {

        data() {
            return {
                activeName2: 'first',
                taskData: {
                    taskState: String, // 已经接受的任务unaccept
                    taskName: String,
                    taskType: Number,
                    taskDescription: String,
                    averageScore: Number,

                    picList: Array,
                    payDay: String, // 任务的最终截止时期
                    canAccept: String, // true or false  因为有的任务用户不可以接受

                    finishedPicList: Array,
                    unFinishedPicList: Array,
                    beginDate: String,
                    endDate: String // 任务最终截止时期和任务的过期时间的较小值
                },
            };
        },

        created: function () {
            console.log('taskData is: ' + this.taskData);
        },

        components: {
            'task_block': task_block
        },

    }

</script>

<style>

    .date {
        font-size: 24px;
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