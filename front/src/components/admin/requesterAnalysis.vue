<template>
    <div>
        <el-col :offset="5" >
            <line-chart
                    :x-data="xData"
                    :series-data="seriesData"
                    unique-id="00"
                    :series-name="seriesName"
                    title="发布者总人数变化曲线">

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
                seriesName: ['发布者人数趋势']
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
                this.seriesData.push(seriesItem);
            })
        }
    }
</script>

<style scoped>

</style>