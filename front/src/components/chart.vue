<template>
    <div :id=this.uniqueId style="width: 600px;height:400px;">

    </div>
</template>
s
<script>

    /**
     *因为最终是将图表渲染到上面模板中的容器里，渲染的时候根据Id找到容器，
     * 所以当页面中有多个图表时，每个容器应有不相同的ID
     * echarts 官方文档  http://echarts.baidu.com/tutorial.html#5%20%E5%88%86%E9%92%9F%E4%B8%8A%E6%89%8B%20ECharts
     */

    export default {
        name: "lineChart",
        props: ['title', 'data', 'type','seriesName','uniqueId'],
        mounted: function () {
            this.drawLineChart();
        },
        methods: {
            drawLineChart: function () {
                let lineChart = this.$echarts.init(document.getElementById(this.uniqueId));
                let option = {
                    title: {text: this.title},
                    xAxis: {
                        data: []
                    },
                    tooltip: {},
                    yAxis: {},
                    series: [{
                        name: this.seriesName,
                        type: this.type,
                        data: []
                    }],

                };


                for (let key in this.data){
                    option.xAxis.data.push(key);
                    option.series[0].data.push(this.data[key]);
                }

                lineChart.setOption(option)
            }
        }
    }
</script>

<style scoped>

</style>