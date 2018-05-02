<template>
    <div id="navi"  style="background-image: url('/src/assets/fish.gif');width: 100%;height: 100%;
    background-attachment: fixed;background-position: bottom;background-repeat: no-repeat;">
        <div>
            <div style="height: 100%;" >
                <el-row style="background-image: url('/src/assets/bar.png');width: 100%;height: 60px;" >

                    <div class="height center" style="width: 250px;float: left;">
                        <img src="../../assets/naive_tag.png" style="height: 50px;width: auto;"
                             ondragstart="return false;"
                             oncontextmenu="return false;">
                    </div>

                    <el-input
                            v-model="inputText"
                            placeholder="任务搜索"
                            suffix-icon="el-icon-search"
                            class="height center"
                            style="width: 30%;float: left;width: 300px;"
                            @keyup.enter.native="doSearch">
                    </el-input>

                    <div class="height center" style="float: right;">
                        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524925264310&di=352a1b66a7c3a19fbead4a34f647ceea&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171220%2F48ac3a79109e4cdfa853391fa37e6540.jpeg" alt="headPicture" class="headpic" v-on:click="showUserInfo"
                             ondragstart="return false;"
                             oncontextmenu="return false;">
                    </div>

                    <div style="width: 250px;height: 100%;float: right;">
                        <el-menu :default-active="activeIndex" class="el-menu-demo height" mode="horizontal"
                                 background-color= "transparent"
                                 text-color="white"
                                 active-text-color="white"
                                 :router="true">

                            <el-menu-item class="height center" index="/worker/home">首页</el-menu-item>
                            <el-menu-item class="height center" index="/worker/history">历史任务</el-menu-item>
                            <button type="text" class="height center exit" @click="exit">退出登录</button>

                        </el-menu>
                    </div>

                </el-row>
            </div>

            <div style="height: 100%;">
                <router-view style="height: 100%"></router-view>
            </div>
        </div>


    </div>

</template>

<script>

    export default {

        data () {
            return {
                activeIndex : "/worker/home",
                inputText: ""
            }
        },

        methods:{

            showUserInfo() {
                this.$router.push("/worker/user");
            },

            doSearch() {
//                this.$router.push("/worker/search");
                this.$router.push({ name: 'search', params: { key: this.inputText }});
            },

            exit() {

                this.$confirm('您确定要退出登录吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {

                    this.$router.push("/login");
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
        border: none;
        cursor: pointer;
        cursor: hand;
        outline:none;
    }

    .exit:hover {
        color: #336fff;
        outline:none;
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
        cursor: pointer;
        cursor: hand;
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