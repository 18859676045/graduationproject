<template>




    <div class="login">
        <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-position="left" label-width="0px" class="demo-ruleForm login-container">
            <h3 class="title">系统登录</h3>
            <el-form-item prop="account">
                <el-input type="text" v-model="ruleForm2.account" auto-complete="off" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item prop="checkPass">
                <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off" placeholder="密码"></el-input>
            </el-form-item>
            <el-form-item label="" prop="verify">
                <el-input placeholder="验证码" v-model="ruleForm2.verify"
                          maxlength="5"
                          style="width: 60%" clearable></el-input>
                <el-image
                        style="width: 130px; height: 36px; float: right; border-radius: 4px;margin-top: 1px;"
                        :src="verifyUrl"
                        @click="refresh"
                        fit="fit">
                    <div slot="error" class="image-slot">
                        <i class="el-icon-picture-outline"></i>
                    </div>
                </el-image>
            </el-form-item>
            <!--    <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>-->
            <el-form-item style="width:100%;">
                <el-button type="primary" plain :loading="loginLoading" style="width:100%;" @click.native.prevent="login">登录</el-button>
                <!-- <el-button @click.native.prevent="handleReset2">重置</el-button> -->
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
  import http from '../utils/http'
  import md5 from 'js-md5'
  export default {
      // 当前的名称
      name: "Login",
      // 组件，有引入组件时，放置组件名称。
      comments: {},
      // 数据，v-model绑定数据使用
    data() {

      return {
              // 后面加时间戳，可以避免验证码缓存，只要时间戳改变，验证码会重新加载
              verifyUrl: "http://localhost:8089/captcha/image?time=" + new Date().getTime().toString(),

          note: {
              backgroundImage: "url(" + require("../../static/background.png") + ")",
              backgroundRepeat: "no-repeat",
              backgroundSize: "contain",
              backgroundPosition:"center",
              backgroundBlendMode: "overlay"

          },
        loginLoading: false,
        ruleForm2: {
            verify:'',
          account: 'admin',
          checkPass: '',
        },
        rules2: {

          account: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            //{ validator: validaePass }
          ],
            verify:[
                { required: true, message: '请输入验证码', trigger: 'blur' },
                //{ validator: validaePass2 }
            ],
          checkPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            //{ validator: validaePass2 }
          ]
        },
        checked: true
      };
    },
    methods: {
        // 点击验证码，时间戳改变，重新加载验证码
        refresh() {
            this.verifyUrl = "http://localhost:8089/captcha/image?time=" + new Date().getTime().toString();
        },
      async login() {
        var _this = this
        _this.loginLoading = true
        let params = {
          name:_this.ruleForm2.account,
          pass:md5(_this.ruleForm2.checkPass),
            verify:_this.ruleForm2.verify
        }
        let data = await http.post('user/login', params)
        if(data.status === -404) {
          _this.message(true,data.msg,'error')
          _this.loginLoading = false
          return
        }
        if(data.data.status === 200) {
            console.log(data)
          _this.message(true,data.data.msg,'success')
            console.log(data.data.data);
          sessionStorage.setItem('user', JSON.stringify(data.data.data))
          _this.$router.push({ path: '/Main' })
        } else {
           _this.message(true,data.data.msg,'error')
        }
        _this.loginLoading = false
      },
      handleSubmit2(ev) {
        var _this = this;
        _this.$router.push({ path: '/user/list' });
      },
      /**
			 * ifshow: true/false msg: message  type: error/error/success
			 */
			message(ifshow,msg,type) {
				this.$message({
					showClose: ifshow,
					message: msg,
					type: type
				})
			}
    }
  }

</script>

<style lang="scss" scoped>
  .login-container {
    /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    .title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
    }
    .remember {
      margin: 0px 0px 35px 0px;
    }
  }


  /* 背景图片*/
  .login{
    background:url("../../static/img.png");
    width: 100%;
    height: 100%;
    position:fixed;
    margin-top: -2px;/*上边距*/
    //margin-left: -10px;/*左边距*/
    background-size:100% 100%;
  }

  /* 背景图片*/
  .aaa{
    background:url("../../static/background.png");
    width: 26%;
    height: 24%;
    position:fixed;
    margin-top: 260px;/*上边距*/
    margin-left:460px;/*左边距*/
    background-size:100% 100%;
  }

</style>
