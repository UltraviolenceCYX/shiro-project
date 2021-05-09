import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    username:123,
    sessionId:123
  },
  mutations: {
    login(state,sessionId){

      state.sessionId=sessionId
    },
    logout(state){
      state.username=null
      state.sessionId=null
    }
  },
  actions: {
   
  },
  modules: {
  }
})
