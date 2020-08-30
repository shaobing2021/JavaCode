import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";
import Home from "../views/Home";
import Welcome from "../components/Welcome";
import BlogList from "../components/BlogList";
import Blog from "../components/Blog";
import Index from "../views/Index";
import BlogDetail from "../views/BlogDetail";
import Home1 from "../Home1";
Vue.use(VueRouter)

const routes = [
  {
    path: '/home1',
    name: 'Home1',
    component: Home1
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    //home中main会不断变化，因此route-view进行重定向
    path: '/',
    component: Home,
    // name: 'Home',
    redirect:"/welcome",
    children:[
        {path:"/welcome",component:Welcome},
        {path:"/sort",component:BlogList},
        {name:'blogs',path:"/blogs/:sid",component:Blog},
    ]
  },
  {
    path: '/blog/:blogId',
    name: 'BlogDetail',
    component: BlogDetail
  },
  {
    path:'/index',
    component: Index,
    name: 'Index'
  },
  {
    path: '/welcome',
    // name: 'Welcome',
    component: Welcome
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
//挂载路由导航,to将要访问,from从哪访问，next()访问to路径，next(url)重定向到url
router.beforeEach((to,from,next)=>{
  if (to.path=='/login') return next();
  const userFlag = window.sessionStorage.getItem("user"); //取出当前页面
  if (!userFlag) return next('/login');//无值，返回登录页面
  next();//符合要求，放行
})

export default router
