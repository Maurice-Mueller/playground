import Vue from 'vue'
import App from './App.vue'
import Message from './Message.vue'
import VueRouter from 'vue-router'
import Users from './Users.vue'
import Home from './Home.vue'

Vue.use(VueRouter); //add router plugin to main vue
Vue.component('app-message', Message)

const routes = [
  {path: '/users', component: Users},
  {path: '/home', component: Home},
]

const router = new VueRouter({
  routes //if the value and valuename are equal, you can use this short writing (it's short for routes: routes)
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
