<template>
  <div class="index-page-box clear-fix">
    <div class="index-left-part default-border-radius float-left">
      <div class="index-left-user-info">
        <div class="user-avatar">
          <img :src="userInfo.avatar"/>
<!--        {{userInfo}}-->
        </div>
        <div class="user-username">
          <span v-text="userInfo.username"></span>
        </div>
        <div class="user-sign">
          <span v-text="">追求技术，热爱分享</span>
        </div>
      </div>
      <div class="left-user-self-links">
        <span class="iconfont icon-weixin"></span>
        <span class="iconfont icon-huaban88"></span>
        <span class="iconfont icon-youxiang"></span>
      </div>
      <div class="left-categories-box">
        <div class="category-item default-border-radius" v-for="(item,index) in menus" :key="index">
          <span v-text="item.title"></span>
        </div>
<!--        <span v-text="item.title"></span>-->
      </div>
    </div>
    <div class="index-center-part float-left">
      <div class="loop-box default-border-radius">
        <el-carousel :interval="5000" arrow="always">
          <el-carousel-item v-for="(item,index) in loop" :key="index">
            <img :src="item.imageUrl" style="object-fit: cover">
          </el-carousel-item>
        </el-carousel>
      </div>
      <div class="top-article-box">
        <div class="top-article-item default-border-radius" v-for="(item,index) in blogs">
          <div class="top-article-title">
            <span class="top-tips">置顶</span>
            <span class="top-title">{{item.title}}</span>
          </div>
          <div class="top-article-summary">
            <p>{{item.description}}<span>...</span>
              <span class="read-more">阅读全文</span></p>
          </div>
        </div>
        <div class="top-article-item default-border-radius" v-for="(item,index) in blogs">
          <div class="top-article-title">
<!--            <span class="top-tips">置顶</span>-->
            <span class="top-title">{{item.title}}</span>
          </div>
          <div class="top-article-summary">
            <p>{{item.description}}<span>...</span>
              <span class="read-more">阅读全文</span></p>
          </div>
        </div>
      </div>
      <div class="article-page-navigation-bar">
        <el-pagination
                       background
                       layout="prev, pager, next"
                       @current-change="onPageChange"
                       :current-page="pageNavigation.currentPage"
                       :page-size="pageNavigation.pageSize"
        :total="pageNavigation.totalCount">
<!--                       :current-page="pageNavigation.currentPage"-->
<!--                       :page-size="pageNavigation.pageSize"-->

<!--                       :total="pageNavigation.totalCount"-->

        </el-pagination></div>
      <div>
      </div>
    </div>
    <div class="index-right-part float-left">
      <div class="right-card">
        <div class="card-title">内容搜索</div>
        <div class="card-content">
          <el-input
            placeholder="请输入内容"
            prefix-icon="el-icon-search"
            v-model="keyword">
          </el-input>
        </div>
      </div>
      <div class="right-card">
        <div class="card-title">热门标签</div>

        <div class="card-content">
          <div class="labels-list-box">
            <wordcloud
              :data="defaultWords"
              :fontSize="fontSize"
              :rotate = "rotate"
              :margin="margin"
              nameKey="title"
              valueKey="id"
              :showTooltip="false"
              :wordClick="wordClickHandler">
            </wordcloud>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import axios from 'axios'
  export default {
    data(){
      return{
        keyword: '',
        margin: {top: 0, right: 0, bottom: 0, left: 0 },
        rotate:{from: -10, to: 30, numOfOrientation: 20 },
        fontSize:[10,30],
        defaultWords: [{
          "name": "Cat",
          "value": 26
        }]
      }
    },
    mounted() {
      const baseUrl = 'http://localhost:8080';
      axios.get(baseUrl+'/submenus').then(res=>{
        // console.log(res.data)
        // console.log(res)
        this.defaultWords = res.data.data
        console.log(this.defaultWords)
      });
    },
    methods:{
      wordClickHandler(name, value, vm) {
        console.log('wordClickHandler', name, value, vm);
      },
      onPageChange(page){
        const baseUrl = 'http://localhost:8080';
         axios.get(baseUrl+'/blogList/3/'+page+'/'+this.pageNavigation.pageSize).then(res=>{
           // console.log(res.data)
           // console.log(res)
            this.blogs = res.data.data.records
         });
      }
    },
    async asyncData(){
      // let userInfo;
      const baseUrl = 'http://localhost:8080';
      let userInfo = await axios.get(baseUrl+'/user/getuser/4');
      let menus = await axios.get(baseUrl+'/menus');
      let blogs = await axios.get(baseUrl+'/blogList/3/1/3');
      let pageNavigation={
        currentPage:1,
        totalCount:blogs.data.data.total,
        pageSize:3,
      }
      // console.log(blogs.data.data)
      // console.log(pageNavigation.currentPage)
      // console.log(pageNavigation.totalCount)
      return {userInfo: userInfo.data.data,menus:menus.data.data,
            loop:[{imageUrl: 'http://124.70.77.210:32776/images/avatar.jpg'},
              {imageUrl: 'http://124.70.77.210:32776/images/blue.jpg'}],
      blogs:blogs.data.data.records,
      pageNavigation:pageNavigation};
      // return await axios.get(baseUrl+'/user/getuser/4').then(res=>{
      //   // console.log(res.data)
      //   return {
      //     userInfo: res.data
      //   }
      // })
    }
  }
</script>
<!--1140px-->
<style>
  .labels-list-box{
    height: 200px;
  }
  .labels-list-box .wordCloud{
    height: 200px;
    width: 100%;
  }
  .wordCloud .text{
    cursor: pointer;
  }
  .right-card{
    /*padding: 10px;*/
    margin-bottom: 10px;
    padding: 10px;
    background: #fff;
    border-radius: 4px;
  }
  .right-card .card-title{
    margin-bottom: 10px;
    color: #999999;
    font-size: 14px;
    font-weight: 600;
  }
  .article-page-navigation-bar{
    text-align: center;
  }
  .read-more:hover{
    /*border: #222222 solid 1px;*/
    color: #444444;
  }
  .read-more{
    font-size: 5px;
    /*border: #999999 solid 1px;*/
    color: #999999;
    cursor: pointer;
    border-radius: 4px;
    padding: 3px 10px;
  }
  .top-article-summary{
    /*设置描述最多就一行*/
    max-width: 500px;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    margin-top: 10px;
    color: #909399;
  }
  .top-article-title .top-title{
    font-size: 20px;
    color: #606266;
    vertical-align: middle;
  }
  .top-article-title .top-tips{
    vertical-align: middle;
    padding: 3px 10px;
    font-size: 10px;
    /*font-size: 16px;*/
    background: #ff4500;
    color: #fff;
    border-radius: 4px;
  }
  .top-article-item{
    background: #fff;
    margin-bottom: 10px;
    padding: 10px;
  }
  .top-article-box{
    /*background-color: #fff;*/
    /*padding:10px;*/
    margin-top: 10px;
  }
  .top-article-cover img{
    width: 100%;
    height: 300px;
    object-fit: cover;
    border-radius: 4px;
  }
  .loop-box .el-carousel__button{
    height: 10px;
    width: 10px;
    border-radius: 50%;
  }
  .loop-box{
    background: #Fff;
    padding: 10px;
  }
  .loop-box img{
    width: 100%;
    height: 300px;
  }
  .left-categories-box{
    margin-bottom: 10px;
    margin-top: 10px;
    text-align: center;
  }
  .category-item:hover{
    background: #F5F5F5;
  }
  .category-item{
    /*margin: 5px;*/
    padding: 5px;
    cursor: pointer;
    color: #999999;
  }
  .left-user-self-links span:hover{
    color: #909090;
  }
  .left-user-self-links{
    text-align: center;
    margin-top: 10px;
  }
  .left-user-self-links span{
    font-size: 30px;
    font-weight: 600;
    cursor: pointer;
    margin-left: 15px;
    color: #CACACA;
    margin-right: 1px;
  }
  .index-left-user-info{
    margin-top: 10px;
    text-align: center;
  }
  .index-left-part{
    margin-right: 10px;
  }
  .user-username{
    margin-top: 5px;
    font-size: 18px;
    color: #606060;
  }
  .user-sign{
    margin-top: 5px;
    color: #CACACA;
  }
  .index-left-user-info .user-avatar img{
    width: 80px;
    height: 80px;
    border-radius: 50%;
  }
  .index-page-box{
    margin-top: 10px;
    margin-bottom: 10px;
  }
  .index-left-part{
    margin-right: 10px;
    background: #fff;
    width: 210px;
  }
  .index-right-part{
    /*margin-left: 10px;*/
    margin-left: 10px;
    width: 250px;
  }
  .index-center-part{
    /*padding: 10px;*/
    margin-left: 10px;
    /*height: 300px;*/
    width: 640px;
    margin-left: 10px;
    margin-right: 10px;
    /*background: #f9affd;*/
  }
</style>
