import { createStore } from 'vuex'

export default createStore({
    state: () => ({
        token: '',
        devices: [],
    }),
    mutations: {
        SAVE_TOKEN(state, token) {
            state.token = token
        },
        SAVE_DEVICES(state, devices) {
            state.devices = devices
        },
    },
    actions: {
        saveToken({ commit }, token) {
            commit('SAVE_TOKEN', token)
        },
        saveDevices({ commit }, devices) {
            commit('SAVE_DEVICES', devices)
        },
    },
})
