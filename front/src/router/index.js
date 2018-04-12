import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/worker/workerHomePage.vue'
import History from '../components/worker/workerHistoryPage.vue'
import Task from '../components/worker/workerTaskPage.vue'
Vue.use(VueRouter)

const router = new VueRouter({

    routes:[{
        path: '/Home', component: Home
    },{
        path: '/History', component: History
    },{
        path:'/Task', component: Task
    }]

})


export default router;