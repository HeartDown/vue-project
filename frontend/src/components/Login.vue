<template>
  <div class="login" v-title data-title="登录">
    <div class="login-form">
      <div class="head-info">
        <i class="fa fa-close"></i>
        <router-link to="/register" class="to-register">没有账号？前往注册</router-link>
      </div>
      <div class="avtar">
        <img src="../assets/login/avtar.png" alt="登录头像">
      </div>
      <form>
        <input type="text" placeholder="Enter Username" v-model="data.username">
        <div class="key error">
          <input type="password" v-model="data.password" placeholder="Enter Password">
        </div>
      </form>
      <button type="button" @click="login">登录</button>
    </div>
  </div>
</template>

<script>
import { mapActions,mapState } from 'vuex' 
export default {
  name: "login",
  data() {
    return {
      data: {
        username: 'zh',
        password: '1234'
      }
    }
  },
  methods: {
    login: function() {
      var _this = this;
      axios.post(
        '/api/login',
        this.data
      )
        .then(response => {
          if (response.data.result) {
            alert(response.data.message);
            _this.$store.dispatch('loginAction');
            _this.$router.push({ path: "/blogindex" })
          } else
            alert(response.data.message);
        })
    }
  },
  mounted: function() {
    var myparmes = {
      'callback': 'MusicJsonCallback_lrc',
      'pcachetime': new Date().getTime(),
      'songmid': '002B2EAA3brD5b',
      'g_tk': '5381',
      'jsonpCallback': 'MusicJsonCallback_lrc',
      'loginUin': '709717196', 'hostUin':'0',
      'format': 'jsonp', 'inCharset': 'utf8', 'outCharset': 'utf-8',
      'notice': '0', 'platform': 'yqq', 'needNewCode': '0'
    };
    //  axios.get("/fcg_query_lyric_new.fcg", {
    //         params: myparmes
    //     }).then(response => {
    //         console.log(response.data);
    //     })
  }

}
</script>

<style lang="scss" scoped>
@import "scss/_tool.scss";
.login {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 100vh;
  min-height: 100vh;
  width: 100%;
  background: url("../assets/login/bg1.jpg");
  .login-form {
    background: #2b2b36;
    position: relative;
    width: 30%;
    text-align: center;
    border-radius: rem(15px);
    overflow: hidden;
    margin: 0 auto;
    .head-info {
      display: flex;
      justify-content: space-between;
      text-align: right;
      font-weight: 600;
      font-size: rem(16px);
      color: #fff;
      background: #23232e;
      height: rem(50px);
      padding: 0 rem(15px);
      line-height: rem(50px);
      i {
        line-height: rem(50px);
        font-size: rem(20px);
        cursor: pointer;
      }
      .to-register {
        color: white;
        font-size: rem(16px);
      }
    }
    .avtar {
      padding-top: rem(15px);
      padding-bottom: rem(15px);
      img {
        max-width: rem(80px);
        max-height: rem(80px);
        overflow: hidden;
      }
    }
    form {
      input[type="text"] {
        width: 70%;
        padding: 1em 2em 1em 3em;
        color: #9199aa;
        font-size: 18px;
        outline: none;
        background: url("../assets/login/adm.png") no-repeat 10px 15px;
        border: none;
        font-weight: 100;
        border-bottom: 1px solid#484856;
        margin-top: 2em;
      }
      .key {
        &.error {
          position: relative;
          background: url("../assets/login/pass.png") no-repeat 447px 17px;
        }
      }
      input[type="password"] {
        width: 70%;
        padding: 1em 2em 1em 3em;
        color: #dd3e3e;
        font-size: rem(18px);
        outline: none;
        background: url("../assets/login/key.png") no-repeat 10px 23px;
        border: none;
        font-weight: 100;
        border-bottom: 1px solid#484856;
      }
    }
    button[type="button"] {
      margin-top: rem(32px);
      font-size: rem( 30px);
      color: #fff;
      outline: none;
      border: none;
      background: #3ea751;
      width: 100%;
      padding: 18px 0;
      cursor: pointer;
      transition: 1s all;
      &:hover {
        transition: 1s all;
        background: #ff2775;
      }
    }
  }
}
</style>
