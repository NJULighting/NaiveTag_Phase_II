<template>
   <div style="width: 100%;">
     <el-col :offset="3" :span="18">
         <el-card >
             <pie-chart
                     :name="this.pieChartName"
                     :data="this.pieChartData"
                     unique-id="00"
             >
             </pie-chart>
         </el-card>
     </el-col>


   </div>
</template>

<script>

    import PieChart from "~/components/common/pieChart";
    import {fetchAdminDetail} from "~/api/adminDetail";
    export default {
        name: "adminHome",
        components: {PieChart},
        data:function () {
            return{
                adminDetail:undefined,
                pieChartName:['进行中的任务','已完成的任务'],
                pieChartData:[]
            }
        },
        created:function () {
            fetchAdminDetail(res=>{

                this.adminDetail=res;
                this.pieChartData.push(res.taskQuantity-res.completedTask);
                this.pieChartData.push(res.completedTask);
            })
        }

    }
</script>

<style scoped>

</style>