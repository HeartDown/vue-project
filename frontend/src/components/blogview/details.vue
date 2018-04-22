<template>
    <div class="main">
        <Row>
            <Col span="20" offset="1">
            <article id="post-121" class="post-content">
                <div class="content-header">
                    <h1>{{content.title}}</h1>
                    <h5 class="entry-date">
                        <time class="entry-date" datetime="2018-03-20T20:42:58+00:00" pubdate="">
                            {{content.publish.year}}年{{content.publish.monthValue}}月{{content.publish.dayOfMonth}}日
                        </time>
                    </h5>
                </div>
                <div class="content" id="content">
                    <p v-html="content.maincontent"></p>
                </div>
            </article>
            </Col>
            <Col>
            <Affix :offset-top="200">
                <div class="index-affix">
                    <ul>
                        <li>
                            <a>
                                标题1
                            </a>
                        </li>
                    </ul>
                    <a href="javascript:window.scrollTo( 0, 0 );">回顶部</a>
                </div>
                <!-- <span class="index-affix">固定在最顶部</span> -->

            </Affix>
            </Col>
        </Row>
    </div>
</template>
<script>
export default {
    name: 'details',
    data() {
        return {
            content: this.$route.params
        }
    },
    mounted:function(){
        this.GenerateContentList()
    },
    methods: {
        GenerateContentList: function() {
            var mainContent = document.getElementById('content'); //在id为mulu的div里面加载目录
            var h1_list =  document.getElementsByTagName('h1');
             var h2_list =  document.getElementsByTagName('h2');
            //代码中所有的yl指的是在id为yl的div里面匹配h1,h2,h3
            if (mainContent.length < 1)
                return;
            if (h1_list.length > 0) {
                var content = '';
                content += '';
                content += '<h2 id="table-of-contents">目录</h2>';
                content += '<ol class="toc">';
                
            } else {
                
            }
        }
    }
}
</script>

<style lang="scss" scoped>
@import "../scss/_tool.scss";
.main {
    background: #eaeaea;
    .index-affix {
        float: right;
        margin-right: 10px;
        ul {
            list-style: none;
            li {
                background-color: rosybrown;

                width: 110px;
                margin-bottom: 10px;
                font-family: "Roboto Mono", serif;
                font-weight: 400;
                font-size: 14px;
                a {
                    color: #666666;
                }
            }
        }
    }
    .post-content {
        margin-top: 20px;
        margin-bottom: 30px;
        padding: 20px 40px;
        background: #fff;
        .content-header {
            border-bottom: 1px solid #86a0e0;
            h1 {
                display: inline;
            }
            .entry-date {
                color: #999;
                margin-right: 7.6923%;
                float: right;
                min-width: 20%;
                font-size: 1rem;
                line-height: 1.75;
                font-family: lucida grande, lucida sans unicode, lucida, helvetica, Hiragino Sans GB, Microsoft YaHei, WenQuanYi Micro Hei, sans-serif;
                display: inline;
            }
        }
        .content {
            padding-top: 60px;
            padding-left: 30px;
            font-size: 20px;
        }
    }
}
</style>
