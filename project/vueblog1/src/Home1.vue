<template>
    <div>
        <el-container>
        <NavMenu :activeIndex="activeIndex"></NavMenu>
        <router-view></router-view>
        </el-container>
    </div>
</template>

<script>
    import NavMenu from "./components/NavMenu";
    export default {
        name: "Home1",
        data(){
          return{
              activeIndex: '/login'
          }
        },
        components: {NavMenu},
        beforeRouteEnter(to,from,next){
            next(vm=>{
                vm.activeIndex = to.path
            })
        }
    }
</script>

<style scoped>

</style>