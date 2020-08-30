<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style>
/*<!--设置边缘-->*/
* {
  margin: 0;
  padding: 0;
}

body {
  background-color: #f5f5f5;
  font-weight: 400;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  line-height: 1.5;
}

a {
  cursor: pointer;
  text-decoration: none;
  transition: none 86ms ease-out;
}

a:hover {
  color: #5FB878;
}

.me-area {
  background-color: #fff;
}

body {
  background-color: #f5f5f5;
  font-weight: 400;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  line-height: 1.5;
  min-height: 100%;
  position: relative;
}


html {
  height: 100%;
}

.me-pull-right {
  float: right;
}
/*设置链接不带下划线*/
/*a{*/
/*  text-decoration: none;*/
/*}*/

</style>
