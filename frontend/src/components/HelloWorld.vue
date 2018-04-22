<template>
  <div>
    <Carousel autoplay v-model="value2" loop>
      <CarouselItem v-for="item in imgSrc">
        <div class="demo-carousel">
          <a :href="item.linkUrl">
            <img :src="item.picUrl" class="demo-img">
          </a>
        </div>
      </CarouselItem>
    </Carousel>
  </div>
</template>
<script>
export default {
  name: 'Index',
  data() {
    return {
      value2: 0,
      imgSrc: []
    }
  },
  mounted: function() {
    var _this = this;
    axios.get("/api/getTheCarouseImg")
      .then(response => {
        _this.imgSrc = response.data
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>

.demo-carousel {
  min-height: 500px;
  background-color: #d55;
  .demo-img{
    width: 100%;
  }
}
</style>
