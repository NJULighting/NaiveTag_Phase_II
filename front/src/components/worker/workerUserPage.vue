<template>
    <div id="user" style="text-align: center">

        <el-row>

            <el-col :span="8"><div class="grid-content bg-purple" style="text-align: center">

            </div></el-col>

            <el-col :span="8"><div class="grid-content bg-purple-light">
                <userinfo v-bind="userInfo"></userinfo>
            </div></el-col>

            <el-col :span="8"><div class="grid-content bg-purple" style="text-align: center">

            </div></el-col>

        </el-row>


    </div>
</template>

<script>
    import userinfo from './workerUserInfo.vue'

    export default {

        components: {
            userinfo: userinfo
        },

        data() {
            return {
                userInfo: {
                    "username": "用户名", //用户名
                    "name": "昵称", //昵称
                    "email": "123456@163.com", // 用户注册邮箱
                    "rank": "24", //用户群体排名
                    "averageScoreRatio": 67, //用户得分占满分的比例，相当于能力值
                    "totalScore": 900 //用户赚取的总得分
                }
            }
        },
    }
</script>

<style>

</style>
