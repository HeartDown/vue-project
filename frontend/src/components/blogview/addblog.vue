<template>
    <div class="main">
        <Row style="display:-webkit-inline-box;" class="myrow">
            <h1 class="title-text">
                标题
            </h1>
            <Input class="title" v-model="form.title">
            <Select :model.sync="select3" slot="prepend" style="width: 80px">
                <Option value="1">原创</Option>
                <Option value="2">转载</Option>
            </Select>
            <Button slot="append" icon="ios-search"></Button>
            </Input>
        </Row>
        <Row style="display:-webkit-inline-box;" class="myrow">
            <h1 class="title-text">
                封面
            </h1>
            <Input class="title">
            <Select :model.sync="select3" slot="prepend" style="width: 80px">
                <Option value="1">原创</Option>
                <Option value="2">转载</Option>
            </Select>
            <Button slot="append" icon="ios-search"></Button>
            </Input>
        </Row>
        <div id="editor">
            <p>请输入内容...</p>
        </div>
        <div class="submit">
            <Form :model="form" :label-width="80" style="border: 1px solid #f7aeae;">
                <FormItem label="文章标签" prop="label">
                    <Checkbox-group :model.sync="form.label">
                        <Checkbox v-for="item in label" :value="''+item.labelname">{{item.labelname}}</Checkbox>
                    </Checkbox-group>
                </FormItem>
                <FormItem label="文章分类" prop="type">
                    <Select v-model="form.type.str" style="width:30%">
                        <Option v-for="item in type"  :value="item.id+'-'+item.typename">{{item.typename}}</Option>
                    </Select>
                </FormItem>
                <FormItem label="私密文章">
                    <i-switch @on-change="change" size="large">
                        <span slot="open">私密</span>
                        <span slot="close">公开</span>
                    </i-switch>
                </FormItem>
                <FormItem>
                    <Button type="primary" @click="handleSubmit()">提交</Button>
                </FormItem>
            </Form>
        </div>
    </div>
</template>
<script>
import wangeditor from 'wangeditor';
export default {
    name: 'addblog',
    data() {
        return {
            select3: "1",
            form: {
                maincontent: '',
                type: {

                }
            },
            type: [],
            label: []
        }
    },
    methods: {
        getContent: function() {
            alert(this.form.maincontent)
        },
        handleSubmit: function() {
            this.form.type.id = this.form.type.str.split('-')[0]
            this.form.type.typename = this.form.type.str.split('-')[1]
            axios.post(
                '/api/content/insertOrUpdate',
                this.form
            ).then(response => {
                if (response.data.result) {
                    this.$router.push({
                        name: 'blogindex'
                    });
                }
            })
        },
        change: function() {

        },
        changeType: function() {
            alert('1')
        }
    },
    mounted() {
        var editor = new wangeditor('#editor')
        editor.customConfig.onchange = (html) => {
            this.form.maincontent = html
        }
        editor.create()
        document.getElementsByClassName('w-e-text-container')[0].style.height = '500px';
        axios.get(
            '/api/type/getAll'
        ).then(response => {
            this.type = response.data;
        })
        axios.get(
            '/api/label/getAll'
        ).then(response => {
            this.label = response.data;
        })
    }
}
</script>
<style lang="scss" scoped>
@import "../scss/_tool.scss";
.main {
    background: #fff;
    #editor {
        background: #f3f3f3;
        margin: 40px 40px;
    }
    .myrow {
        padding: 20px 0 0 0;
        .title {
            width: 150vh;
        }
        .title-text {
            display: inline;
            font: 28px/1.5 STXingkai;
            ;
            margin: 0px 40px;
        }
    }
    .submit {
        padding: 0px 20px 20px 20px;
    }
}
</style>