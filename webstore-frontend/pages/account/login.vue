<template>
<div>
  <form @submit.prevent="submit">
    <h1 class="">Login</h1>

    <input v-model="name" class="form-control" placeholder="Username" required>
    <br/>
    <input v-model="password" type="password" class="form-control" placeholder="Password" required>
    <br/>
    <button class="" type="submit">Submit</button>
  </form>
  </div>
</template>

<script>
export default {
//   name: "register",
    path:"./account/login",
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    async submit() {
      await fetch('https://mocki.io/v1/744fd1d3-c5b0-44dc-8968-a6c0e6d97ff22', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        credentials: 'include',
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

