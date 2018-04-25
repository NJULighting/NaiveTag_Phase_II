<template>
    <canvas ref="canvas" class="canvas"
            ondragstart="return false;" oncontextmenu="return false;"
            v-on:mousedown="onCanvasMouseDown($event)"
            v-on:mousemove="onCanvasMouseMove($event)"
            v-on:mouseup="onCanvasMouseUp($event)"></canvas>
</template>

<script>

    export default {

        props: {
            points: Array,
        },

        data() {
            return {
                isDrawing : false,
                ctx : Object,
            }
        },

        mounted: function () {
            this.ctx = this.$refs.canvas.getContext('2d');
            this.drawPolygon();
        },

        methods: {

            onCanvasMouseDown: function (event) {
                this.points.splice(0, this.points.length);
                this.isDrawing = true;

                this.points.push({
                    x: event.offsetX,
                    y: event.offsetY
                });
                console.log("points:")
                console.log(this.points);

            },

            onCanvasMouseMove: function (event) {
                if (this.isDrawing) {
                    this.ctx.lineTo(event.offsetX, event.offsetY);
                    this.ctx.stroke();

                    this.points.push({
                        x: event.offsetX,
                        y: event.offsetY
                    });

                } else {
                    this.ctx.beginPath();
                    this.ctx.moveTo(event.offsetX, event.offsetY);
                }
            },

            onCanvasMouseUp: function (event) {
                this.isDrawing = false;

                this.points.push({
                    x: event.offsetX,
                    y: event.offsetY
                });

                this.drawPolygon();
            },

            drawPolygon: function() {

                this.ctx.clearRect(0, 0, this.$refs.canvas.width, this.$refs.canvas.height);

                this.ctx.beginPath();
                this.ctx.moveTo(this.points[0].x, this.points[0].y);
                for (var value of this.points) {
                    var a = value.x;
                    var b = value.y;
                    this.ctx.lineTo(a, b);
                }
                this.ctx.fillStyle = 'rgba(0,191,255,0.6)';
                this.ctx.fill();

                console.log("points:")
                console.log(this.points);
            },

        }
    }


</script>

<style>

    .canvas {
        background-color: transparent;
    }
</style>
