<template>
    <div id="userinfo" class="userinfo">
        <div class="top"></div>
        <img v-if="!onSelect" v-bind:src="imageSrc" alt="headPicture" class="headpicture" v-on:click="selectPic">
        <div v-if="onSelect">
            <el-upload
                    class="avatar-uploader"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload">
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </div>
        <div class="top">用户名：{{username}}</div>
        <div class="top">昵称：{{name}}</div>
        <div class="top">邮箱：{{email}}</div>
        <div class="top inline">总得分：</div>
        <div class="score inline">{{totalScore}}</div>
        <p></p>
        <span>您的能力值已达到：</span>
        <el-progress type="circle" :percentage="averageScoreRatio"></el-progress>
        <p></p>
        <span>您的排名目前为：</span>
        <span class="score">{{rank}}</span>
        <span>名！</span>
    </div>
</template>

<script>
    export default {

        props: {
            username: String, //用户名
            name: String, //昵称
            email: String, // 用户注册邮箱
            rank: String, //用户群体排名
            averageScoreRatio: Number, //用户得分占满分的比例，相当于能力值
            totalScore: Number //用户赚取的总得分
        },

        created: function () {
            // `this` 指向 vm 实例
            this.$message.info('点击头像进行更改！');
        },

        methods: {
            selectPic: function () {
                this.onSelect = true;
            },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
                this.imageSrc = this.imageUrl;
                this.onSelect = false;
                this.imageUrl = '';
                this.$message.success('更换头像成功！');
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            }

        },

        data() {
            return {
                onSelect: false,
                imageUrl: '',
                imageSrc: '/src/assets/head.jpg'
            }
        }
    }
</script>

<style>

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

    .score {
        font-size: 30px;
        color: #00af43;
    }

    .inline {
        display: inline-block;
    }

    .userinfo {
        font-family: SimSun-ExtB;
        font-size: 20px;
        color: black;
        text-align: center;
    }

    .headpicture {
        border-radius: 75px 75px 75px 75px;
        height: 150px;
        width: 150px;
        cursor: pointer;
        cursor: hand;
    }
</style>
