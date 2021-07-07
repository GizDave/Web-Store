<template>
<div class="relative flex flex-col items-center">
  <h1 class="flex-auto pt-4">KEYBOARD STORE</h1>
  <header class="flex flex-col justify-center h-20 min-w-full mb-6">
    <div class="flex items-center min-w-full md:text-lg">
      <nav class="justify-between mx-auto md:text md:text-xl">
        <ul class="flex justify-between min-w-full">
         <li class="flex-auto px-5 font-semibold lowercase md:px-10">
            <nuxt-link to="/">home</nuxt-link>
         </li>
          <li class="flex-auto px-5 font-semibold lowercase md:px-10">
              <div class="relative group">
                 <nuxt-link to="/products">products</nuxt-link> 
                 <div class="absolute hidden group-hover:block">
                     <ul class="top-0 block px-3 pb-1 bg-white rounded-lg bg-opacity-95">
                         <li class="opacity-50 hover:opacity-100">
                             <nuxt-link to="/products/keyboards">keyboards</nuxt-link>

                         </li>
                         <li class="opacity-50 hover:opacity-100">
                             <nuxt-link to="/products/keycaps">keycaps</nuxt-link>
                         </li>
                         <li class="opacity-50 hover:opacity-100">
                             <nuxt-link to="/products/deskmats">deskmats</nuxt-link>
                         </li>
                     </ul>
                 </div>

              </div>
          </li>
          <li class="flex-auto px-5 font-semibold lowercase md:px-10">
            <nuxt-link to="/cart">cart</nuxt-link>
          </li>
          <li class="flex-auto px-5 font-semibold lowercase md:px-10">
            <nuxt-link to="/account_options">account</nuxt-link>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</div>
</template>

<script>
export default {
  data() {
    return {  
      total: this.$store.state.cart.list.length
    }
  },
}
</script>

<style>
/* Sample `apply` at-rules with Tailwind CSS
.container {
@apply min-h-screen flex justify-center items-center text-center mx-auto;
}
*/
</style>
