<template>
    <ion-page>
        <ion-tabs>
            <ion-tab-bar slot="bottom">
                <ion-tab-button tab="home" href="/home/devices">
                    <ion-icon :icon="home"></ion-icon>
                    <ion-label>Home</ion-label>
                </ion-tab-button>

                <ion-tab-button tab="today" href="/home/today">
                    <ion-icon :icon="cloudyNight"></ion-icon>
                    <ion-label>Today</ion-label>
                </ion-tab-button>
            </ion-tab-bar>
        </ion-tabs>
    </ion-page>
</template>

<script>
import { IonIcon, IonLabel, IonTabBar, IonTabButton, IonTabs } from '@ionic/vue'

import { home, cloudyNight } from 'ionicons/icons'
export default {
    data() {
        return {
            home,
            cloudyNight,
        }
    },
    components: {
        IonIcon,
        IonLabel,
        IonTabBar,
        IonTabButton,
        IonTabs,
    },
}
</script>
