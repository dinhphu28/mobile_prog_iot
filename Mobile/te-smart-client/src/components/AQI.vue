<template>
    <section>
        <h3>
            <img src="../assets/air.svg" alt="" />
            <span>Air Pollution</span>
        </h3>
        <div class="main">
            <div class="left">
                <h4>{{ airPollution }}</h4>
                <p>Ho Chi Minh City</p>
            </div>
            <ul class="right">
                <li>CO: {{ aqi.components.co }}</li>
                <li>O<sub>3</sub>: {{ aqi.components.o3 }}</li>
                <li>PM10: {{ aqi.components.pm10 }}</li>
                <li>NO: {{ aqi.components.no }}</li>
                <li>NO<sub>2</sub>: {{ aqi.components.no2 }}</li>
                <li>PM2.5: {{ aqi.components.pm2_5 }}</li>
                <li>SO<sub>2</sub>: {{ aqi.components.so2 }}</li>
                <li>NH<sub>3</sub>: {{ aqi.components.nh3 }}</li>
            </ul>
        </div>
    </section>
</template>

<script>
export default {
    data: () => ({
        airQuality: ['Good', 'Fair', 'Moderate', 'Poor', 'Very Poor'],
    }),
    props: {
        aqi: Object,
    },
    computed: {
        airPollution() {
            const aqi = this.aqi.main.aqi
            return `${aqi} - ${this.airQuality[aqi - 1]}`
        },
    },
}
</script>

<style scoped>
* {
    padding: 0;
    margin: 0;
}
section {
    margin-top: 1.26rem;
    background: rgba(50, 50, 50, 0.5);
    border-radius: 1rem;
    padding: 0.45rem 1.75rem 1rem;
    -webkit-backdrop-filter: blur(6px);
    backdrop-filter: blur(6px);
}
h3 {
    font-size: 0.8rem;
    display: flex;
    align-items: center;
}
h3 img {
    width: 32px;
}
h3 span {
    margin-left: 0.5rem;
}
h4 {
    font-size: 1.25rem;
    color: rgb(250, 219, 83);
}
ul {
    list-style: none;
    display: grid;
    grid-template-columns: 5rem 5rem 5rem;
    grid-gap: 0.5rem;
}
li {
    font-size: 0.75rem;
}
.main {
    margin-top: 0.72rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.left p {
    font-size: 0.8rem;
    text-transform: uppercase;
    font-weight: bold;
    margin-top: 0.3rem;
}
</style>
