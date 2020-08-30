<template>
    <div>
        首页
    </div>
</template>

<script>
    export default {
        name: "index",
        created() {
            this.$axios.get('/hello').then(res=>{
                console.log(res.data.data)
            })
        }
    }
</script>

<style scoped>

</style>