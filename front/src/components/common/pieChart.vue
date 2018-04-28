<template>
    <div :id=this.uniqueId style="width: 100%;height:400px;">
    </div>
</template>

<script>
    export default {
        name: "pieChart",
        props: ['name', 'data', 'uniqueId'],
        mounted: function () {
            this.drawPieChart();
        },
        watch:{
            'data':function () {
                this.drawPieChart();
            }
        },
        methods: {

            drawPieChart: function () {
                let myColor=['#1abc9c','#8e44ad','#e67e22','#3498db','#e74c3c'];
                let option = {
                    tooltip:{           //提示框

                    },
                    series: {
                        type: 'pie',
                        center:['50%','50%'],
                        data: [],
                        // itemStyle:{
                        //     normal:{
                        //         color:function () {
                        //             return
                        //         }
                        //     }
                        // }
                    },
                    color:myColor

                };

                for (let i = 0; i < this.name.length; i++) {
                    option.series.data.push({
                        name: this.name[i],
                        value: this.data[i]
                    })

                }

                this.$echarts.init(document.getElementById(this.uniqueId)).setOption(option)
            }
        }
    }
</script>

<style scoped>

</style>