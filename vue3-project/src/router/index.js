import Vue from 'vue'
import VueRouter from "vue-router"

// 路由配置
Vue.use(VueRouter)
  const routes = [
    {
      path: '/',
      redirect: "/home" // 重定向
    },
    {
      path: "/login", // 登录页
      name: "login",
      component: () => import("../views/login.vue")
    },
    {
      path: "/home", // 首页
      name: "home",
      component: () => import("../views/layout/home.vue")
    }
  ]
const router = new VueRouter({
  routes
})
export default router
