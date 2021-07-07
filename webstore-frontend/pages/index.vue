<template>
  <div class="relative flex flex-col items-center">
    <NavBar/>
    <div>
      <div class="flex flex-col items-center">
        <h2 class="pt-3">KEYBOARDS</h2>
        <div class="flex flex-wrap justify-center px-0">
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
        </div>
        <button class="flex flex-col px-2 py-3 mt-5 mb-8 font-semibold text-center text-white bg-yellow-400 rounded-lg text-md hover:bg-yellow-300">
            <nuxt-link to="/products/keyboards">View More Products</nuxt-link>
        </button>
      </div>
      <div class="flex flex-col items-center">
        <h2 class="pt-3">KEYCAPS</h2>
      </div>
      <div class="flex flex-col items-center">
        <h2 class="pt-3">DESKMATS</h2>
      </div>
    </div>
  </div>
</template>

<script>
export default {}
</script>
