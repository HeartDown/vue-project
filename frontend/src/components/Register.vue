<template>
  <div class="register" v-title data-title="注册">
    <div class="reg-form">
      <div class="head-info">
        <router-link to="/login" class="to-login">已有账号？前往登录</router-link>
      </div>
      <div class="avtar">
        <img src="../assets/login/avtar.png" alt="登录头像">
        <input type="hidden">
      </div>
      <form>
        <input type="text" placeholder="Username">
        <div class="key">
          <input type="password" placeholder="Password">
        </div>
        <div class="key error">
          <input type="password" placeholder="Confirm Password">
        </div>
      </form>
      <button type="button">注册</button>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Register"
    }
</script>

<style lang="scss" scoped>
  @import "scss/_tool.scss";
  .register {
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 100vh;
    min-height: 100vh;
    width: 100%;
    background: url("../assets/login/bg1.jpg");
    .reg-form{
      background: #2b2b36;
      position: relative;
      width: 30%;
      text-align: center;
      border-radius: rem(15px);
      overflow: hidden;
      margin: 0 auto;
      .head-info{
        padding: 5px 0;
        text-align: left;
        font-weight: 600;
        font-size: rem(32px);
        color: #fff;
        background: #23232e;
        height: rem(50px);
        padding-left: rem(15px);
        .to-login{
          color: white;
          font-size: rem(16px);
        }
      }
      .avtar{
        padding-top: rem(15px);
        padding-bottom: rem(15px);
        img{
          max-width: rem(80px);
          max-height: rem(80px);
          overflow: hidden;
        }
      }
      form{
        input[type="text"]{
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
          &.error{
            background: url("../assets/login/pass.png") no-repeat 447px 17px;
          }
        }
        input[type="password"]{
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
      button[type="button"]{
        margin-top: rem(32px);
        font-size:rem( 30px);
        color: #fff;
        outline: none;
        border: none;
        background: #3ea751;
        width: 100%;
        padding: 18px 0;
        cursor: pointer;
        transition: 1s all;
        &:hover{
          transition: 1s all;
          background: #ff2775;
        }
      }
    }
  }
</style>
