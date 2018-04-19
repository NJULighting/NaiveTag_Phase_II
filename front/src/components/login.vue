<template>
    <div style="background-image: url('/src/assets/loginbackground.png');width: 100%;height: 100%;background-size: cover;">
        <div>
            <el-row style="padding-top: 260px">
                <el-col :span="5" :offset="16">
                    <el-card class="login-card">
                        <el-col :span="22" :offset="1">
                            <el-form>

                                <el-form-item label="用户名">
                                    <el-input clearable v-model="username"></el-input>
                                </el-form-item>
                                <el-form-item label="密码">
                                    <el-input clearable v-model="password"></el-input>
                                </el-form-item>
                                <br>
                                <el-form-item>
                                    <el-button style="width: 100%" type="primary" @click="login">登录</el-button>
                                </el-form-item>


                            </el-form>
                            <el-button class="signUp-button" type="text" @click="signUp">注册新用户</el-button>

                        </el-col>
                    </el-card>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
    import {login} from '../api/login.js'

    export default {
        name: "login",
        data: function () {
            return {
                username: '',
                password: ''
            }
        },
        methods: {
            login: function (event) {
                var router=this.$router;
                let result = login(this.username, this.password,function (res) {
                    if (res.result === 'success') {
                        switch (res.userType) {
                            case 'admin':
                                break;
                            case 'worker':
                                router.push('/worker/home');
                                break;
                            case 'requester':
                                router.push('/requester/home');
                                break;
                            default:
                                console.log('login error' + result.userType);
                                break;
                        }
                    }
                });

            },
            signUp(){
                this.$router.push('/signUp')
            }
        }
    }
</script>

<style scoped>
    .login-card {
        background-color: rgba(255, 255, 255, 0.6);
        border-width: 0;
    }

    .signUp-button{
        float: right;
        padding-bottom: 25px;
    }
</style>