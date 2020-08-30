<template>
    <div class="kill-detail">
        <h1>商品名称{{data.itemName}}</h1>
        <h3>剩余数量：{{data.total}}</h3>
        <h3>开始时间：{{data.startTime}}</h3>
        <h3>结束时间：{{data.endTime}}</h3>
        <el-button type="primary" @click="kill(data.id)" v-if="data.canKill===1">秒杀按钮</el-button>
        <el-button v-else disabled>秒杀结束</el-button>
    </div>
</template>

<script>
    export default {
        name: "detail",
        data(){
            return  {
                data: []
            }
        },
        methods:{
            kill(id){
                const that = this
                // alert(id)
                this.$axios.post('/execute',{killId:id,userId:10}).then(res=>{
                    console.log(res.data.code)
                    if (res.data.code!=200){
                        that.$message.error("秒杀失败")
                    }else {
                        that.$router.go(0)
                        that.$message.success("秒杀成功")
                    }
                })
            }
        },
        created() {
            const id = this.$route.params.id
            console.log(id)
            const that = this
            this.$axios.get('/item/detail/'+id).then(res=>{
                console.log(res.data.data)
                that.data=res.data.data
            })
        },

    }
</script>

<style scoped>
.kill-detail{
    text-align: center;
}
</style>