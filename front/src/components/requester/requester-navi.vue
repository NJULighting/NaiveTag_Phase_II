<template>

    <div style="height: 100%;" >
        <el-row style="background-image: url('/src/assets/bar.png');width: 100%;height: 60px;" >

            <el-col :span="4" class="height"><div class="height logo">
                <div class="height center">Naive Tag</div>
            </div></el-col>

            <el-col :span="20" class="height"><div class="height">
                <el-menu mode="horizontal" class="el-menu-demo height" default-active="/requester/home"
                         background-color= "transparent"
                         text-color="white"
                         active-text-color="white"
                         :router="true">
                    <el-menu-item class="height center" index="/requester/home">首页</el-menu-item>
                    <el-menu-item class="height center" index="/requester/createTask">创建任务</el-menu-item>
                    <el-menu-item class="height center" index="3">统计信息</el-menu-item>
                </el-menu>
            </div></el-col>
        </el-row>
    </div>


</template>

<script>
    export default {
        name: "navi-requester",
    }
</script>

<style scoped>

    .center {
        display:flex;
        justify-content:center;
        align-items:center;
    }

    .height {
        height: 100%;
    }

</style>