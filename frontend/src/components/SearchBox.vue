<template>
     <transition name="search">
        <div v-if="isShow" class="search-main">
            <input type="text" class="search-input" v-model="searchValue" placeholder="请输入歌曲/歌手"
                   @keyup.enter="search(searchValue)">
            <button class="search-btn" @click="search(searchValue)">查询</button>
            <ul class="result-list">
                <li class="item" v-for="item in resultList">
                    <span class="overflow-h song-name">{{item.song_name}}</span>
                    <span class="overflow-h singer">{{item.artist_name}}</span>
                    <span class="overflow-h album">{{item.album_name}}</span>
                    <button class="add-song" title="点击添加到播放列表" @click="pushInList(item)">+</button>
                    <button class="play-song" title="点击播放" @click="playNow(item)">播放</button>
                </li>
            </ul>
            <button class="search-close" @click="close">←</button>
        </div>
    </transition>
</template>

<script>
export default {
    name:'searchBox',
  props: {
        isShow: Boolean,
        openFun: Function
    },
    data() {
        return {
            resultList: [],
            searchValue: '',
        }
    },
    methods: {
        close() {
            this.openFun();
        },
        search(value) {
            //                let url = `https://api.xiami.com/web?v=2.0&app_key=1&key=${value}&page=1&limit=50&callback=callBack&r=search/songs`;
            //                this.http(url);
            $.ajax({
                url: `http://localhost:3000/song?v=2.0&app_key=1&key=${value}&page=1&limit=50&callback=callBack&r=search/songs`,
                dataType: 'jsonp',
                data: '',
                jsonp: 'callback1',
                success: function(data) {
                    if (res && res.data) {
                        self.resultList = res.data.songs;
                    }
                }
            })
        },
        http(url) {
            var script = document.createElement('script');
            script.type = 'text/javascript';
            script.src = url;
            let destroy = function() {
                console.log('script is onload');
                document.head.removeChild(script);
            }
            //script.addEventListener("load", destroy, false);
            document.head.appendChild(script);
        },
        pushInList(item) {
            console.log('init push')
            this.$emit('push-song', item);
        },
        playNow(item) {
            this.$emit('play-song', item);
        }
    },
    mounted() {
        
    }
}
</script>
