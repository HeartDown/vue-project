<template>
    <Row style="background: #e6e6e6;padding-bottom: 30px;">
        <div class="thebody">
            <ul class="content-ul">
                <Col span="20" offset="2">
                <li v-for="content in contentlist" class="content-li">
                    <a @click="seedetails(content)">
                        <div class="entry-img" :style="{'backgroundImage':'url(/static/'+content.img+')'}"></div>
                        <div class="entry-desc">
                            <h3>{{content.title}}</h3>
                            <p>{{content.slogcontent}}</p>
                        </div>
                    </a>
                    <a class="post-meta">
                        {{content.type.typename}}
                        <span class="date-posted">
                            {{content.publish.year}}年{{content.publish.monthValue}}月{{content.publish.dayOfMonth}}日
                        </span>
                    </a>
                </li>
                </Col>
            </ul>
            <Page :total="total" :page-size="5" @on-change="updateContent" show-total show-elevator class="page"></Page>
        </div>
        <Affix :offset-top="200">
            <div class="index-affix">
                <ul>
                    <li v-for="item in contentlist">
                        <a @click="seedetails(item)">
                            {{item.title.length>10?item.title.substr(0,10)+'...':item.title}}
                        </a>
                    </li>
                </ul>
            </div>
            <!-- <span class="index-affix">固定在最顶部</span> -->
        </Affix>

    </Row>
</template>
<script>
export default {
    name: 'blogindex',
    data() {
        return {
            contentlist: [],
            total: 0,
            pageinfo: {
                "page": 0,
                "size": 5
            }
        }
    },
    mounted: function() {
        this.updateContent()
    },
    methods: {
        seedetails: function(content) {
            this.$router.push({
                name: 'details',
                params: content
            });
        },
        updateContent: function(data) {
            if (data)
                this.pageinfo.page = data-1
            axios.post("/api/content/getAll", this.pageinfo)
                .then(response => {
                    if (response) {
                        this.contentlist = response.data.content;
                        this.total = response.data.totalElements
                    }
                })
        }
    }
}
</script>


<style lang="scss" scoped>
@import "../scss/_tool.scss";
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

.thebody {
    font-family: "Roboto Mono", serif;
    font-weight: 400;
    font-size: 14px;
    line-height: 1.7;
    color: #666666;
    .page {
        float: right;
        margin-right: 500px;
        margin-top: 30px;
    }
    .content-ul {
        top: 30px;
        display: flex;
        position: relative;
        float: left;
        padding: 0;
        margin: 0;
        width: 100%;
        margin-left: -2%;

        .content-li {
            display: block;
            padding: 0;
            margin: 0 0 20px 2%;
            list-style: none;
            min-height: 400px;
            background-position: center center;
            background-size: cover;
            background-repeat: no-repeat;
            float: left;
            clear: left;
            position: relative;
            background: #fff;
            width: 98%;
            a {
                color: #F73859;
                -webkit-transition: 0.5s;
                -o-transition: 0.5s;
                transition: 0.5s;
                text-decoration: none;
                .entry-img {
                    display: table-cell;
                    vertical-align: top;
                    background-size: cover;
                    background-repeat: no-repeat;
                    background-position: 50% 50%;
                    min-width: 680px;
                    height: 400px;
                }
                .entry-desc {
                    background: #fff;
                    padding: 30px;
                    display: table-cell;
                    width: 50%;
                    margin-bottom: 40px;
                    p {
                        margin-top: 50px;
                        color: #1a1a1a;
                        line-height: 1.9;
                        margin-bottom: 20px;
                        font-family: "Roboto Mono", serif;
                        font-weight: 400;
                        font-size: 14px;
                    }
                }
            }
            .post-meta {
                position: absolute;
                bottom: 30px;
                display: block;
                padding: 0 30px;
                margin-left: 60%;
                .date-posted {
                    margin-left: 10px;
                    box-sizing: border-box;
                }
            }
        }
    }
}
</style>
