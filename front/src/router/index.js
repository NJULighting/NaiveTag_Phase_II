import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '../components/worker/workerHomePage.vue'
import history from '../components/worker/workerHistoryPage.vue'
import task from '../components/worker/workerTaskPage.vue'
import search from '../components/worker/workerSearch.vue'
import worker_navi from '../components/worker/workerNavi.vue'
import user from '../components/worker/workerUserPage.vue'
import login from '../components/login.vue'
import signUp from '../components/signUp.vue'
import tag from '../components/worker/workerTagPage.vue'
import requesterIndex from '../components/requester/requester-index.vue'
import requesterHome from '../components/requester/home.vue'
import requesterCreateTask from '../components/requester/createTask.vue'
import requesterTaskDetail from '../components/requester/taskDetail.vue'
import requesterDetail from  '../components/requester/requesterDetail.vue'


Vue.use(VueRouter)

const router = new VueRouter({

    mode: 'history',

    routes: [
        {
            path: '/worker', component: worker_navi,
            children: [
                {path: 'home', component: home},
                {path: 'history', component: history},
                {path: 'search/:key', component: search, name: 'search'},
                {path: 'user', component: user},
            ]
        },
        {path: '/task/:taskId', component: task, name: 'task'},
        {path: '/tag/:taskId/:picUrl', component: tag, name: 'tag'},
        {path: '/login', component: login},
        {path: '/signUp', component: signUp},
        {
            path: '/requester', component: requesterIndex,name:'requesterIndex',
            children: [
                {path: 'home', component: requesterHome,name:'requesterHome'},
                {path: 'createTask', component: requesterCreateTask},
                {path:'taskDetail',component:requesterTaskDetail,name:'taskDetail'},
                {path:'requesterDetail',component:requesterDetail}
            ]
        }
    ],

    scrollBehavior(to, from, savedPosition) {
        if (savedPosition) {
            return savedPosition
        } else {
            return {x: 0, y: 0}
        }
    }

})


export default router;