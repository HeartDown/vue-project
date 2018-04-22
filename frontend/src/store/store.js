import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex)

const state = {
    isLogin: 0,
    musicList:[]
}
const mutations = {
    changeLogin(state,status){
        state.isLogin = status;
    },
    addMusicList(state,music){
        musicList[musicList.length] = music;
    },
    reduceMusicList(state,music){
        musicList = musicList.filters(item=>{
            return item.song_name != music.song_name;
        })
    }
}

const actions = {
    loginAction({commit}){
        commit('changeLogin',1);
    }
}

export default new Vuex.Store({
    state,
    actions,
    mutations
})