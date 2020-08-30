<template>
    <div>
        <el-container>
            <BaseHeader></BaseHeader>
            <el-container style="margin-top: 60px">
                <el-aside width="200px">
                    <div class="nav">
                       <el-menu>
                           <el-submenu :index="item.id+''" v-for="item in menuList" :key="item.id">
                               <template slot="title">
                                   <span>{{item.title}}</span>
                               </template>
                               <el-menu-item-group  v-for="it in item.slist" :key="it.id">
                                  <router-link :to="{path:'/blogList/'+it.id,params:{sid:it.id}}">
<!--                                      {{it.id}}-->
                                      <el-menu-item :index="it.id+''" >{{it.title}}</el-menu-item>
                                  </router-link>
                               </el-menu-item-group>
                           </el-submenu>
                       </el-menu>
                    </div>
                </el-aside>
                <el-main><router-view/></el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    import BaseHeader from "../components/BaseHeader";
    export default {
        name: "base-view",
        components: {BaseHeader},
        data(){
            return{
                menuList:[],
            }
        },
        created() {
            this.getMenuList()
        },
        methods:{
            getMenuList(){
                this.$axios.get("/menus").then(res=>{
                    if (res.data.code!=200){
                        this.$message.error("获取列表失败")
                    };
                    this.menuList = res.data.data;
                })
            }
        }
    }
</script>

<style scoped>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .el-aside {
        background-color:#B3C0D1;
        color: #333;
        text-align: center;
        line-height: 100%;
        height: 100%;
    }
    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 100%;
        height: 100%;
    }
</style>