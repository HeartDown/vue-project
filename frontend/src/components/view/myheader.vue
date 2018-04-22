<template>
  <div class="myheader">
    <h1 class="logo">
      <router-link :to="'/'">
        <img :src="logoSrc" alt="ZH音乐" class="zhmusic_logo">
      </router-link>
    </h1>
    <ul class="mod_top_nav" role="nav">
      <li class="active-li">
        <router-link :to="'/'" class="li-a">
          <h3>首页</h3>
        </router-link>
      </li>
      <li>
        <router-link :to="'/singer'" class="li-a">
          <h3>歌手</h3>
        </router-link>
      </li>
      <li>
        <router-link :to="'/ranking'" class="li-a">
          <h3>排行榜</h3>
        </router-link>
      </li>
    </ul>
    <Input v-model="searchText" size="large" icon="ios-clock-outline" placeholder="搜索音乐，歌手等" class="search"></Input>
    <h1 class="user-login">
      <router-link :to="'/'">
        登陆
      </router-link>
    </h1>
  </div>
</template>
<script>
export default {
  name: 'myheader',
  data() {
    return {
      searchText: '',
      logoSrc:'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2716172531,3407378286&fm=27&gp=0.jpg'
    }
  }
}
</script>


<style lang="scss" scoped>
@import "../scss/_tool.scss";
.myheader {
  height: 100px;
  line-height: 100px;
  .logo {
    font-size: 100%;
    margin: 0;
    padding: 0;
    position: absolute;
    left: 20px;
    .zhmusic_logo {
      width: 200px;
      height: 100px;
    }
  }
  .search {
    position: absolute;
    top: 30px;
    right: 300px;
    width: 400px;
  }
  .user-login {
    position: absolute;
    right: 170px;
  }
  .mod_top_nav {
    list-style-type:none;
    position: absolute;
    font: 12px verdana, arial, sans-serif;
    left: 300px;
    top: 0;
    li {
      padding: 10;
      /* 将默认的内边距去掉 */
      margin: 0px;
      /* 将默认的外边距去掉 */
      float: left;
      /* 往左浮动 */
      font-size: 35px;
      .li-a {
        display: block;
        padding: 0px 80px 80px 0px;
        line-height: 90px;
        height: 90px;
        text-align: center;
        font-size: 18px;
        margin-left: 80px;
      }
    }
    .active-li {
      background-color: #31c27c;
      .li-a {
        color: #fff;
      }
    }
  }
}
</style>
