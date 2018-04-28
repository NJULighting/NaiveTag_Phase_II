<template>
    <div>
        <div :id=this.uniqueId style="width: 600px;height:400px;">

        </div>
    </div>
</template>

<script>

    /**
     *因为最终是将图表渲染到上面模板中的容器里，渲染的时候根据Id找到容器，
     * 所以当页面中有多个图表时，每个容器应有不相同的ID
     * echarts 官方文档  http://echarts.baidu.com/tutorial.html#5%20%E5%88%86%E9%92%9F%E4%B8%8A%E6%89%8B%20ECharts
     */

    export default {
        name: "lineChart",
        props: ['title', 'xData', 'seriesData', 'seriesName', 'uniqueId'],
        watch: {
            seriesData: {
                handler: function () {
                    console.log('lineChange')
                    console.log(this.seriesData)
                    this.drawLineChart();
                },
                deep: true

            }


        },
        methods: {
            drawLineChart: function () {

                let color = ['#8e44ad', '#e67e22', '#3498db', '#e74c3c']
                let lineChart = this.$echarts.init(document.getElementById(this.uniqueId));
                let option = {
                    title: {text: this.title},
                    xAxis: {
                        data: this.xData
                    },
                    legend: {
                        data: [],

                    },
                    tooltip: {},
                    yAxis: {},
                    series: [],

                };


                for (let i = 0; i < this.seriesData.length; i++) {
                    let seriesItem = {};
                    seriesItem.name = this.seriesName[i];
                    seriesItem.type = 'line';
                    seriesItem.data = [];
                    option.legend.data.push(seriesItem.name);
                    let itemData = this.seriesData[i];
                    for (let key in itemData) {
                        seriesItem.data.push(itemData[key]);
                    }
                    seriesItem.lineStyle = {
                        normal: {
                            color: color[i],
                        }
                    };

                    option.series.push(seriesItem);
                }

                // for (let key in this.data){
                //     option.xAxis.data.push(key);
                //     option.series[0].data.push(this.data[key]);
                // }
                console.log('series')
                console.log(this.seriesData);
                lineChart.setOption(option)
            }
        }
    }
</script>

<style scoped>

</style>