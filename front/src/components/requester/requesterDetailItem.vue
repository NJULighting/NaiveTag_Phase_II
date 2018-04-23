<template>
    <div class="detail-items">
        <div class="detail-items-title">
            <span>{{this.label}}</span>
        </div>
        <div class="detail-items-content">
            <span>{{this.content}}</span>
            <!--<slot name="button" >-->
                <!---->
            <!--</slot>-->
            <el-button v-if="buttonName" @click="func" type="text" class="detail-items-button">{{this.buttonName}}</el-button>
        </div>

    </div>
</template>

<script>
    export default {
        name: "requesterDetailItem",
        props:['label','content','func','buttonName'],
        data:function () {
            return{

            }
        }
    }
</script>

<style scoped>
    .detail-items {
        display: flex;
        margin: 20px;
    }

    .detail-items-title {
        height: 25px;
        width: 120px;

    }

    .detail-items-content {
        height: 25px;
        width: 65px;
        display: flex;
    }
    .detail-items-button{
        padding: 0 ;
        margin-left: 15px;
    }
</style>