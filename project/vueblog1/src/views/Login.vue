<template>
    <div class="login-container" >
<!--        rules：用于校验规则，model：用于绑定数据-->
        <el-form label-width="0px" class="login-form" :rules="loginRules" :model="loginForm" ref="loginRef">
            <h3 class="login-title">系统登录</h3>
            <!--            prop用于绑定rules中的属性-->
            <el-form-item prop="username" >
                <el-input type="text"  placeholder="账号" v-model="loginForm.username" prefix-icon="iconfont icondenglu"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" placeholder="密码" v-model="loginForm.password" prefix-icon="iconfont iconmima"></el-input>
            </el-form-item>
            <el-form-item>
<!--                两种click点击事件-->
                <el-button type="primary" v-on:click="clickLogin">登录</el-button>
                <el-button @click="resetLogin">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data(){
            return{
                loginForm:{
                    username: 'root',
                    password: 'root'
                },
                loginRules:{
                    //和props中的username等属性相关联
                    username:[
                        { required: true, message: '请输入用户名称', trigger: 'blur' },//必填验证
                        { min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur' }//长度验证
                    ],
                    password:[],
                },
            };
        },
        methods:{
            //首先前端验证用户名和密码
            //两种实现方法都可以
            clickLogin:function () {
                const _this = this
                _this.$refs.loginRef.validate(valid =>{
                    //为false，验证错误，返回
                    if (!valid) return;
                    _this.$axios.post('/login',{
                        username: _this.loginForm.username,
                        password: _this.loginForm.password,
                        // headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    }).then(res=>{
                        //注意此处顺序，跳转之前先保存session信息
                        if (res.data.code==200){
                            // _this.$message.success("登录成功")
                            window.sessionStorage.setItem("user",res.data.user)
                            _this.$router.push("/")
                        //    存放返回的user 对象
                        }else {
                            _this.$message.error("用户名或密码错误")
                        }
                    })
                })
            },
            //重置表单
            resetLogin(){
                this.$refs.loginRef.resetFields();
            }
        }
    }
</script>
<style  lang="less" scoped>
.login-container{
    background: url("../assets/img/login.jpg");
    /*background-size: 100% 100%;*/
    height: 100%;
    position: fixed;
    width: 100%
}
    .login-form{
        border-radius: 15px;
        background-clip: padding-box;
        margin: 180px auto;
        width: 300px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
        /*登录和重置按钮居中*/
        text-align: center;
    }
    .login-title {
        margin: 0px auto 40px auto;
        text-align: center;
        color: #505458;
    }
</style>