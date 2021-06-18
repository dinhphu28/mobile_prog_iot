<template>
    <ion-page>
        <ion-content>
            <h1 class="header ion-text-center">Login to TE Smart</h1>
            <form @submit.prevent class="ion-padding ion">
                <ion-list>
                    <ion-item>
                        <ion-label position="floating">Username</ion-label>
                        <ion-input
                            v-model="username"
                            @input="errorMessage = ''"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-label position="floating">Password</ion-label>
                        <ion-input
                            type="password"
                            v-model="password"
                            @input="errorMessage = ''"
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
        errorMessage: '',
    }),
    methods: {
        handleLogin() {
            if (this.username === '' || this.password === '') {
                this.errorMessage = 'Please fill all fields!'
                return
            }
            const account = {
                username: this.username,
                password: this.password,
                accountType: 1,
            }
            axios
                .post('http://171.248.169.71:8080/api/v1/auth', account)
                .then((res) => {
                    this.$store.dispatch('saveToken', res.data.token)
                    this.$router.push('/home')
                })
                .catch(
                    () =>
                        (this.errorMessage =
                            'Username or password is invalid. Please try again!')
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
</style>
