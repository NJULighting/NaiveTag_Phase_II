<template>
    <div>
        <el-col :offset="5" >
            <div >
                <h2>截止 {{new Date().toLocaleString()}}</h2>
                <h2>共有 {{totalRequester}} 名发布者注册了 NaiveTag</h2>

            </div>
            <line-chart
                    :x-data="xData"
                    :series-data="seriesData"
                    unique-id="00"
                    :series-name="seriesName"
                    title="发布者注册人数变化曲线">

            </line-chart>
        </el-col>
    </div>
</template>

<script>
    import {fetchAdminDetail} from "~/api/adminDetail";
    import LineChart from "~/components/common/lineChart";

    export default {
        name: "requesterAnalysis",
        components: {LineChart},
        data: function () {
            return {
                xData: [],
                seriesData: [],
                seriesName: ['发布者注册人数'],
                totalRequester:Number
            }
        },
        created: function () {
            fetchAdminDetail(res => {
                let metaData = res.totalRequesterTrend;
                let seriesItem = [];
                for (let key in metaData) {
                    this.xData.push(key);
                    seriesItem.push(metaData[key]);
                }

                console.log('NNNNNNNN');
                console.log(Object.values(res.totalRequesterTrend)[Object.values(res.totalRequesterTrend).length-1]);
                this.totalRequester=Object.values(res.totalRequesterTrend)[Object.values(res.totalRequesterTrend).length-1];
                this.seriesData.push(seriesItem);
            })
        }
    }
</script>

<style scoped>

</style>