<template>
    <div>BlogList  {{$route.params.sid}}</div>
</template>

<script>
    export default {
        name: "BlogList",
        data(){
            return{
                sid: this.$route.params.sid
            }
        },
        created() {
            const id = this.$route.params.sid;
            const _this = this
            alert(id)
        }
    }
</script>

<style lang="less" scoped>

</style>