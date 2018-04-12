<template>
    <div id="navi" >
        <div style="height: 100%;" >
            <el-row style="background-image: url('./src/assets/bar.png');width: 100%;height: 60px;" >

                <el-col :span="4" class="height"><div class="height logo">
                    <div class="height center">Naive Tag</div>
                </div></el-col>

                <el-col :span="15" class="height"><div class="height search">
                    <el-input
                            placeholder="任务搜索"
                            suffix-icon="el-icon-search"
                            class="height center"
                            style="width: 30%;">
                    </el-input>
                </div></el-col>

                <el-col :span="4" class="height"><div class="height">
                    <el-menu :default-active="activeIndex" class="el-menu-demo height" mode="horizontal"
                             background-color= "transparent"
                             text-color="white"
                             active-text-color="white"
                             :router="true">

                        <el-menu-item class="height center" index="/Home">首页</el-menu-item>
                        <el-menu-item class="height center" index="/History">历史任务</el-menu-item>
                        <button type="text" class="height center exit" @click="exit">退出登录</button>

                    </el-menu>
                </div></el-col>

                <el-col :span="1" class="height"><div class="height">
                    <img src="../../assets/head.jpg" alt="headPicture" class="headpic">
                </div></el-col>
            </el-row>
        </div>

        <div>
            <router-view></router-view>
        </div>

    </div>

</template>

<script>

    export default {

        data () {
            return {
                activeIndex : "home"
            }
        },

        methods:{

            exit() {

                this.$confirm('您确定要退出登录吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {

                }).catch(() => {

                });


            },

        },
    }

</script>

<style>

    .exit {
        color: white;
        padding-left: 10px;
        background-color: transparent;
        font-size: 14px;
        border: 0px;
        cursor: pointer;
        cursor: hand;
    }

    .exit:hover {
        color: #336fff;
    }

    .search {
        display:inline-block;
        width: 100%;
        text-align: center;
    }

    .logo {
        text-align: center;
        font-family: 'Caviar Dreams';
        font-size: 36px;
        color: white;
    }

    .headpic {
        border-radius: 30px 30px 30px 30px;
        height: 60px;
        width: 60px;
    }

    .center {
        display:flex;
        justify-content:center;
        align-items:center;
    }

    .height {
        height: 100%;
    }
</style>