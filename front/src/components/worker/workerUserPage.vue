<template>
    <div id="user">
        <el-row type="flex" class="row-bg center" justify="space-around">

            <el-col :span="5"><div class="grid-content">
                <userinfo v-bind="userInfo"></userinfo>
            </div></el-col>

            <el-col :span="8"><div class="grid-content" style="text-align: center;">
                <div style="height: 90px;"></div>
                <!--<div style="width: 600px;">个人能力变换曲线</div>-->

                <line-chart

                        v-bind:x-data="xData"
                        :series-data="userData"
                        unique-id="-1"
                        :series-name="lineData">

                </line-chart>
            </div></el-col>

            <el-col :span="5"><div class="grid-content">
                <div style="height: 60px;"></div>
                <div style="width: 250px;text-align: center;">排行榜</div>
                <el-table
                        :data="tableData"
                        height="400"
                        style="width: 301px">
                    <el-table-column
                            prop="name"
                            label="昵称"
                            width="200">
                    </el-table-column>
                    <el-table-column
                            prop="score"
                            label="分数"
                            width="100">
                    </el-table-column>
                </el-table>

            </div></el-col>

        </el-row>


    </div>
</template>

<script>
    import userinfo from './workerUserInfo.vue'

    import {userInfo} from '../../api/workerInfo.js'
    import {ability} from '../../api/workerInfo.js'
    import {rank} from '../../api/workerInfo.js'
    import LineChart from "../common/lineChart.vue";

    export default {

        components: {
            LineChart,
            userinfo: userinfo,

        },

        created: function () {
            let result1 = userInfo(res=> {
                this.userInfo = res;
            });
            let result2 = ability(res=> {
                console .log('result2');
                console.log(res);
                this.userData .push(res) ;
                for (let i=0;i<res.length;i++){
                    this.xData.push('第'+(i+1)+'次');
                }
            });
            let result3 = rank(res=> {
                this.tableData = res;
            });



        },

        data() {
            return {

                lineData: [
                    "个人分数曲线",
                ],

                tableData: [
//                    {
//                        "score": 99,
//                        "name": "昵称2"
//                    },
//                    {
//                        "score": 99,
//                        "name": "昵称2"
//                    }
                ],

                userInfo: {
//                    "username": "用户名", //用户名
//                    "name": "昵称", //昵称
//                    "email": "123456@163.com", // 用户注册邮箱
//                    "rank": "24", //用户群体排名
//                    "averageScoreRatio": 67, //用户得分占满分的比例，相当于能力值
//                    "totalScore": 900 //用户赚取的总得分
                },

                userData: [1],
                xData:[]
            }
        },
    }
</script>

<style>
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }

    .row-bg {
        padding: 10px 0;
        height: 100%;
    }

    .center {
        display:flex;
        justify-content:center;
        align-items:center;
    }
</style>
