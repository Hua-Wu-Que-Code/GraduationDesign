const state = {
  healthCareInfo: []
}

const mutations = {
  ADD_HealthCareInfo: (state, healthCareInfo) => {
    state.healthCareInfo = healthCareInfo
  },
}

const actions = {
  addHealthCareInfo({ commit }, healthCareInfo) {
    console.log("jjj")
    commit('ADD_HealthCareInfo', healthCareInfo)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
