<template>
    <div>
        <h3>用户名：{{data.userName}}</h3><br>
        <h3>商品名称：{{data.itemName}}</h3><br>
        <h3>订单编号：{{data.code}}</h3><br>
        <h3>抢购时间：{{data.createTime}}</h3><br>
      <span v-if="data.status===-1"><h3 >支付状态：已过期</h3></span>
      <span v-else-if="data.status===0"><h3 >支付状态：抢购未支付</h3></span>
      <span v-else><h3 >支付状态：已支付</h3></span>
<!--        <h3 v-else-if="data.status===1">支付状态：状态过期</h3><br>-->
    </div>
</template>

<script>
    export default {
        name: "killRecord",
        data(){
            return{
                data: [],
            }
        },
        created() {
            const id = this.$route.params.id
            console.log(id)
            const that = this
            this.$axios.get('/killRecord/'+id).then(res=>{
                console.log(res.data.data)
                that.data=res.data.data
            })
         },
    }
</script>

<style scoped>

</style>