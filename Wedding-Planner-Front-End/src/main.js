import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import VueRouter from 'vue-router'

// import Home from './views/Home';
import NotFound from './views/NotFound';
import Registration from './components/Registration';

Vue.use(VueRouter)

import './scss/main.scss';
import NewMain from "./components/NewMain";
import Home from "./views/Home";


Vue.config.productionTip = false

const router = new VueRouter({
  scrollBehavior(to,from,savedPosition){
    if(savedPosition){
    return savedPosition
    }else{
        const position={};
        if(to.hash){
          position.selector = to.hash
          if(document.querySelector(to.hash)){
            return position;
          }
          return false;
        }
    }
  },
  routes: [
    { path: '/', component: Home },
    { path: '/dashboard', component: NewMain },
    { path: '*', component: NotFound },
    {path:'/Registration', component: Registration}
  ],
  mode: 'hash'
})

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
