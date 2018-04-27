<template>
    <div>
        <el-col :offset="5" :span="14">
            <el-card style="margin-top: 30px">
                <el-container>
                    <el-aside>
                        <div style="margin: 35px">
                            <img src="/src/assets/van.jpg">
                        </div>
                    </el-aside>
                    <el-main>
                        <requester-detail-item
                                label="用户名"
                                :content="userDetail.username">
                        </requester-detail-item>

                        <requester-detail-item
                                label="邮箱"
                                :content="userDetail.email">
                        </requester-detail-item>

                        <requester-detail-item
                                label="昵称"
                                :content="userDetail.name"
                                button-name="修改"
                                :func="modifyName">

                        </requester-detail-item>

                        <requester-detail-item
                                label="积分"
                                :content="userDetail.score"
                                button-name="充值"
                                :func="recharge"
                        >
                            <!--<el-button slot="button" type="text" class="modify-button">充值</el-button>-->

                        </requester-detail-item>
                    </el-main>
                </el-container>

            </el-card>
        </el-col>

    </div>
</template>

<script>

    import RequesterDetailItem from "~/components/requester/requesterDetailItem";
    import {fetchRequesterDetail} from "~/api/requesterDetail";
    import {fetchAdminDetail} from "~/api/adminDetail";


    export default {
        name: "requesterDetail",
        components: {  RequesterDetailItem},
        data: function () {

            return {
                userDetail: {},
                date: [],
                data1:[],
                data2:[],
                data3:[]
            }
        },
        created: function () {
            fetchRequesterDetail(localStorage.username,
                res => {
                    this.userDetail = res;
                });
            fetchAdminDetail(res=>{
                console.log('trend')
                console.log(res.activeWorkerTrend);
               this.data1=res.activeWorkerTrend;
               this.data2=res.totalWorkerTrend;
               this.data3=res.totalRequesterTrend

            })


        },
        methods: {
            recharge: function () {
                alert('请联系管理员进行充值');
            },
            modifyName: function () {
                alert('请联系管理员进行修改');
            }
        }
    }
</script>

<style scoped>
    .headPic {
        width: 200px;
        height: 200px;
    }


</style>