<template>
    <div>
      <el-col :offset="5">

          <line-chart
                  unique-id="01"
                  :x-data="xData"
                  :series-name="seriesName"
                  :series-data="seriesData"
                  title="工人人数变化曲线">


          </line-chart>
          <div>
              <h2>截止{{new Date().toLocaleString()}}</h2>
          </div>
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
                seriesName: ['当天活跃工人数', '总工人数']
            }
        },
        created: function () {
            this.drawLineChart()
        },
        methods: {
            drawLineChart() {

                fetchAdminDetail(res => {
                    let totalWorkerTrend = []
                    let activeWorkerTrend = [];
                    for (let key in res.totalWorkerTrend) {
                        this.xData.push(key);
                        totalWorkerTrend.push(res.totalWorkerTrend[key]);
                        activeWorkerTrend.push(res.activeWorkerTrend[key]);
                    }
                    this.seriesData.push(activeWorkerTrend, totalWorkerTrend);

                })
            }
        }
    }
</script>

<style scoped>

</style>