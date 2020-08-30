<template>
    <div>
        <el-container>
            <el-main>
                <h2>{{blog.title}} <el-link icon="el-icon-edit">
                    <router-link :to="{path:'/blogEdit/'+blog.id,params:{blogId:blog.id}}">编辑</router-link>
                </el-link></h2>
                <el-divider></el-divider>
                <div class="content markdown-body" v-html="blog.content"></div>
            </el-main>
        </el-container>
    </div>

</template>

<script>
    export default {
        name: "Blog",
        data(){
            return{
                blog: ''
            }
        },
        created() {
            const blogId = this.$route.params.id
            this.$axios.get('/blog/'+blogId).then(res=>{
                this.blog = res.data.data
            })
        }
    }
</script>

<style scoped>
.el-main{
    margin-top: 60px;
    margin-left: 50px;
}
</style>