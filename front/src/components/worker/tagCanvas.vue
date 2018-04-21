<template>
    <canvas ref="canvas" class="canvas" width="1000" height="700"
            ondragstart="return false;" oncontextmenu="return false;"
            v-on:mousedown="onCanvasMouseDown($event)"
            v-on:mousemove="onCanvasMouseMove($event)"
            v-on:mouseup="onCanvasMouseUp($event)"></canvas>
</template>

<script>

    export default {

        data() {
            return {
                isDrawing : false,
                onlyOne:true,
                x : 0,
                y : 0,
                count : 0,
                polygon : Object,
                array : [],
                ctx : Object,
            }
        },

        mounted: function () {
            this.ctx = this.$refs.canvas.getContext('2d');
            this.polygon = new this.Polygon();
        },

        methods: {

            Point(x, y) {
                this.x = x;
                this.y = y;
            },

            Polygon() {
                this.set = new Array();
            },

            onCanvasMouseDown: function (event) {
                console.log("event.offsetX "+event.offsetX);
                console.log("event.offsetY "+event.offsetY);
                this.isDrawing = true;
                this.x = event.offsetX;
                this.y = event.offsetY;
                this.polygon = new this.Polygon();
            },

            onCanvasMouseMove: function (event) {
                if (this.isDrawing) {
                    this.count++;
                    this.ctx.lineTo(event.offsetX, event.offsetY);
                    this.ctx.stroke();
                    this.polygon.set.push(new this.Point(event.offsetX, event.offsetY));
                } else {
                    this.ctx.beginPath();
                    this.ctx.moveTo(event.offsetX, event.offsetY);
                }
            },

            onCanvasMouseUp: function (event) {
                this.isDrawing = false;
                if(this.onlyOne){
                    if(this.array.length > 0){
                        this.array.pop();
                    }
                }
                this.polygon.set.push(new this.Point(event.offsetX, event.offsetY));
                this.array.push(this.polygon);
                this.drawPolygon();
                console.log(this.array);
            },

            drawPolygon: function() {
                this.ctx.clearRect(0, 0, this.$refs.canvas.width, this.$refs.canvas.height);
                for (var value in this.array) {
                    var set = this.array[value].set;
                    this.ctx.beginPath();
                    this.ctx.moveTo(set[0].x, set[0].y);
                    for (var v in set) {
                        this.ctx.lineTo(set[v].x, set[v].y)
                    }
                    //ctx.closePath();
                    this.ctx.fillStyle = 'rgba(0,191,255,0.6)';
                    this.ctx.fill();
                }
            },

        }
    }


</script>

<style>

    .canvas {
        background-color: transparent;
    }
</style>
