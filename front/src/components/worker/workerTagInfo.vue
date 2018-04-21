<template>
    <div id="tag" class="cannotselect">
        <el-row>


            <!--左侧画框画线界面-->
            <el-col :span="20"><div class="grid-content bg-purple">
                <div style="background-color: brown">

                    <!--背景图片-->
                    <img src="../test.jpg" alt="picture" class="picture"
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

                            <div style="font-family: SimSun-ExtB;font-size: 22px;width: 100%;padding-top: 5px;padding-bottom: 5px;">标注信息</div>

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
            this.picWidth = this.$refs.image.getBoundingClientRect().width;
            for(var i=0; i<this.frames.length;i++){
                this.rectColors.push(this.rectColor);
            }
            console.log("rectColors:")
            console.log(this.rectColors);
        },

        props: {
            tagType: String,
            frames: Array,
            points: Array,
            options: Array,
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
            }
        },

        computed: {

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
            }
        },

        methods: {

            deleteFramesItem(index) {
                this.frames.splice(index, 1);
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
                this.drawRect = true;
                this.startPoint.x = event.offsetX;
                this.startPoint.y = event.offsetY;
                this.endPoint.x = event.offsetX;
                this.endPoint.y = event.offsetY;
                console.log(this.startPoint.x + " this.startPoint.x");
                console.log(this.startPoint.y + " this.startPoint.y");
            },

            onMouseMove: function (event) {
                if(this.drawRect){
                    
                    this.endPoint.x = event.offsetX;
                    this.endPoint.y = event.offsetY;

                }
            },

            onMouseUp: function () {
                this.drawRect = false;

                if(this.getRectWidth > 5 && this.getRectHeight > 5){
                    this.frames.push({
                        "leftTop": {x:this.getRectLeft,y:this.getRectTop},//left and top
                        "rightDown": {x:this.getRectLeft + this.getRectWidth,y:this.getRectTop + this.getRectHeight},
                        "label":"",
                    });
                    this.rectColors.push(this.rectColor);
                    console.log(this.frames);
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
        height: 800px;
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
</style>
