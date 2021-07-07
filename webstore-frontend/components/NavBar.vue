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
                 <nuxt-link to="/products" class="inline-flex">
                  <span>products</span>
                  <span class="pt-1">
                    <svg xmlns="http://www.w3.org/2000/svg" class="w-5 h-5" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="nonzero" d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z" clip-rule="evenodd" />
                    </svg>
                  </span>
                 </nuxt-link> 
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
            <nuxt-link to="/cart">cart ({{ total }})</nuxt-link>
          </li>
          <li class="flex-auto px-5 font-semibold lowercase md:px-10">
            <nuxt-link to="/account">account</nuxt-link>
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
