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
            console.log('Hi')
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
