import { createStore } from 'vuex'

export default createStore({
    state: () => ({
        token: '',
        domain: '',
        devices: [],
    }),
    mutations: {
        SAVE_TOKEN(state, token) {
            state.token = token
        },
        SAVE_DEVICES(state, devices) {
            state.devices = devices
        },
        SAVE_DOMAIN(state, domain) {
            state.domain = domain
        },
    },
    actions: {
        saveToken({ commit }, token) {
            commit('SAVE_TOKEN', token)
        },
        saveDevices({ commit }, devices) {
            commit('SAVE_DEVICES', devices)
        },
        saveDomain({ commit }, domain) {
            commit('SAVE_DOMAIN', domain)
        },
    },
})
