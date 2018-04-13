<template>
    <el-menu mode="horizontal" default-active="/requester/home" :router="true">
        <el-menu-item index="/requester/home">首页</el-menu-item>
        <el-menu-item index="/requester/createTask">创建任务</el-menu-item>
        <el-menu-item index="3">统计信息</el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "navi-requester",
    }
</script>

<style scoped>

</style>