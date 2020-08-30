<template>
    <div>
        <NavMenu></NavMenu>
        <div class="el-container">
            <el-col style="width: 180px; margin-top: 10px;margin-left: 10px">
                <!--        <h5>默认颜色</h5> route=true 使得页面进行变化  router根据:index it.id进行跳转-->
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo"
                        :router="true">
                    <!--            一级菜单-->
                    <el-submenu :index="item.id+''" v-for="item in menuList" :key="item.id">
                        <template slot="title">
                            <!--                    <i class="el-icon-location"></i>-->
                            <span>{{item.title}}</span>
                        </template>
                        <!--                二级菜单 -->
                        <el-menu-item  v-for="it in item.slist" :key="it.id" @click="getblogs(it.id)">
                            <template slot="title">
                                <!--                        <i class="el-icon-location"></i>-->
                                <!--                        注意区别path和name-->
                                <span >{{it.title}}</span>
                            </template></el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-col>
            <div class="blog-list">
                <el-timeline >
                    <el-timeline-item :timestamp="blog.created" v-for="blog in blogs" :key="blog.id">
                        <el-card>
                            <h5>
                               <router-link :to="{name:'BlogDetail',params:{blogId: blog.id}}">{{blog.title}}{{blog.id}}</router-link>
                            </h5>
                        </el-card>
                    </el-timeline-item>
                </el-timeline>
            </div>
        </div>

    </div>

</template>

<script>
    import NavMenu from "../components/NavMenu";
    export default {
        name: "Index",
        components: {NavMenu},
        data(){
            return{
                menuList: [],
                sid: '111',
                blogs: ''
            }
        },
        created() {
            this.getMenuList()
        },
        methods:{
            getMenuList(){
                this.$axios.get('/menus').then(res=>{
                    if(res.data.code!='200'){
                        this.$message.error("获取列表失败")
                    };
                    this.menuList = res.data.data;
                    console.log(res.data.data)
                })
            },
            getblogs(id){
                this.$axios.get('/blogList/'+id).then(res=>{
                    this.blogs = res.data.data
                })
            }
        }
    }
</script>

<style scoped>
    .el-menu-vertical-demo{
        border-right: none;
        height: 100%;
    }
    .blog-list{
        height: 10px;
        margin-top: 10px;
        width: 60%;
    }
</style>