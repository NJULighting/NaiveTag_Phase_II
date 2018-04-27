<template>
    <navi>
        <el-col :span="6" :offset="6" class="height" slot="menu">
            <div class="height">
                <el-menu mode="horizontal" class="el-menu-demo height" default-active="/admin/home"
                         background-color="transparent"
                         text-color="white"
                         active-text-color="white"
                         :router="true">
                    <el-menu-item class="height center" index="/admin/home">任务分析</el-menu-item>
                    <el-menu-item class="height center" index="/admin/user">用户分析</el-menu-item>
                </el-menu>

            </div>
        </el-col>
    </navi>

</template>

<script>
    import Navi from "~/components/common/navi";
    export default {
        name: "adminNavi",
        components: {Navi}
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

</style>