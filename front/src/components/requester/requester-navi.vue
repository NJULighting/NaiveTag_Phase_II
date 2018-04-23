<template>

    <div style="height: 100%;">
        <el-row style="background-image: url('/src/assets/bar.png');width: 100%;height: 60px;">
            <el-col :span="4" class="height">
                <div class="height logo">
                    <div class="height center">Naive Tag</div>
                </div>
            </el-col>

            <el-col :span="6" :offset="6" class="height">
                <div class="height">
                    <el-menu mode="horizontal" class="el-menu-demo height" default-active="/requester/home"
                             background-color="transparent"
                             text-color="white"
                             active-text-color="white"
                             :router="true">
                        <el-menu-item class="height center" index="/requester/home">首页</el-menu-item>
                        <el-menu-item class="height center" index="/requester/createTask">创建任务</el-menu-item>
                        <el-menu-item class="height center" index="/requester/requesterDetail">个人详情</el-menu-item>
                    </el-menu>

                </div>
            </el-col>

            <el-col :offset="5" :span="2">
                <img  src="../../assets/van.jpg" n  v-popover:headMenu  alt="头像" class="headpic" >
            </el-col>
            <el-popover
                ref="headMenu"
                placement="bottom"

                class="my-popover"
                >
                <el-button  @click="logout"  style="width: 100px" type="text">退出登录</el-button>
            </el-popover>

        </el-row>


    </div>


</template>

<script>
    export default {
        name: "navi-requester",
        methods:{
            logout:function () {

                this.$router.push('/login');
            }
        }
    }
</script>

<style scoped>

    .center {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .height {
        height: 100%;
    }

    .headpic {

        border-radius: 30px 30px 30px 30px;
        height: 60px;
        width: 60px;
        cursor:pointer;
    }
    .my-popover{
        min-width: 0px !important;
        width: 80px;
    }


</style>