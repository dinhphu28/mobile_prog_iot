<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title>Today</ion-title>
            </ion-toolbar>
        </ion-header>

        <ion-content class="ion-padding">
            <weather :w="weather" v-if="weather" />
            <a-q-i v-if="aqi" :aqi="aqi" />
            <covid-19
                v-if="covidDataWorld"
                :vn="covidDataVietnam"
                :world="covidDataWorld"
            />
            <div class="background">
                <img src="../assets/sky.jpg" alt="" />
            </div>
        </ion-content>
    </ion-page>
</template>

<script>
import axios from 'axios'
import openKey from '../assets/apiKey.js'
import {
    IonContent,
    IonHeader,
    IonPage,
    IonTitle,
    IonToolbar,
} from '@ionic/vue'
import Weather from '../components/Weather.vue'
import AQI from '../components/AQI.vue'
import Covid19 from '../components/Covid19.vue'

export default {
    components: {
        IonContent,
        IonHeader,
        IonPage,
        IonTitle,
        IonToolbar,
        Weather,
        AQI,
        Covid19,
    },
    data: () => ({
        weather: null,
        aqi: null,
        covidDataVietnam: null,
        covidDataWorld: null,
    }),
    created() {
        // get weather
        const apiKey = openKey
        axios
            .get(
                `https://api.openweathermap.org/data/2.5/weather?q=ho+chi+minh&units=metric&appid=${apiKey}`
            )
            .then((res) => {
                this.weather = { ...res.data }
            })
            .catch((err) => console.log(err))

        // get AQI
        axios
            .get(
                `http://api.openweathermap.org/data/2.5/air_pollution?lat=10.75&lon=106.6667&appid=${apiKey}`
            )
            .then((res) => {
                this.aqi = { ...res.data.list[0] }
            })
            .catch((err) => console.log(err))

        // get Covid info
        axios
            .get(`https://covid-19.dataflowkit.com/v1/vietnam`)
            .then((res) => {
                this.covidDataVietnam = { ...res.data }
                axios
                    .get(`https://covid-19.dataflowkit.com/v1/world`)
                    .then((res) => (this.covidDataWorld = { ...res.data }))
                    .catch((err) => console.log(err))
            })
            .catch((err) => console.log(err))
    },
}
</script>

<style scoped>
.background {
    position: fixed;
    top: 0;
    bottom: 0;
    right: 0;
    left: 0;
    z-index: -100;
}
.background img {
    height: 100%;
    object-fit: cover;
}
</style>
