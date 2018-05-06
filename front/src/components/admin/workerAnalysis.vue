<template>
    <div>

            <div >
                <h2>截止 {{new Date().toLocaleString()}}</h2>
                <h2>共有 {{totalWorker}} 名工人注册了 NaiveTag</h2>

            </div>

        <el-col :offset="5">

            <line-chart
                    unique-id="01"
                    :x-data="xData"
                    :series-name="seriesName"
                    :series-data="seriesData"
                    title="工人人数">


            </line-chart>
        </el-col>
    </div>
</template>

<script>
    import LineChart from "~/components/common/lineChart";
    import {fetchAdminDetail} from "~/api/adminDetail";

    export default {
        name: "worker",
        components: {LineChart},
        data: function () {
            return {
                xData: [],
                seriesData: [],
                seriesName: ['当天活跃人次', '累计注册人数'],
                totalWorker: Number
            }
        },
        created: function () {
            this.drawLineChart()
        },
        methods: {
            drawLineChart() {

                fetchAdminDetail(res => {
                    let totalWorkerTrend = [], activeWorkerTrend = [];

                    for (let key in res.totalWorkerTrend) {
                        this.xData.push(key);
                        totalWorkerTrend.push(res.totalWorkerTrend[key]);
                        activeWorkerTrend.push(res.activeWorkerTrend[key]);
                        console.log('----------------')
                        console.log(res.totalWorkerTrend[key]);
                        console.log(key);

                    }
                    this.seriesData.push(activeWorkerTrend, totalWorkerTrend);
                    this.totalWorker = totalWorkerTrend[totalWorkerTrend.length - 1];
                })
            }
        }
    }
</script>

<style scoped>

</style>