<template>
    <div>
        <NavMenu></NavMenu>
        <div class="m-blog">
            <h5>{{blog.title}}</h5>
            <div class="content markdown-body" v-html="blog.content"></div>
        </div>
    </div>
</template>

<script>
    import NavMenu from "../components/NavMenu";
    // import 'github-mardown-css/github-markdown.css'
    export default {
        name: "BlogDetail",
        components: {NavMenu},
        data(){
            return{
                blog: ''
            }
        },
        created() {
            const blogId = this.$route.params.blogId
            this.$axios.get('/blog/'+blogId).then(res=>{
                this.blog = res.data.data
            })
        }
    }
</script>

<style scoped>
.m-blog {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    width: 100%;
    min-height: 700px;
    padding: 20px 15px;
    /*horiz-align: center;*/
    /*vertical-align: center;*/
    margin-left: 200px;
    margin-right: 200px;
}
</style>