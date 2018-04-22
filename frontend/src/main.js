import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import 'iview/dist/styles/iview.css';
import iView from 'iview';
import store from './store/store'


Vue.use(iView);
Vue.config.productionTip = false

Vue.prototype.$axios = axios
window.axios = axios


import 'font-awesome/css/font-awesome.css';

/* eslint-disable no-new */
//设置页面title
Vue.directive('title',{
  inserted: function (el, binding) {
      document.title = el.dataset.title;
    }
  }
)

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
