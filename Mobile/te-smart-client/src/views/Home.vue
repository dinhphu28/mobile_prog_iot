<template>
    <div>
        <ion-page>
            <ion-header>
                <ion-toolbar>
                    <ion-title>Welcome home, Admin</ion-title>
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
    </div>
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
    // IonRow,
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
        // IonRow,
        IonCol,
        DeviceCard,
    },
    computed: {
        devices() {
            return this.$store.state.devices
        },
    },
    created() {
        const token = this.$store.state.token
        const config = {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        }
        axios
            .get('http://171.248.169.71:8080/api/v1/devices', config)
            .then((res) => {
                this.$store.dispatch('saveDevices', res.data)
            })
            .catch((err) => console.log(err))
    },
}
</script>
