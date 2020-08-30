import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../index";
import List from "../views/list";
import Detail from "../views/detail";
import KillRecord from "../views/killRecord";

Vue.use(VueRouter)

  const routes = [
  {
    path: '',
    component: Index
  },
    {
      path: '/list',
      component: List
    },
    {
      path:'/detail/:id',
      component:Detail
    },
    {
      path:'/killRecord/:id',
      component:KillRecord
    }
]

const router = new VueRouter({
  routes
})

export default router
