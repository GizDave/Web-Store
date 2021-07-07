<template>
<form @submit.prevent="submit">
    <h1 class="">Registration</h1>
    <input v-model="name" class="form-control" placeholder="Username" required>
    <br/>
    <input v-model="password" type="password" class="form-control" placeholder="Password" required>
    <br/>
    <button class="" type="submit">Submit</button>
</form>
</template>

<script>
export default {
    // name: "register",
    path:"account/register",
    data() {
        return {
            username: '',
            password: ''
        }
    },
    methods: {
        async submit() {
            await fetch('http://localhost:3306/api/register', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({
                    username: this.username,
                    password: this.password
                })
            });
            await this.$router.push('/login');
        }
    }
}
</script>

