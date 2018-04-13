<template>
    <div id="simpleNavi">
        <div style="height: 100%;" >
            <el-row style="background-image: url('/src/assets/bar.png');width: 100%;height: 60px;" >

                <el-col :span="4" class="height"><div class="height logo">
                    <div class="height center">Naive Tag</div>
                </div></el-col>

                <el-col :span="20" class="height"><div class="height">
                    <button type="text" class="height center back"  v-on:click="$router.history.go(-1)">返回</button>
                </div></el-col>

            </el-row>
        </div>
    </div>
</template>

<script>

    export default {

    }
</script>

<style>
    .back {
        color: white;
        padding-left: 10px;
        background-color: transparent;
        font-size: 14px;
        border: 0px;
        cursor: pointer;
        cursor: hand;
    }

    .back:hover {
        color: #336fff;
    }

    .logo {
        text-align: center;
        font-family: 'Caviar Dreams';
        font-size: 36px;
        color: white;
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
