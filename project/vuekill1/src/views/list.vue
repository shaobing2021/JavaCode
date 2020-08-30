<template>
    <div class="item-content">
        <div><h2>商城高并发抢单--秒杀商品列表</h2></div>
        <div>
            <el-table
                    :data="lists"
                    style="width: 100%">
                <el-table-column
                        prop="itemName"
                        label="商品名称"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="total"
                        label="剩余数量"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="startTime"
                        label="开始时间"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="endTime"
                        label="结束时间"
                        width="180">
                </el-table-column>
                <el-table-column label="详情" width="180">
                    <template slot-scope="scope">
                        <router-link v-if="scope.row.canKill===1" :to="{path:'/detail/'+scope.row.id}">点击秒杀</router-link>
                        <h3 v-else>秒杀完毕</h3>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
    export default {
        name: "list",
        data(){
          return  {
              lists: []
          }
        },
        created() {
            const that = this
            this.$axios.get('/item/list').then(res=>{
                that.lists = res.data.data
                console.log(that.lists)
            })
        }
    }
</script>

<style scoped>
.item-content{
    text-align: center;
}
    *{
        text-decoration: none;
    }
</style>