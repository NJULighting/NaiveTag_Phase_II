<template>
    <div id="tagPage">
        <simplenavi></simplenavi>
        <tag v-bind:taskType="tagData.taskType"
             v-bind:tagType="tagData.tagType"
             v-bind:options="options"
             :frames.sync="tagData.frames"></tag>

    </div>
</template>

<script>

    import simplenavi from './simpleNavi.vue'
    import tag from './workerTagInfo.vue'

    export default {

        components: {
            'simplenavi': simplenavi,
            'tag': tag,
        },

        data() {
            return {
                options: [{
                    value: '0',
                    label: '黄金糕'
                }, {
                    value: '1',
                    label: '双皮奶'
                }, {
                    value: '2',
                    label: '蚵仔煎'
                }, {
                    value: '3',
                    label: '龙须面'
                }, {
                    value: '4',
                    label: '北京烤鸭'
                }],
                tagData: {
                    "frames":[
                        {
                            "leftTop":{"x":23,"y":19},
                            "rightDown":{"x":100,"y":200},
                            "label":"黄金糕"
                        },
                        {
                            "leftTop":{"x":300,"y":192},
                            "rightDown":{"x":400,"y":650},
                            "label":"双皮奶"
                        },
                        {
                            "leftTop":{"x":500,"y":300},
                            "rightDown":{"x":800,"y":500},
                            "label":"蚵仔煎"
                        }
                    ],
                    "tagType":"t_300",
                    "points":[
                        {"x":10,"y":11},
                        {"x":11,"y":12},
                        {"x":22,"y":77}
                    ],
                }
            }
        },

        methods: {

            showData: function () {
                console.log(this.tagData);
            },

        }

    }

</script>

<style>

</style>
