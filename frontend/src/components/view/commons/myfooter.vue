<template>
    <footer class="myfooter">
        <div class="footerdiv">
            © 2018 ZH
        </div>
    </footer>
</template>
<script>
export default {
    name: 'myfooter',
    data() {
        return {

        }
    }
}
</script>
<style lang="scss" scoped>
@import "../../scss/_tool.scss";
.myfooter {
    background-color: #212324;
    color: #fff;
    font-size: 16px;
    .footerdiv {
        text-align: center;
        margin: 0;
        padding: 30px 15px;
        font-weight: 700;
    }
}
</style>