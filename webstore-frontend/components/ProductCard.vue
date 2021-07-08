<template>
<body class="font-sans antialiased">
  <div class="container items-center justify-center mx-auto">
    <div class="flex flex-wrap w-full max-w-sm group">
      <div class="w-full p-4">
        <nuxt-link :to="'/products/product/' + product.productid" class="block overflow-hidden bg-white rounded-lg shadow-md">
          <div class="relative overflow-hidden aspect-h-2 aspect-w-3">
            <img class="absolute inset-0 object-cover w-full h-full group-hover:scale-110" :src="product.thumbnail" :alt="product.name">
          </div>
          <div>
            <div v-if="product.instock">
              <p class="p-0 text-lg font-bold text-center text-white bg-yellow-400">In Stock</p>
            </div>
            <div v-else>
              <p class="p-0 text-lg font-bold text-center text-white bg-gray-400">Out of Stock</p>
            </div>
          </div>
          <div class="p-4 pt-0">
            <div class="flex justify-between my-2">
              <span class="text-xl font-bold">{{ product.name }}</span>
              <span class="text-lg font-bold text-yellow-400">${{ product.price }}</span>
            </div>
            <p class="line-clamp-3">{{ product.description }}</p>
          </div>
        </nuxt-link>
      </div>
    </div>
  </div>
</body>

</template>

<script>
export default {
  props: {  
    product: {
      type: Object,
      required: true,
    }
  }

}
</script>

<style>

</style>