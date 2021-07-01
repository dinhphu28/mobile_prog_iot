import { createRouter, createWebHistory } from '@ionic/vue-router'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'
import Devices from '../views/Devices.vue'
import Today from '../views/Today.vue'
import ChangePassword from '../views/ChangePassword.vue'
import AddDevice from '../views/AddDevice.vue'

const routes = [
    {
        path: '/',
        redirect: '/login',
    },
    {
        path: '/login',
        component: Login,
    },
    {
        path: '/home/',
        component: Home,
        name: 'Home',
        children: [
            {
                path: '',
                redirect: 'devices',
            },
            {
                path: 'devices',
                component: Devices,
            },
            {
                path: 'today',
                component: Today,
            },
        ],
    },
    { path: '/change-password', component: ChangePassword },
    { path: '/add-device', component: AddDevice },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
})

export default router
