<template>
  <div>
    <h1>登录页{{name}}</h1>
    <h1>{{n}}</h1>
    <button @click="login()">登录</button>
  </div>
</template>
<script>
import {reactive,computed, toRefs} from "@vue/composition-api"
export default {
  setup(){
    // 创建响应式对象，类似data
    const state = reactive({
      n:1,
      name:"hello world"
    });
    const login=()=>{
      console.log(123)
      return state.n += 1
    }
    return {
      //
      ...toRefs(state),
      login
    }
  }
}
</script>
