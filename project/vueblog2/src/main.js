import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//注册element
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
Vue.use(Element)
//axios
import axios from "axios"
Vue.prototype.$axios = axios
// 全局注册mavonEditor
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
Vue.use(mavonEditor)
//引入markdown样式
import 'github-markdown-css/github-markdown.css'
//配置代理,设置访问根路径
axios.defaults.baseURL = "http://localhost:8080"
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
