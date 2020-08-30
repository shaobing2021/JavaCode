<template>
    <div>
        <el-timeline >
            <el-timeline-item  v-for="blog in blogs" :key="blog.id">
<!--               :timestamp="blog.created"-->
                <el-card>
                    <h5>
                        <router-link :to="{path:'/blog/'+blog.id}">{{blog.title}}</router-link>
<!--                        <span @click="getBlogList">{{blog.title}}</span>-->
                        <span style="float: right">
	    	            <i class="el-icon-time"></i>&nbsp;{{blog.created}}
	                 </span>
                    </h5>
                </el-card>
            </el-timeline-item>
        </el-timeline>
        <el-pagination class="mpage"
                       background
                       layout="prev, pager, next"
                       :current-page=currentPage
                       :page-size=pageSize
                       @current-change=page
                       :total="total">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "BlogList",
        data(){
            return {
                id:0,
                blogs: {},
                pageSize: 5,
                currentPage: 1,
                total: 0,

            }
        },
        methods:{
            getBlogList(){
              alert(id)
            },
            page(id,currentPage,pageSize){
                // alert(this.id)
                // alert(this.pageSize)
                // alert(this.currentPage)
                // alert(this.total)
                const that = this
                this.$axios.get('/blogList/'+id+'/'+currentPage+'/'+pageSize).then(res=>{
                    this.blogs = res.data.data.records,
                    that.total = res.data.data.total
                    // alert(this.blogs)
                })
            }
        },
        beforeRouteUpdate(to,from,next){
            console.log("beforeRouteUpdate"+'|'+this.id+'|'+this.pageSize+'|'+this.currentPage+'|'+this.total)
            // this.id = to.params.sid;
            this.page(to.params.sid,this.currentPage,this.pageSize);

            // this.$axios.get('/blogList/'+to.params.sid).then(res=>{
            //     this.blogs = res.data.data.records,
            //         this.total = res.data.data.total
            // })
        },
        created() {
            // this.page(1,5)
        },
        mounted() {
            // alert(this.id)
            // alert(this.pageSize)
            // alert(this.currentPage)
            console.log("mouted"+'|'+this.id+'|'+this.pageSize+'|'+this.currentPage+'|'+this.total)
        }
    }
</script>

<style scoped>
</style>