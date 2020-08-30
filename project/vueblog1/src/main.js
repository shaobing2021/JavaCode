import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import Element from 'element-ui'
import axios from 'axios'

import "element-ui/lib/theme-chalk/index.css"
import "./assets/font/iconfont.css"
import "./assets/css/global.css"
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
// use

//配置代理,设置访问根路径
axios.defaults.baseURL = "http://localhost:8080"
//全局注册，之后可在其他主键通过this.$axios发送数据
Vue.prototype.$axios = axios
Vue.use(Element)
Vue.use(mavonEditor)
Vue.config.productionTip = false

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
