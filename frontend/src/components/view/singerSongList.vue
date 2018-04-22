<template>
    <div class="singer-song">
        <div class="singer-info">
            <div class="singer-img">
                <img :src="'//y.gtimg.cn/music/photo_new/T001R150x150M000'+id+'.jpg?max_age=2592000'">
            </div>
            <div class="singer-all-info">
                <div class="singer-name">
                    <h1>{{singername}}</h1>
                </div>
                <div class="operate">
                    <Button @click="play" style="width: 200px;height: 50px;font-size: 15px;" type="primary" shape="circle" icon="arrow-right-b">播放歌手所有歌曲</Button>
                    <Button @click="play" style="margin-left:30px;width: 200px;height: 50px;font-size: 15px;" type="primary" shape="circle" icon="arrow-right-b">关注该歌手</Button>
                </div>
            </div>
        </div>
        <div class='singer-all-song'>
            <div class="title">
                <h1>所有歌曲</h1>
            </div>
            <div class="song-list">
                <Table highlight-row stripe :columns="columns1" :data="singerSongList"></Table>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'singerSongList',
    data() {
        return {
            id: this.$route.params.Fsinger_mid,
            singername:this.$route.params.Fsinger_name,
            columns1: [
                {
                    type: 'index',
                    width: 60,
                    align: 'center'
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 150,
                    align: 'center',
                    render: (h, params) => {
                        return h('div', [
                            h('Button', {
                                props: {
                                    type: 'ghost',
                                    shape: 'circle',
                                    icon: 'play'
                                },
                                style: {
                                    'font-size': '22px',
                                    'cursor': 'pointer'
                                },
                                on: {
                                    click: () => {
                                        this.play(params.row)
                                    }
                                }
                            }),
                            h('Button', {
                                props: {
                                    type: 'ghost',
                                    shape: 'circle',
                                    icon: 'ios-cloud-download'
                                },
                                style: {
                                    'font-size': '26px',
                                    'margin-left': '20px',
                                    'cursor': 'pointer'
                                },
                                on: {
                                    click: () => {
                                        this.play(params.row)
                                    }
                                }
                            })
                        ]);
                    }
                },
                {
                    title: '操作',
                    key: 'songname',
                    render: ((h, params) => {
                        return h('h1', {
                            style: {
                                'font-size': '15px'
                            },
                        }, params.row.songname)
                    }
                    )
                },
                {
                    title: '专辑',
                    key: 'albumname',
                    render: ((h, params) => {
                        return h('h1', {
                            style: {
                                'font-size': '15px'
                            },
                        }, params.row.albumname)
                    }
                    )
                },
                {
                    title: '时长',
                    key: 'interval',
                    render: (h, params) => {
                        return h('div', [
                            h('Icon', {
                                props: {
                                    type: 'ios-time'
                                },
                                style: {
                                    'font-size': '20px'
                                },
                            }),
                            h('strong',
                                {
                                    style: {
                                        'font-size': '20px',
                                        'margin-left': '20px'
                                    },
                                }
                                , this.parseTime(params.row.interval)
                            )
                        ]);
                    }
                }
            ],
            singerSongList: []
        }
    },
    methods: {
        play: function(row) {
            this.$router.push({
                name:'playMusic',
                params: row
            });
        },
        parseTime(interval) {
            return parseInt(interval / 60) + ":" + interval % 60;
        }
    },
    mounted: function() {
        var _this = this;
        axios.get("/api/getSingerSongList", {
            params: {
                'id': _this.id
            }
        }).then(response => {
            _this.singerSongList = response.data;
        })
    }
}
</script>
<style lang="scss" scoped>
@import "../scss/_tool.scss";
.singer-song {
    background-color: #ddd;
    padding-left: 30px;
    padding-right: 30px;
    .singer-info {
        position: relative;
        height: 250px;
        padding-left: 305px;
        margin-top: 40px;
        margin-bottom: 35px;
        .singer-img {
            position: absolute;
            left: 0;
            top: 0;
            width: 250px;
            height: 250px;
            border-radius: 999px;
            overflow: hidden;
        }
        .singer-all-info {
            top: 10px;
            .singer-name {
                margin-top: 20px;
                line-height: 80px;
                h1 {
                    font-family: monospace;
                    font-size: -webkit-xxx-large;
                }
            }
            .operate {
                margin-top: 20px;
            }
        }
    }
    .singer-all-song {

        .title {
            h1 {
                font-family: 'STXingkai';
                font-size: 35px;
            }
        }
        .song-list {}
    }
}
</style>