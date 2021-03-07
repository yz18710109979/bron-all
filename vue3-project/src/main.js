  // The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import "./assets/font/iconfont.css" // 全局导入css
  // import store from "./store" vuex的实例对象

// 项目的入口文件

  //npm install --save @vue/composition @vue/composition-api
Vue.config.productionTip = false
import VueCompositionApi from "@vue/composition"
  Vue.use(VueCompositionApi)
/* eslint-disable no-new */
new Vue({
  router,
  // stroe,
  // components: { App },
  // template: '<App/>'
  render: h => h(App) // 等同于createElement 创建元素
}).$mount("#app")

//  render:function(createElement){
  //
  //  }
