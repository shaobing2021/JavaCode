<template>
    <div>
        hello{{sid}}
        {{path}}
        {{params}}
    </div>
</template>

<script>
    export default {
        props:{
            sid:Number
        },
        name: "Blog",
        data(){
            return{

                path: '',
                params:''
            }
        },
        created() {
            // const _this = this
            //   _this.sid = _this.$route.params.sid;
            //   _this.path = this.$route.path;
            // this.params = _this.$route.params

        }
    }
</script>

<style scoped>

</style>