<template>
    <div>

        <div class="singerList">
            <ul class="singer-hot-nav">
                <li v-for="hotitem in searchList.hot">
                    <a @click="search(hotitem)">
                        {{hotitem}}
                    </a>
                </li>
            </ul>
        </div>

        <div class="pic-singer">
            <ul class="ul-pic-singer">
                <li v-for="data in singerData" class="li-pic-singer">
                    <Card :bordered="false" class="card">
                        <p slot="title">{{data.Fsinger_name}}</p>
                        <a href="javascript:void(0)" @click="singerSong(data)">
                            <img :src="'//y.gtimg.cn/music/photo_new/T001R150x150M000'+data.Fsinger_mid+'.jpg?max_age=2592000'">
                        </a>
                    </Card>
                </li>
            </ul>

        </div>

    </div>
</template>
<script>
export default {
    name: 'singerList',
    data() {
        return {
            searchList: {
                "hot": ['全部', '华语男', '华语女', '华语组合', '韩国男', '韩国女', '韩国组合', '日本男', '日本女', '日本组合',
                    '欧美男', '欧美女', '欧美组合', '乐团', '演奏家', '作曲家', '指挥家', '其他'],
                "type": []
            },
            singerData: []
        }
    },
    methods: {
        search: function(item) {

        },
        singerSong(data){
             this.$router.push({
                name:'singerSongList',
                params: data
            });
        }
    },
    mounted: function() {
        var _this = this;
        axios.get('/api/getSingerList')
            .then(response => {
                _this.singerData = response.data;
            })
    }
}
</script>
<style lang="scss" scoped>
@import "../scss/_tool.scss";

.singerList {
    height: 200px;

    .singer-hot-nav {
        list-style-type: none;
        background-color: #ccc;
        position: absolute;
        font: 12px verdana, arial, sans-serif;
        left: 100px;
        right: 80px;
        top: 10px;
        li {
            float: left;
            margin: 20px;
            a {
                font-size: 20px;
                color: #000;
            }
        }
    }
}

.pic-singer {

    overflow: hidden;
    text-align: center;
    .ul-pic-singer {
        list-style-type: none;
        margin-right: -20px;
        overflow: hidden;
        zoom: 1;
        margin-bottom: 4px;
        margin-left: 100px;
        .li-pic-singer {
            padding: 10px;
            float: left;
            width: 300px;
            img {
                border-radius: 126px;
                cursor: pointer;
            }
            .card {
                border: 1px solid #a87c089e;
            }
        }
    }
}
</style>
