import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Register from  '@/components/Register'
import Singer from  '@/components/view/singerList'
import singerSongList from  '@/components/view/singerSongList'
import playMusic from  '@/components/view/playMusic'
import BlogIndex from '@/components/blogview/blogindex'
import details from '@/components/blogview/details'
import addblog from '@/components/blogview/addblog'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: BlogIndex
    },
    {
      path: '/blogindex',
      name: 'blogindex',
      component: BlogIndex
    },
    {
      path: '/addblog',
      name: 'addblog',
      component: addblog
    },
    {
      path: '/details',
      name: 'details',
      component: details
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/singer',
      name: 'Singer',
      component: Singer
    },

    {
      path: '/singerSongList',
      name: 'singerSongList',
      component: singerSongList
    },
    {
      path: '/playMusic',
      name: 'playMusic',
      component: playMusic
    }
  ]
})
