<template>

    <navi>
        <el-col :span="6" :offset="6" class="height" slot="menu">
            <div class="height">
                <el-menu mode="horizontal" class="el-menu-demo height" default-active="/requester/home"
                         background-color="transparent"
                         text-color="white"
                         active-text-color="white"
                         :router="true">
                    <el-menu-item class="height center" index="/requester/home">任务列表</el-menu-item>
                    <el-menu-item class="height center" index="/requester/createTask">创建任务</el-menu-item>
                    <el-menu-item class="height center" index="/requester/requesterDetail">个人详情</el-menu-item>
                </el-menu>

            </div>
        </el-col>
    </navi>


</template>

<script>

    import Navi from "~/components/common/navi";

    export default {
        name: "navi-requester",
        components: {Navi},
        methods: {
            logout: function () {

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
        cursor: pointer;
    }

    .my-popover {
        min-width: 0px !important;
        width: 80px;
    }


</style>