<template>
    <div id="userinfo">
        <div class="top"></div>
        <div style="width: 400px;text-align: center;">
            <img v-bind:src="imageSrc" alt="headPicture" class="headpicture">
        </div>

        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>{{username}}</span>
            </div>
            <div class="text item">
                昵称：{{name}}
            </div>
            <div class="text item">
                邮箱：{{email}}
            </div>
            <div class="text item">
                得分：{{score}}
            </div>
            <div class="text item">
                排名：{{rank}}
            </div>
            <div class="text item">
                能力值：
                <el-progress :percentage="averageScoreRatio*100"></el-progress>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {

        props: {
            username: String, //用户名
            name: String, //昵称
            email: String, // 用户注册邮箱
            rank: Number, //用户群体排名
            averageScoreRatio: Number, //用户得分占满分的比例，相当于能力值
            score: Number //用户赚取的总得分
        },

        methods: {
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
                this.imageSrc = this.imageUrl;
                this.imageUrl = '';
                this.$message.success('更换头像成功！');
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 20;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 20MB!');
                }
                return isJPG && isLt2M;
            }

        },

        data() {
            return {
                imageUrl: '',
                imageSrc: '/src/assets/head.jpg',
            }
        }
    }
</script>

<style>
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 400px;
    }

    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }

    .top {
        padding-top: 10px;
    }
    .headpicture {
        border-radius: 75px 75px 75px 75px;
        height: 150px;
        width: 150px;
        cursor: pointer;
        cursor: hand;
    }
</style>
