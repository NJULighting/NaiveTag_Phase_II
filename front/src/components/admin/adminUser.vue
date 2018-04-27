<template>
    <el-col :offset="3" :span="18">
        <el-tabs type="border-card">
            <el-tab-pane label="工人分析">
                <worker-analysis></worker-analysis>
            </el-tab-pane>
            <el-tab-pane label="发布者分析">
                <requester-analysis>

                </requester-analysis>
            </el-tab-pane>
        </el-tabs>
    </el-col>
</template>

<script>
    import RequesterAnalysis from "~/components/admin/requesterAnalysis";
    import WorkerAnalysis from "~/components/admin/workerAnalysis"
    export default {
        name: "adminUser",
        components: {RequesterAnalysis,WorkerAnalysis}
    }
</script>

<style scoped>

</style>