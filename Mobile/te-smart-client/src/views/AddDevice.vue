<template>
    <ion-page>
        <ion-content>
            <h1 class="header ion-text-center">
                Add a new device
            </h1>
            <form @submit.prevent class="ion-padding ion">
                <ion-list>
                    <ion-item>
                        <ion-label position="floating">Device's name</ion-label>
                        <ion-input
                            v-model="deviceName"
                            @input="errorMessage = ''"
                            @keydown.enter="handleCreateDevice"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-label position="floating"
                            >Description for device</ion-label
                        >
                        <ion-input
                            v-model="deviceDescription"
                            @input="errorMessage = ''"
                            @keydown.enter="handleCreateDevice"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-label>Type of the device</ion-label>
                        <ion-select
                            placeholder="Select One"
                            v-model="deviceType"
                        >
                            <ion-select-option value=""
                                >Input device</ion-select-option
                            >
                            <ion-select-option value="true"
                                >Output device</ion-select-option
                            >
                        </ion-select>
                    </ion-item>
                    <ion-item>
                        <ion-label
                            >Type of device's data (on/off or a
                            value)</ion-label
                        >
                        <ion-select placeholder="Select One" v-model="dataType">
                            <ion-select-option value=""
                                >On/Off</ion-select-option
                            >
                            <ion-select-option value="true"
                                >A value</ion-select-option
                            >
                        </ion-select>
                    </ion-item>
                    <p class="invalid-error" v-if="errorMessage !== ''">
                        {{ errorMessage }}
                    </p>
                    <ion-button
                        expand="block"
                        class="login-button"
                        @click="handleCreateDevice"
                        >Create this device</ion-button
                    >
                </ion-list>
            </form>
        </ion-content>
    </ion-page>
</template>

<script>
import axios from 'axios'
import {
    IonPage,
    IonInput,
    IonItem,
    IonLabel,
    IonList,
    IonContent,
    IonButton,
    IonSelect,
    IonSelectOption,
} from '@ionic/vue'
export default {
    components: {
        IonPage,
        IonInput,
        IonItem,
        IonLabel,
        IonList,
        IonContent,
        IonButton,
        IonSelect,
        IonSelectOption,
    },
    data: () => ({
        deviceName: '',
        deviceDescription: '',
        deviceType: null,
        dataType: null,
        errorMessage: '',
    }),
    methods: {
        handleCreateDevice() {
            if (this.deviceName === '' || this.deviceDescription === '') {
                this.errorMessage = 'Please fill all fields!'
                return
            }

            const domain = this.$store.state.domain
            const token = this.$store.state.token
            const config = {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            }
            const device = {
                deviceName: this.deviceName,
                deviceDescription: this.deviceDescription,
                deviceType: !!this.deviceType,
                dataType: !!this.dataType,
                bitValue: false,
                decimalValue: 0.0,
            }
            axios
                .post(`${domain}/api/v1/devices`, device, config)
                .then(() => {
                    this.router.push('/home/devices')
                })
                .catch((err) => console.log(err))
        },
    },
}
</script>

<style scoped>
.header {
    margin-top: 5rem;
}
.login-button {
    margin-top: 2rem;
}
.invalid-error {
    margin-left: 1rem;
    font-size: 0.85rem;
    color: var(--ion-color-danger);
}
</style>
