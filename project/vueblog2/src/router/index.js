import Vue from 'vue'
import VueRouter from 'vue-router'
import BaseView from "../layout/Base-view";
import Index from "../views/Index";
import Blog from "../views/blog/Blog";
import BlogList from "../views/blog/BlogList";
import BlogWrite from "../views/blog/BlogWrite";
import Home from "../Home";
import Test from "../views/blog/Test";
import BlogEdit from "../views/blog/BlogEdit";
Vue.use(VueRouter)
  const routes = [
    {
      path:'',
      component: Home,
      children:[
        {
          path: '/',
          component:Index,
          children:[
            {
              path: '/',
              component: Test
            },
            {
              path: '/blogList/:sid',
              component: BlogList
            },
            // {
            //   path: '/blog/:id',
            //   component: Blog
            // },

          ]
        },
        {
          path: '/blog/:id',
          component: Blog
        },
        {
          path:'/blogEdit/:blogId',
          component: BlogEdit
        }
      ]
    },





    {
      path: '/blogWrite',
      component: BlogWrite
    },
  // {
  //   path: '',
  //   component:BaseView,
  //   redirect: '/index',
  //   children:[
  //     {
  //       path: "/index",
  //       component: Index
  //     },
  //       {
  //     path: "/blog",
  //     component: Blog
  //   },
  //     {
  //       path: '/blogList/:sid',
  //       component: BlogList
  //     }]
  // },{
  //     path: "/blog/:id",
  //     component: Blog
  //   }
]

const router = new VueRouter({
  routes
})

export default router
