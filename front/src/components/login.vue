<template>
    <div>
        <el-input clearable v-model="username" placeholder="用户名"></el-input>
        <el-input clearable v-model="password" placeholder="密码"></el-input>
        <el-button @click="login">登录</el-button>
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
                let result = login(this.username, this.password);
                if (result.result==='success'){
                    switch (result.userType){
                        case 'admin':
                            break;
                        case 'worker':
                            this.$router.push('/home');
                            break;
                        case 'requester':
                            this.$router.push('/requester/home');
                            break;
                        default:
                            console.log('login error'+ result.userType);
                            break;
                    }
                } 
            }
        }
    }
</script>

<style scoped>

</style>