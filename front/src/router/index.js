import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '../components/worker/workerHomePage.vue'
import history from '../components/worker/workerHistoryPage.vue'
import task from '../components/worker/workerTaskPage.vue'
import search from '../components/worker/workerSearch.vue'
import worker_navi from '../components/worker/workerNavi.vue'
import user from '../components/worker/workerUserPage.vue'

Vue.use(VueRouter)

const router = new VueRouter({

    routes: [
        {
            path: '/worker', component: worker_navi,
            children: [
                { path: 'home', component: home },
                { path: 'history', component: history },
                { path: 'search', component: search },
                { path: 'user', component: user },
            ]
        },
        { path: '/task', component: task },
    ]

})


export default router;