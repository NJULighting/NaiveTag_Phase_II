<template>
<div>
    <div>
        <el-row>
            <el-col :span="24">
                <navi></navi>
            </el-col>
        </el-row>
    </div>

    <div>
      <router-view></router-view>
    </div>
</div>

</template>

<script>
    import navi from './requester-navi.vue';
    export default {
        name: "index-requester",
        components:{navi},
    }
</script>

<style scoped>

</style>