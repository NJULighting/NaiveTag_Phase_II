import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
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



Vue.use(ElementUI);
Vue.use(Vuex);
Vue.prototype.$echarts=echarts;

Vue.component('taskblock', taskblock);

new Vue({
    el: '#app',
    router,
    render: h => h(App)
})
