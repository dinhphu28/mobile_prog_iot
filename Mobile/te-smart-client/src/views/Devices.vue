<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title>Welcome home, Admin</ion-title>
                <ion-buttons slot="end">
                    <router-link to="/add-device" class="add-link"
                        >Add new device</router-link
                    >
                </ion-buttons>
            </ion-toolbar>
        </ion-header>
        <ion-content>
            <ion-grid>
                <ion-col v-for="device in devices" :key="device.id">
                    <device-card :device="device" />
                </ion-col>
            </ion-grid>
        </ion-content>
    </ion-page>
</template>

<script>
import axios from 'axios'
import {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonGrid,
    IonCol,
} from '@ionic/vue'
import DeviceCard from '../components/DeviceCard.vue'
export default {
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonGrid,
        IonCol,
        DeviceCard,
    },
    computed: {
        devices() {
            return this.$store.state.devices
        },
    },
    created() {
        const domain = this.$store.state.domain
        const token = this.$store.state.token
        const config = {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        }
        axios
            .get(`${domain}/api/v1/devices`, config)
            .then((res) => {
                this.$store.dispatch('saveDevices', res.data)
            })
            .catch((err) => console.log(err))
    },
    methods: {},
}
</script>

<style scoped>
.add-link {
    margin-right: 1rem;
    text-decoration: none;
}
.add-link:hover {
    text-decoration: underline;
}
</style>
