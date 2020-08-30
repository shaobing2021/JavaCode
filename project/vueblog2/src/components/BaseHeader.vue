<template>
    <el-header class="me-area">
        <el-row class="me-header">
            <el-col :span="4"  offset="2" class="me-header-left">
                <router-link to="/" class="me-title">
<!--                    <img src="../assets/img/logo.png"/>-->
                    <h3 style="color: wheat;">Shaobing博客</h3>
                </router-link>
            </el-col>

            <el-col  :span="12" offset="0">
                <el-menu :router=true menu-trigger="click" active-text-color="#5FB878"
                         mode="horizontal">
                    <el-menu-item index="/">首页</el-menu-item>
                    <el-menu-item index="/category/all">文章分类</el-menu-item>
                    <el-menu-item index="/tag/all">标签</el-menu-item>
                    <el-menu-item index="/archives">时间轴</el-menu-item>
                    <el-menu-item index="/log">关于我</el-menu-item>
                    <el-menu-item index="/feedback">留言板</el-menu-item>
                    <el-menu-item index="/write">写文章</el-menu-item>
                </el-menu>
            </el-col>
            <el-col :span="4" offset="0">
                <el-menu :router=true menu-trigger="click" mode="horizontal" active-text-color="#5FB878">
                    <template v-if="true">
                        <el-menu-item index="/login">
                            <el-button type="text">登录</el-button>
                        </el-menu-item>
                        <el-menu-item index="/register">
                            <el-button type="text">注册</el-button>
                        </el-menu-item>
                    </template>

                    <template v-else>
                        <el-submenu index>
                            <template slot="title">
                                <img class="me-header-picture"/>
                            </template>
                            <el-menu-item index @click="logout"><i class="el-icon-back"></i>退出</el-menu-item>
                        </el-submenu>
                    </template>
                </el-menu>
            </el-col>
        </el-row>
    </el-header>
</template>

<script>
    export default {
        name: 'BaseHeader',
        data() {
            return {}
        },
        computed: {

        },
        methods: {
            logout() {
                let that = this
                this.$store.dispatch('logout').then(() => {
                    this.$router.push({path: '/'})
                }).catch((error) => {
                    if (error !== 'error') {
                        that.$message({message: error, type: 'error', showClose: true});
                    }
                })
            }
        }
    }
</script>

<style>

    .el-header {
        position: fixed;
        z-index: 1024;
        min-width: 100%;
        box-shadow: 0 2px 3px hsla(0, 0%, 7%, .1), 0 0 0 1px hsla(0, 0%, 7%, .1);
    }
    .me-title {
        margin-top: 10px;
        font-size: 24px;
    }

    .me-header-left {
        margin-top: 10px;
    }
    .me-title img {
        max-height: 2.4rem;
        max-width: 100%;
    }

    .me-header-picture {
        width: 36px;
        height: 36px;
        border: 1px solid #ddd;
        border-radius: 50%;
        vertical-align: middle;
        background-color: #5fb878;
    }
</style>
