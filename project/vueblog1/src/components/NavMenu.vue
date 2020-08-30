<template>
    <el-header>
        <el-menu class="nav-menu"
                :default-active="'/index'"
                router
                 active-text-color="red"
                mode="horizontal">
            <h3 style="float: left;margin-left: 190px;font-size: 20px;margin-right: 30px;color: wheat">Shaobing博客</h3>
            <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
                {{ item.navItem }}
            </el-menu-item>
            <el-input placeholder="请输入内容" prefix-icon="el-icon-search"  style="float: right;width: 200px;margin-right: 200px;margin-left: 100px;"></el-input>
            <el-button type="info" @click="logout">安全退出</el-button>
        </el-menu>
    </el-header>
</template>

<script>
    export default {
        name: "NavMenu",
        methods: {
          logout(){
              const _this = this
              //退出
              window.sessionStorage.clear();
              _this.$router.push("/login");
          }
        },
        data() {
            return {
                navList: [
                    {name: '/index', navItem: '首页'},
                    {name: '/blog', navItem: '博客'},
                    {name: '/library', navItem: '关于我'},
                    {name: '/admin', navItem: '友情链接'}
                ],
                msg: "hello",
                logo: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'
            }
        }
    }

</script>

<style scoped>
    .nav-menu{
         background-color: #24292e;
         /*使所有元素居中对齐*/
         align-items: center;
         display: flex;
         text-color: white;

         /*style="min-width: 1300px"*/
     }
    a{
        text-decoration: none;
    }
    span {
        pointer-events: none;
    }
</style>