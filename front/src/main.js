import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios';
//import Navi from './components/workerNavi.vue'
//import Page from './components/Navi/Navi.vue'
import TaskInfo from './components/worker/workerTaskInfo.vue'
import Task from './components/worker/workerTaskPage.vue'
import Home from './components/worker/workerHomePage.vue'
import taskblock from './components/worker/taskBlock.vue'
import Page from './components/worker/workerNavi.vue'
import Search from './components/worker/workerSearch.vue'
import User from './components/worker/workerUserPage.vue'
import App from './App.vue'
import router from './router/index'
import jQuery from 'jquery';
import Vuex from 'vuex'
import echarts from 'echarts'

window.$ = jQuery;
window.jQuery = jQuery;

axios.defaults.baseURL = 'http://localhost:8000/naive/';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

Vue.use(ElementUI);
Vue.use(Vuex);
Vue.prototype.$axios = axios;
Vue.prototype.$echarts=echarts;

Vue.component('taskblock', taskblock);

new Vue({
    el: '#app',
    router,
    render: h => h(App)
})
