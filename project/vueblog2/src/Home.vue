<template>
    <div id="home">
        <el-container>

<!--            <BaseHeader></BaseHeader>-->
            <el-main><router-view class="me-container" :key="new Date().getTime()"></router-view></el-main>

        </el-container>
    </div>
</template>

<script>
    // import BaseHeader from "./components/BaseHeader";
    export default {
        name: "Home",
        // components: {BaseHeader}
    }
</script>

<style scoped>
    .me-container {
        /*margin: 100px auto 140px;*/
    }
</style>