<template>
    <el-upload
            action=""
            :show-file-list="false"
            :on-succes="uploadSuccess"
            :before-upload="checkAvatar"></el-upload>
</template>

<script>
    export default {
        name: "avatar",
        props: ['avatarUrl'],
        data: function () {
            return {
                imageURL: this.avatarUrl
            }
        },
        methods: {
            checkAvatar: function () {

            },
            uploadSuccess: function () {

            }
        }
    }
</script>

<style scoped>

</style>