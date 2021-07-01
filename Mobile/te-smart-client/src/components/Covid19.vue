<template>
    <section>
        <h3>
            <img src="../assets/corona.svg" alt="" />
            <span>Covid-19 Tracking</span>
        </h3>
        <div class="main">
            <div class="vietnam">
                <div class="header">
                    <h4>
                        <img src="../assets/vietnam.svg" alt="" />
                        <span>Vietnam</span>
                    </h4>
                </div>
                <div class="flex">
                    <div class="confirmed">
                        <p>
                            <span>{{ vn['Total Cases_text'] }}</span>
                            ({{ vn['New Cases_text'] || '+0' }})
                        </p>
                        <p class="description">Confirmed</p>
                    </div>
                    <div class="deaths">
                        <p>
                            <span>{{ vn['Total Deaths_text'] }}</span> ({{
                                vn['New Deaths_text'] || '+0'
                            }})
                        </p>
                        <p class="description">Deaths</p>
                    </div>
                    <div class="recovered">
                        <p>
                            <span>{{ vn['Total Recovered_text'] }}</span>
                        </p>
                        <p class="description">Recovered</p>
                    </div>
                </div>
            </div>
            <div class="separate"></div>
            <div class="world">
                <div class="header">
                    <h4>
                        <img src="../assets/globe.svg" alt="" />
                        <span>World</span>
                    </h4>
                </div>
                <div class="flex">
                    <div class="confirmed">
                        <p>
                            <span>{{ world['Total Cases_text'] }}</span>
                            ({{ world['New Cases_text'] || '+0' }})
                        </p>
                        <p class="description">Confirmed</p>
                    </div>
                    <div class="deaths">
                        <p>
                            <span>{{ world['Total Deaths_text'] }}</span> ({{
                                world['New Deaths_text'] || '+0'
                            }})
                        </p>
                        <p class="description">Deaths</p>
                    </div>
                    <div class="recovered">
                        <p>
                            <span>{{ world['Total Recovered_text'] }}</span>
                        </p>
                        <p class="description">Recovered</p>
                    </div>
                </div>
            </div>
            <div class="date-time">
                <p>
                    Updated: <span>{{ world['Last Update'] }}</span>
                </p>
            </div>
        </div>
    </section>
</template>

<script>
export default {
    props: {
        vn: Object,
        world: Object,
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
div.header {
    display: flex;
    justify-content: center;
}
h4 {
    display: flex;
    align-items: center;
    font-size: 1.25rem;
    text-align: center;
}
h4 img {
    width: 27px;
}
h4 span {
    margin-left: 0.5rem;
}
.vietnam {
    margin-top: 0.5rem;
}
.world {
    margin-top: 1rem;
}
.flex {
    margin: 0.5rem 1.5rem 0;
    display: flex;
    justify-content: space-between;
}
.world .flex {
    margin: 0.5rem 0 0;
}

.flex div {
    display: flex;
    flex-direction: column;
    align-items: center;
}
p.description {
    margin-top: 0.3rem;
    font-size: 0.8rem;
}
p span {
    font-size: 1.25rem;
    font-weight: bold;
}
.world p {
    font-size: 0.85rem;
}
.world p span {
    font-size: 1rem;
}
.separate {
    width: 36%;
    height: 1px;
    background: rgba(255, 255, 255, 0.45);
    margin: 0.72rem auto 0;
}
.confirmed span {
    color: rgb(255, 126, 126);
}
.deaths span {
    color: rgb(0, 7, 52);
}
.recovered span {
    color: rgb(33, 255, 92);
}
.date-time {
    margin-top: 0.81rem;
    text-align: center;
    color: rgb(244, 213, 75);
}
.date-time p,
.date-time p span {
    font-size: 0.8rem;
}
</style>
