<template>
    <ion-page>
        <ion-content>
            <h1 class="header ion-text-center">Change your password</h1>
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
                        <ion-label position="floating">Old password</ion-label>
                        <ion-input
                            type="password"
                            v-model="oldPassword"
                            @input="errorMessage = ''"
                            @keydown.enter="handleChangePassword"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-label position="floating">New password</ion-label>
                        <ion-input
                            type="password"
                            v-model="newPassword1st"
                            @input="errorMessage = ''"
                            @keydown.enter="handleChangePassword"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-label position="floating"
                            >Type new password again</ion-label
                        >
                        <ion-input
                            type="password"
                            v-model="newPassword2nd"
                            @input="errorMessage = ''"
                            @keydown.enter="handleChangePassword"
                        ></ion-input>
                    </ion-item>

                    <p class="invalid-error" v-if="errorMessage !== ''">
                        {{ errorMessage }}
                    </p>
                    <ion-button
                        expand="block"
                        class="login-button"
                        @click="handleChangePassword"
                        >Change password</ion-button
                    >
                    <router-link to="/login" class="router-link"
                        >Back to login</router-link
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
    components: {
        IonPage,
        IonInput,
        IonItem,
        IonLabel,
        IonList,
        IonContent,
        IonButton,
    },
    data: () => ({
        domain: '',
        username: '',
        oldPassword: '',
        newPassword1st: '',
        newPassword2nd: '',
        errorMessage: '',
    }),
    methods: {
        handleChangePassword() {
            if (
                this.domain === '' ||
                this.username === '' ||
                this.oldPassword === '' ||
                this.newPassword1st === '' ||
                this.newPassword2nd === ''
            ) {
                this.errorMessage = 'Please fill all fields!'
                console.log(this.errMessage)
                return
            }
            if (this.newPassword1st !== this.newPassword2nd) {
                this.errorMessage = `Passwords aren't match!`
                return
            }
            const account = {
                username: this.username,
                oldPassword: this.oldPassword,
                newPassword: this.newPassword1st,
                accountType: 1,
            }
            axios
                .put(`${this.domain}/api/v1/auth`, account)
                .then(() => {
                    this.$router.push('/login')
                })
                .catch(
                    () =>
                        (this.errorMessage =
                            'Domain, username or old password is invalid!')
                )
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
