<template>
    <ion-card>
        <ion-card-header>
            <div class="top-header">
                <ion-card-title class="title">
                    {{ device.deviceName }}
                </ion-card-title>
                <ion-toggle
                    v-if="!device.deviceType"
                    :checked="device.bitValue"
                    @ionChange="handleChangeState"
                />
            </div>
            <ion-card-subtitle class="description">
                {{ device.deviceDescription }}
            </ion-card-subtitle>
        </ion-card-header>
    </ion-card>
</template>

<script>
import axios from 'axios'
import {
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardSubtitle,
    IonToggle,
} from '@ionic/vue'
export default {
    props: {
        device: Object,
    },
    components: {
        IonCard,
        IonCardHeader,
        IonCardTitle,
        IonCardSubtitle,
        IonToggle,
    },
    methods: {
        handleChangeState() {
            const domain = this.$store.state.domain
            const token = this.$store.state.token
            const config = {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            }
            const data = {
                ...this.device,
                bitValue: !this.device.bitValue,
            }
            axios
                .put(`${domain}/api/v1/devices/${this.device.id}`, data, config)
                .then(() => {
                    axios
                        .get(`${domain}/api/v1/devices`, config)
                        .then((res) => {
                            this.$store.dispatch('saveDevices', res.data)
                        })
                        .catch((err) => console.log(err))
                })
                .catch((err) => console.log(err))
        },
    },
}
</script>

<style scoped>
.title,
.description {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.top-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}
</style>
