<template>
    <ion-page>
        <ion-content>
            <h1 class="header ion-text-center">Login to TE Smart</h1>
            <form @submit.prevent class="ion-padding ion">
                <ion-list>
                    <ion-item>
                        <ion-label position="floating">Home's domain</ion-label>
                        <ion-input
                            v-model="domain"
                            @input="errorMessage = ''"
                            @keydown.enter="handleLogin"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-label position="floating">Username</ion-label>
                        <ion-input
                            v-model="username"
                            @input="errorMessage = ''"
                            @keydown.enter="handleLogin"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-label position="floating">Password</ion-label>
                        <ion-input
                            type="password"
                            v-model="password"
                            @input="errorMessage = ''"
                            @keydown.enter="handleLogin"
                        ></ion-input>
                    </ion-item>
                    <p class="invalid-error" v-if="errorMessage !== ''">
                        {{ errorMessage }}
                    </p>
                    <ion-button
                        @click="handleLogin"
                        expand="block"
                        class="login-button"
                        >Login</ion-button
                    >
                    <router-link to="/change-password" class="router-link"
                        >Change your password</router-link
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
} from '@ionic/vue'
export default {
    data: () => ({
        username: '',
        password: '',
        domain: '',
        errorMessage: '',
    }),
    methods: {
        handleLogin() {
            if (
                this.username === '' ||
                this.password === '' ||
                this.domain === ''
            ) {
                this.errorMessage = 'Please fill all fields!'
                return
            }
            this.$store.dispatch('saveDomain', this.domain)
            const account = {
                username: this.username,
                password: this.password,
                accountType: 1,
            }
            axios
                .post(`${this.domain}/api/v1/auth`, account)
                .then((res) => {
                    this.$store
                        .dispatch('saveToken', res.data.token)
                        .then(() => {
                            this.$router.push('/home/devices')
                        })
                })
                .catch(
                    () =>
                        (this.errorMessage =
                            'Domain, username or password is invalid. Please try again!')
                )
        },
    },
    components: {
        IonPage,
        IonInput,
        IonItem,
        IonLabel,
        IonList,
        IonContent,
        IonButton,
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
.router-link {
    text-decoration: none;
    text-align: center;
    display: block;
    margin: 1rem 0;
}
.router-link:hover {
    text-decoration: underline;
}
</style>
