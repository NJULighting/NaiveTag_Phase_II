import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//import Navi from './components/workerNavi.vue'
//import Page from './components/Navi/Navi.vue'
import Task from './components/worker/workerTaskPage.vue'
import Home from './components/worker/workerHomePage.vue'
import Page from './components/worker/workerNavi.vue'
import App from  './App.vue'
import TestNavi from './components/worker/testNavi.vue'
import router from './router/index'

Vue.use(ElementUI)


new Vue({
  el: '#app',
  router,
  render: h => h(Page)
})
