<template>
    <el-container class="home-container">
        <el-header><NavMenu></NavMenu></el-header>
        <el-container>
            <SideMenu>
            </SideMenu>
            <el-main>
                <router-view>
                </router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import NavMenu from "../components/NavMenu";
    import SideMenu from "../components/SideMenu";
    export default {
        name: "Index",
        components: {SideMenu, NavMenu}
    }
</script>

<style lang="less" scoped>
.home-container{
    height: 100%;
    width: 100%;
}
</style>