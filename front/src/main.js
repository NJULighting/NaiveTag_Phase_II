import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//import Navi from './components/workerNavi.vue'
//import Page from './components/Navi/Navi.vue'
import TaskInfo from './components/worker/workerTaskInfo.vue'
import Task from './components/worker/workerTaskPage.vue'
import Home from './components/worker/workerHomePage.vue'
import taskblock from './components/worker/taskBlock.vue'
import Page from './components/worker/workerNavi.vue'
import Search from './components/worker/workerSearch.vue'
import User from './components/worker/workerUserPage.vue'
import App from  './App.vue'
import router from './router/index'

Vue.use(ElementUI)

Vue.component('taskblock', taskblock);

new Vue({
    el: '#app',
    router,
    render: h => h(App)
})
