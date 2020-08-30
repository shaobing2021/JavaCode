<template>
  <div id="blog-box">
    <div class="blog-header clear-fix default-border-radius">
      <div class="logo-box float-left">
        <div class="logo">shaobing博客</div>
      </div>

      <div class="login-tips-text-box float-right">
        <span><i class="iconfont icon-login"></i>登录</span>
        <span><i class="iconfont icon-register"></i>注册</span>
      </div>
      <div class="navigation-box float-right">
        <nuxt-link to="/"><span><i class="iconfont icon-shouye"></i>首页</span></nuxt-link>
        <nuxt-link to="/about"><span><i class="iconfont icon-about"></i>关于</span></nuxt-link>
        <nuxt-link to="/link"><span><i class="iconfont icon-insertlink"></i>友链</span></nuxt-link>
      </div>

      <div class="user-info-box float-right" style="display: none">用户信息</div>
    </div>
    <Nuxt />
    <div class="blog-footer">
      <div class="copy-right-box">
        <p>
          Copyright 2020-2021
          <a href="www.baidu.com" target="_blank">Shaobing博客</a>   赣ICP备XXXX号
        </p>
      </div>
      <div>
        <span>关于我</span>
        |
        <span>联系我</span>
        |
        <span>友情链接</span>
      </div>
    </div>

  </div>
</template>

<style>
  .navigation-box i{
    font-size:18px;
    font-weight: 600;

  }
  .default-border-radius{
    border-radius: 4px;
  }
  .navigation-box{
    margin-right: 50px;
  }
  .navigation-box span{
    margin-right: 50px;
    color: #737F90;
    font-size: 18px;
    /*给点击*/
    cursor: pointer;
  }
  .navigation-box span:hover,.login-tips-text-box span:hover{
    color: #A612FF;
  }
  .login-tips-text-box span{
    margin-right: 10px;
    cursor: pointer;
  }
  .login-tips-text-box{
    /*margin-right: 10px;*/
    color: #737F90;
    font-size: 16px;
  }
  .logo-box{
    margin-left: 10px;
  }
  .logo-box .logo{
    color: #737F90;
    font-size: 20px;
    font-weight: 600;
  }
  a{
    text-decoration: none;
  }
  .copy-right-box{
    margin-bottom: 5px;
  }
  *{
    padding: 0;
    margin: 0;
  }
  .blog-footer{
    padding-bottom: 10px;
    text-align: center;
  }
  .blog-header{
    line-height: 25px;
    margin-top: 10px;
    background-color: #fff;
    padding: 10px;
  }
  body{
    background-color: #F2F2FA;
  }
  #blog-box{
    width: 1140px;
    margin: 0 auto;
  }
  .float-left{
    float: left;
  }
  .float-right{
    float: right;
  }
  /*不太清楚这个作用*/
  .clear-fix{
    overflow: hidden;
    zoom: 1;
  }
</style>
