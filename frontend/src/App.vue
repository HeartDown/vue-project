<template>
  <div id="app">
    
      <myheader v-if="this.$route.path!='/login' && this.$route.path!='/playMusic'"></myheader>

    <Row style="">
      <Col>
      <router-view/>
      </Col>
    </Row>
    <myfooter v-if="this.$route.path!='/playMusic'"></myfooter>
  </div>
</template>

<script>
import myheader from "./components/blogview/blogheader.vue";
import myfooter from "./components/view/commons/myfooter.vue";

export default {
  name: 'app',
  components: {
    'myheader': myheader,
    'myfooter': myfooter,
  },
  methods:{
    showheader:function(){
      return 2==1;
      return this.$route.path!='/login';
    }
  }
}
</script>

<style lang="scss">
@import "components/scss/_define.scss";
body {
  margin: 0!important;
  color: $main-font-color;
}
</style>
