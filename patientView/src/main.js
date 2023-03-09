import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import network from "./network/index";
Vue.prototype.$ajax = network;
Vue.config.productionTip = false

import Vant from 'vant';
import 'vant/lib/index.css';

Vue.use(Vant);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
