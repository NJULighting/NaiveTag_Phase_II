<template>
    <div id="tag" class="cannotselect">
        <el-row>


            <!--左侧画框画线界面-->
            <el-col :span="20"><div class="grid-content bg-purple">
                <div>

                    <!--背景图片-->
                    <img :src="picUrl" alt="picture" class="picture"
                         ondragstart="return false;"
                         oncontextmenu="return false;"
                         ref="image">

                    <!--已画的框-->
                    <div class="rect" v-for="(item, index) in frames"
                         v-bind:style="{
                            'border-color': rectColors[index],
                            left: item.leftTop.x + 'px',
                            top: item.leftTop.y + 'px',
                            width: item.rightDown.x - item.leftTop.x + 'px',
                            height: item.rightDown.y - item.leftTop.y + 'px',
                            'z-index': index,
                         }"
                         v-bind:index="index"
                         v-bind:key="item.id"></div>

                    <!--框画板-->
                    <div ref="canvas" v-bind:style="getCanvasStyle()"
                         v-on:mousedown="onMouseDown($event)"
                         v-on:mouseup="onMouseUp($event)"
                         v-on:mousemove="onMouseMove($event)"></div>

                    <!--正在画的框-->
                    <div v-if="this.drawRect" v-bind:style="getChangeRectStyle()"></div>

                    <!--<tagCanvas :points.sync="this.points"-->
                               <!--v-bind:width="this.picWidth"-->
                               <!--v-bind:height="this.picHeight"-->
                               <!--v-bind:style="getTagCanvasStyle()"-->
                               <!--&gt;</tagCanvas>-->
                    <canvas ref="canvas" class="canvas"
                            ondragstart="return false;" oncontextmenu="return false;"
                            v-on:mousedown="onCanvasMouseDown($event)"
                            v-on:mousemove="onCanvasMouseMove($event)"
                            v-on:mouseup="onCanvasMouseUp($event)"
                            v-bind:width="this.picWidth"
                            v-bind:height="this.picHeight"
                            v-bind:style="getTagCanvasStyle()"></canvas>

                </div>
            </div></el-col>


            <!--右侧标注界面-->
            <el-col :span="4"><div class="grid-content bg-purple-light">
                <div v-bind:style="getBlocksStyle()">
                    <div class="tagblocks">

                        <!--颜色选择器-->
                        <div class="block center" style="padding-top: 20px;">
                            <span class="demonstration">颜色</span>
                            <el-color-picker v-model="rectColor"></el-color-picker>
                        </div>

                        <!--标注块-->
                        <div style="text-align: center;padding-top: 10px;padding-bottom: 10px">

                            <!--输入框-->
                            <div v-if="isInputType" v-for="(item, index) in frames"
                                 v-bind="item"
                                 v-bind:index="index"
                                 v-bind:key="item.id">
                                <span v-if="isMoreThanOne">{{index}}：</span>
                                <el-input v-model="item.label" placeholder="请输入内容" class="input" @change="changeInputValue($event,index)"></el-input>
                                <el-button type="danger" icon="el-icon-delete" circle
                                           v-on:click="deleteFramesItem(index)"></el-button>
                            </div>

                            <!--选择框-->
                            <div v-if="isSelectType" v-for="(item, index) in frames"
                                 v-bind="item"
                                 v-bind:index="index"
                                 v-bind:key="item.id"
                                 v-on:remove="frames.splice(index, 1)">
                                <span v-if="isMoreThanOne">{{index}}：</span>
                                <el-select v-model="item.label" filterable placeholder="请选择" class="select" @change="changeSelectValue($event,index)">
                                    <el-option
                                            v-for="item in options"
                                            :key="item.value"
                                            :label="item.label"
                                            :value="item.value">
                                    </el-option>
                                </el-select>
                                <el-button type="danger" icon="el-icon-delete" circle
                                           v-on:click="deleteFramesItem(index)"></el-button>
                            </div>

                        </div>

                        <div class="center" style="padding-bottom: 20px;">
                            <el-button type="danger" style="width: 40%" v-on:click="lastPic">上一张</el-button>
                            <el-button type="danger" style="width: 40%" v-on:click="nextPic">下一张</el-button>
                        </div>

                    </div>
                </div>
            </div></el-col>

        </el-row>
    </div>
</template>

<script>
    import Vue from 'vue'

    export default {


        mounted: function() {
           this.$nextTick(function () {
               this.picWidth = this.$refs.image.getBoundingClientRect().width;
               this.picHeight = this.$refs.image.getBoundingClientRect().height;
               this.ctx = this.$refs.canvas.getContext('2d');

               for(var i=0; i<this.frames.length;i++){
                   this.rectColors.push(this.rectColor);
               }

               this.drawPolygon();

               console.log("rectColors:")
               console.log(this.rectColors);
           })
        },

        props: {
            tagType: String,
            frames: Array,
            points: Array,
            options: Array,
            picUrl: String
        },

        data() {
            return {
                rectColor : 'red',
                defaultColor:[
                    'red',
                    'black',
                    'blue',
                    'green',
                    'yellow'
                ],
                rectColors:[

                ],

                picHeight :  800,
                picWidth : 600,

                drawRect : false,
                startPoint: {
                    x:0,
                    y:0
                },
                endPoint: {
                    x:0,
                    y:0
                },
                changeRect: {
                    width:0,
                    height:0
                },

                rectStyle: {
                    'border-color': 'yellow',
                    left: '100px',
                    top: '100px',
                    width: '100px',
                    height: '100px',
                    'z-index': '0',
                },

                isDrawing : false,
                ctx : Object,
            }
        },

        computed: {

            isNeedTagCanvas: function () {
                return false;
            },

            getRandomColor: function () {
                return this.defaultColor[parseInt((this.defaultColor.length-1)*Math.random())];
            },

            getTagTypeNum: function () {
                return parseInt(this.tagType.slice(2,5));
            },

            getRectLeft: function () {
                return Math.min(this.startPoint.x , this.endPoint.x);
            },

            getRectTop: function () {
                return Math.min(this.startPoint.y , this.endPoint.y);
            },

            getRectWidth: function () {
                return Math.abs(this.startPoint.x - this.endPoint.x);
            },

            getRectHeight: function () {
                return Math.abs(this.startPoint.y - this.endPoint.y);
            },

            isInputType: function () {
                switch (this.getTagTypeNum) {
                    case 100:
                        return false;
                        break;
                    case 101:
                        return true;
                        break;
                    case 200:
                        return false;
                        break;
                    case 201:
                        return true;
                        break;
                    case 300:
                        return false;
                        break;
                    case 301:
                        return true;
                        break;
                    case 400:
                        return true;
                        break;
                    case 401:
                        return false;
                        break;
                }
            },

            isSelectType: function () {
                switch (this.getTagTypeNum) {
                    case 100:
                        return true;
                        break;
                    case 101:
                        return false;
                        break;
                    case 200:
                        return true;
                        break;
                    case 201:
                        return false;
                        break;
                    case 300:
                        return true;
                        break;
                    case 301:
                        return false;
                        break;
                    case 400:
                        return false;
                        break;
                    case 401:
                        return false;
                        break;
                }
            },

            isMoreThanOne: function () {
                switch (this.getTagTypeNum) {
                    case 300:
                        return true;
                        break;
                    case 301:
                        return true;
                        break;
                    default:
                        return false;
                        break;
                }
            },
        },

        methods: {

            checkDraw: function () {
                if(this.frames.length === 0){
                    return true;
                }else if(this.frames[this.frames.length - 1].label){
                    return true;
                }else{
                    return false;
                }
            },

            checkNext: function () {
                if(this.frames.length === 0){
                    this.$message.error('请填写至少一个标注信息！');
                    return false;
                }else if(this.frames[this.frames.length - 1].label){
                    return true;
                }else{
                    this.$message.error('有标注信息未填写！');
                    return false;
                }
            },

            lastPic: function () {
                if(this.checkNext()){
                    this.$emit('lastPic');
                }
            },

            nextPic: function () {
                if(this.checkNext()){
                    this.$emit('nextPic');
                }
            },

            onCanvasMouseDown: function (event) {
                this.points.splice(0, this.points.length);
                this.isDrawing = true;

                this.points.push({
                    x: event.offsetX,
                    y: event.offsetY
                });

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

                console.log("points:");
                console.log(this.points);
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

            },

            deleteFramesItem(index) {
                this.frames.splice(index, 1);
                this.rectColors.splice(index, 1);
                console.log(this.frames);
            },

            changeInputValue(value,index) {
                console.log("value: "+value+" index: "+index);
                this.frames[index].label = value;
                console.log(this.frames);
            },

            changeSelectValue(value,index) {
                let obj = {};
                obj = this.options.find((item)=>{
                    return item.value === value;
                });
                console.log("value: "+value+" index: "+index+" label: "+ obj.label);
                Vue.set(this.frames[index], 'label', obj.label)
                console.log(this.frames);
            },

            onMouseDown: function (event) {
                if(this.checkDraw()){
                    this.drawRect = true;
                    this.startPoint.x = event.offsetX;
                    this.startPoint.y = event.offsetY;
                    this.endPoint.x = event.offsetX;
                    this.endPoint.y = event.offsetY;
                    console.log(this.startPoint.x + " this.startPoint.x");
                    console.log(this.startPoint.y + " this.startPoint.y");
                }else{
                    this.$message.error('有标注信息未填写！');
                }

            },

            onMouseMove: function (event) {
                if(this.drawRect){
                    
                    this.endPoint.x = event.offsetX;
                    this.endPoint.y = event.offsetY;

                }
            },

            onMouseUp: function () {
                if(this.checkDraw()){
                    this.drawRect = false;

                    if(this.getRectWidth > 5 && this.getRectHeight > 5){
                        this.frames.push({
                            "leftTop": {x:this.getRectLeft,y:this.getRectTop},//left and top
                            "rightDown": {x:this.getRectLeft + this.getRectWidth,y:this.getRectTop + this.getRectHeight},
                            "label":null,
                        });
                        this.rectColors.push(this.rectColor);
                        console.log(this.frames);
                    }
                }
            },

            getChangeRectStyle: function () {
                return {
                    'z-index': this.frames.length,
                    left: this.getRectLeft + 'px',
                    top: this.getRectTop + 'px',
                    width: this.getRectWidth + 'px',
                    height: this.getRectHeight + 'px',
                    position: 'absolute',
                    border:'2px solid',
                    color: this.rectColor,
                }
            },

            getTagCanvasStyle: function () {
                if(this.isNeedTagCanvas){
                    return {
                        'z-index': this.frames.length + 3,
                        left: '0px',
                        top: '0px',
                        position: 'absolute',
                    }
                }else{
                    return {
                        'z-index': -1,
                        left: '0px',
                        top: '0px',
                        position: 'absolute',
                    }
                }

            },

            getCanvasStyle: function () {
                return {
                    'z-index': this.frames.length + 2,
                    left: '0px',
                    top: '0px',
                    width: this.picWidth + 'px',
                    height: this.picHeight + 'px',
                    position: 'absolute',
                }
            },

            getBlocksStyle: function () {
                return {
                    'z-index': this.frames.length + 1,
                    position:'absolute',
                    left: '0px',
                    top: '10px',
                    width: '95%',
                }
            }


        }
    }

</script>

<style>

    .input {
        padding-top: 5px;
        padding-bottom: 5px;
        display: inline-block;
        width: 65%;
    }

    .select {
        padding-top: 5px;
        padding-bottom: 5px;
        display: inline-block;
        width: 65%;
    }

    .cannotselect {
        -moz-user-select: none;
        -khtml-user-select: none;
        user-select: none;
    }

    .tagblocks {
        width: 20%;
        border-radius: 10px 10px 10px 10px;
        background-color: #eeeeee;
        margin-left:auto;
        margin-right:0px;
        text-align: left;
    }

    .picture {
        /*width: 800px;*/
        width: auto;
        position:absolute;
        left:0px;
        top:0px;
        z-index:-1;
        /*background-color: brown;*/
        /*background-image: url('/src/components/test.jpg');*/
    }

    .center {
        display:flex;
        justify-content:center;
        align-items:center;
    }

    .rect {
        background-color: transparent;
        border:2px solid;
        position:absolute;
    }

    .canvas {
        background-color: transparent;
    }
</style>
