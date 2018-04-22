<template>
    <div id="tagPage">
        <simplenavi></simplenavi>
        <tag v-bind:taskType="tagData.taskType"
             v-bind:tagType="tagData.tagType"
             v-bind:options="options"
             v-bind:picUrl="picUrl"
             :points.sync="tagData.points"
             :frames.sync="tagData.frames"
             @lastPic="lastPic"
             @nextPic="nextPic"></tag>
    </div>
</template>

<script>

    import simplenavi from './simpleNavi.vue'
    import tag from './workerTagInfo.vue'

    export default {

        props: {
            picUrl: String,
            options: Array,
            tagData: Object
        },

        components: {
            'simplenavi': simplenavi,
            'tag': tag,
        },

        methods: {

            lastPic: function () {
                this.$emit('lastPic');
            },

            nextPic: function () {
                this.$emit('nextPic');
            },
        },

//        created: function () {
//            this.fetchTagData();
//        },
//
//        watch: {
//            // 如果路由有变化，会再次执行该方法
//            '$route': 'fetchTagData'
//        },
//
//        methods: {
//            fetchTagData () {
////                let result = search(this.$route.params.key, res=> {
////                    console.log("result:");
////                    console.log(res);
////                    this.taskList = res;
////                });
//                this.picUrl = this.$route.params.picUrl;
//                console.log("picUrl: " + this.picUrl);
//            },
//        },

    }

</script>

<style>

</style>
