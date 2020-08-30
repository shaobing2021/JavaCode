import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'


import axios from 'axios'
Vue.prototype.$axios = axios

import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
Vue.use(Element)
Vue.config.productionTip = false
axios.defaults.baseURL = "http://localhost:9090"
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
