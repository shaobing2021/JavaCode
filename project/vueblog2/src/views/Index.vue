<template>
    <div>
        <el-container>
            <el-aside width="200px">
                <el-menu unique-opened>
                    <el-submenu :index="item.id+''" v-for="item in menuList" :key="item.id">
                        <template slot="title">
                            <span>{{item.title}}</span>
                        </template>
                        <el-menu-item-group  v-for="it in item.slist" :key="it.id">
<!--                            <router-link :to="{path:'/blogList/'+it.id}">-->
                                <!--                                      {{it.id}}-->
                                <el-menu-item :index="it.id+''" @click="getBlogList(it.id)">{{it.title}}</el-menu-item>
<!--                            </router-link>-->
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Index",
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
            },
            getBlogList(id){
                alert(id)
                this.$router.push("/blogList/"+id)
            }
        }
    }
</script>

<style scoped>
.el-aside{
    /*width: 100px;*/
    margin-left: 20px;
    margin-top: 100px;
}
    .el-main{
        margin-left: 20px;
        margin-top: 100px;

    }
</style>