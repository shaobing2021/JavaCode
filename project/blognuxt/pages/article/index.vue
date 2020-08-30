<template>
  <div class="index-page-box">
    文章页面
  </div>
</template>

<script>

  import axios from 'axios'
  export default {
    async asyncData(){
      const baseUrl = 'http://localhost:8080';
      // this.$axios.$get(baseUrl+'/blog/1').then(res=> {
      //   console.log(res.data)
      // })
      await axios.get(baseUrl+'/blog/1').then(res=>{
        return{

        }
     })
    }
  }
</script>

<style>

</style>
