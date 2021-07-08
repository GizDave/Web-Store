<template>
  <div class="relative flex flex-col items-center">
    <NavBar/>
    <div>
      <div class="flex flex-col items-center">
        <h2 class="pt-3">KEYBOARDS</h2>
        <div class="flex flex-wrap justify-center px-0">
          <div v-for="product in keyboards.slice(0,3)" :key="product.productid">
            <ProductCard :product="product"/>
          </div>
        </div>
        <button class="flex flex-col px-2 py-3 mt-5 mb-8 font-semibold text-center text-white bg-yellow-400 rounded-lg text-md hover:bg-yellow-300">
            <nuxt-link to="/category/1/page/1">View More Products</nuxt-link>
        </button>
      </div>
      <div class="flex flex-col items-center">
        <h2 class="pt-3">KEYCAPS</h2>
        <div class="flex flex-wrap justify-center px-0">
          <div v-for="product in keycaps.slice(0,3)" :key="product.productid">
            <ProductCard :product="product"/>
          </div>
        </div>
        <button class="flex flex-col px-2 py-3 mt-5 mb-8 font-semibold text-center text-white bg-yellow-400 rounded-lg text-md hover:bg-yellow-300">
            <nuxt-link to="/category/2/page/1">View More Products</nuxt-link>
        </button>
      </div>
      <div class="flex flex-col items-center">
        <h2 class="pt-3">DESKMATS</h2>
        <div class="flex flex-wrap justify-center px-0">
          <div v-for="product in deskmats.slice(0,3)" :key="product.productid">
            <ProductCard :product="product"/>
          </div>
        </div>
        <button class="flex flex-col px-2 py-3 mt-5 mb-8 font-semibold text-center text-white bg-yellow-400 rounded-lg text-md hover:bg-yellow-300">
            <nuxt-link to="/category/3/page/1">View More Products</nuxt-link>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {  
      keyboards: [],
      keycaps: [],
      deskmats: []
    }
  },
  async fetch() { 
    this.keyboards = await fetch('http://localhost:8080/productlist/products/get/category/1').then(res => res.json())
    this.keycaps = await fetch('http://localhost:8080/productlist/products/get/category/2').then(res => res.json())
    this.deskmats = await fetch('http://localhost:8080/productlist/products/get/category/3').then(res => res.json())
  }
}
</script>
