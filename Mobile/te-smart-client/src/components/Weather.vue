<template>
    <section>
        <h3>
            <img src="../assets/weather.svg" alt="" />
            <span>Weather</span>
        </h3>
        <div class="main">
            <div class="right-info">
                <img :src="iconUrl" alt="weather icon" />
                <div>
                    <h4>{{ w.name }}</h4>
                    <p class="description">{{ description }}</p>
                    <p>Humidity: {{ w.main.humidity }}%</p>
                    <p>Visibility: {{ visibility }}km</p>
                    <p>Wind speed: {{ windSpeed }}km/h</p>
                </div>
            </div>
            <span class="temperature">{{ temperature }}&#8451;</span>
        </div>
    </section>
</template>

<script>
export default {
    props: {
        w: Object,
    },
    computed: {
        iconUrl() {
            const iconCode = this.w.weather[0].icon
            return `http://openweathermap.org/img/wn/${iconCode}@4x.png`
        },
        temperature() {
            return Math.floor(this.w.main.temp)
        },
        description() {
            return this.w.weather[0].description
        },
        visibility() {
            return Math.floor(this.w.visibility / 1000)
        },
        windSpeed() {
            return Math.floor(this.w.wind.speed * 3.6)
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
}
p {
    font-size: 0.8rem;
    margin-top: 0.3rem;
}
p.description {
    text-transform: uppercase;
    font-weight: bold;
    color: rgb(253, 221, 78);
}
.main {
    margin-top: 0.72rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.right-info {
    display: flex;
    align-items: center;
}
.right-info div {
    margin-left: 1rem;
}
span.temperature {
    font-size: 1.75rem;
    font-weight: bold;
    color: rgb(244, 213, 75);
}
img {
    width: 5rem;
}
</style>
