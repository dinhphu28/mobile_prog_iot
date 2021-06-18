import { createRouter, createWebHistory } from '@ionic/vue-router'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'

const routes = [
    {
        path: '/',
        redirect: '/login',
    },
    {
        path: '/login',
        component: Login,
    },
    { path: '/home', component: Home },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
})

export default router
