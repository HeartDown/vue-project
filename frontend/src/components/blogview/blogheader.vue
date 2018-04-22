<template>
    <header role="banner" class="myheader">
        <div class="overlay"></div>
        <div class="headerdiv">
            <nav class="intruduction">
                <span class="data-post">
                    <Row>
                        <Col span="4">
                        <router-link to="/" class="index">
                            <h1>眉州卧龙</h1>
                        </router-link>
                        </Col>
                        <Col span="10" offset="10">
                        <ul class="menu">
                            <li class="has-dropdown">
                                <router-link to="/blogindex">
                                    <h1>首页</h1>
                                </router-link>
                            </li>
                            <li>
                                <router-link to="/blogindex">
                                    <h1>分类</h1>
                                </router-link>
                            </li>
                            <li>
                                <router-link to="/singer">
                                    <h1>音乐</h1>
                                </router-link>
                            </li>
                            <li>
                                <input placeholder="搜索" class="search"></input>
                            </li>
                        </ul>
                        </Col>
                    </Row>
                </span>
            </nav>
            <h1 class="pom">
                看山仍是山
            </h1>
            <h1 class="pom">
                望水还是水
            </h1>
            <h1 class="pom">
                仁者、智者也
            </h1>
        </div>
    </header>
</template>
<script>
export default {
    name: 'blogheader',
    data() {
        return {

        }
    }
}
</script>


<style lang="scss" scoped>
@import "../scss/_tool.scss";
.myheader {

    .headerdiv {
        background-repeat: no-repeat;
        background-position: top;
        background-size: cover;
        padding: 228px 0;
        .pom {
            padding: 0 60px;
            font-size: 30px;
            font-family: cursive;
            color: #484d56;
        }
        .intruduction {
            position: absolute;
            min-width: 100%;
            padding: 0 80px;

            z-index: 9;
            top: 50px;
            .data-post {
                border-bottom: 1px solid rgba(255, 255, 255, 0.7);
                display: block;
                .menu {
                    list-style-type: none;
                    margin: 0;
                    width: auto;
                    li {
                        float: left;
                        min-width: 30px;
                        font: 18px/1.5 tahoma, arial, 'Hiragino Sans GB', '\5b8b\4f53', sans-serif;
                        color: #fff;
                        margin-left: 30px;
                        .search {
                            position: absolute;
                            top: 0px;
                            right: 20px;
                            width: 200px;
                            background: space;
                            border: 0;
                            border-bottom: 1px solid #999;
                        }
                        a {
                            color: #fff;
                            text-transform: uppercase;
                            font: 18px/1.5 tahoma, arial, 'Hiragino Sans GB', '\5b8b\4f53', sans-serif;
                            h1 {
                                font: 23px/1.5 STXingkai;
                            }
                        }
                    }
                }
                a {
                    color: #fff;
                    text-transform: uppercase;
                    font: 18px/1.5 tahoma, arial, 'Hiragino Sans GB', '\5b8b\4f53', sans-serif;
                    h1 {
                        font: 30px/1.5 STXingkai;
                    }
                }
            }
        }
        background-image: url('../../assets/header/img_1.jpg');
    }
    .overlay {
        z-index: 0;
        position: absolute;
        bottom: 0;
        top: 0;
        left: 0;
        right: 0;
        background: rgba(39, 41, 43, 0.7);
    }
}
</style>
