<template>
    <div style="height: 100%;">
        <el-row style="background-image: url('/src/assets/bar.png');width: 100%;height: 60px;">
            <el-col :span="4" class="height">
                <div class="height logo">
                    <div class="height center">Naive Tag</div>
                </div>
            </el-col>

            <slot name="menu">

            </slot>

            <el-col :offset="5" :span="2">
                <img src="../../assets/van.jpg" n v-popover:headMenu alt="头像" class="headpic">
            </el-col>
            <el-popover
                    ref="headMenu"
                    placement="bottom"
                    class="my-popover">
                <el-button @click="logout" style="width: 100px" type="text">退出登录</el-button>
            </el-popover>
        </el-row>
    </div>
</template>

<script>
    import {getUrl} from "~/api/tool";

    export default {
        name: "navi",
        methods:{
            logout:function () {
                $.get(getUrl('lgo.html'),function () {
                    this.$router.push('/login');
                });

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
        cursor:pointer;
    }
    .my-popover{
        min-width: 0px !important;
        width: 80px;
    }


</style>