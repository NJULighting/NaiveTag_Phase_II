<template>
    <el-card>
        <el-container>
            <el-aside>
                <img src='/src/assets/logo.png'>
            </el-aside>

            <el-main>
                <el-container>
                    <el-aside>
                        <div>{{task.taskName}}</div>
                        <div>任务进度:{{task.progress}}</div>
                    </el-aside>
                    <el-main>
                        <div>3积分/10张</div>
                    </el-main>
                </el-container>

            </el-main>
        </el-container>
    </el-card>
</template>

<script>
    export default {
        name: "taskBox",
        props: ['task']
    }
</script>

<style scoped>

</style>