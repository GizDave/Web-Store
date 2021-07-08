<template>
  <div class="justify-items-center">
    <NavBar/>
    <div class="z-0 grid grid-cols-2">
        <div class="grid w-full h-auto grid-cols-1 gap-4 pt-4 pb-10 pr-2 justify-items-end md:pr-6">
            <div class="w-full max-w-sm">
                <div class="relative overflow-hidden aspect-w-4 aspect-h-3">
                    <img class="absolute inset-0 object-cover w-full h-full rounded-md" :src="product.thumbnail" alt="">
                </div>  
            </div>
            <div v-for="image in product.images" :key="image.imageid" class="w-full max-w-sm">
                <div class="relative overflow-hidden aspect-w-4 aspect-h-3">
                    <img class="absolute inset-0 object-cover w-full h-full rounded-md" :src="image.image_path" alt="">
                </div>  
            </div>
        </div>
        
        <div class="flex flex-col md:pl-6">
            <h2 class="">{{ product.name }}</h2>
            <h4 class="mt-3 text-lg font-bold text-yellow-400">${{ product.price }}</h4>
            <div>
              <div v-if="isInCart()">
                <button class="max-w-md px-4 py-2 my-4 text-lg font-bold text-white bg-red-400 rounded-lg hover:bg-red-300" @click="removeFromCart(product)">Remove from Cart</button>
              </div>
              <div v-else class="flex flex-row max-w-sm">
                <button class="flex flex-shrink-0 px-4 py-2 my-4 text-lg font-bold text-white bg-yellow-400 rounded-lg hover:bg-yellow-300" @click="addToCart(product, quantity)">Add to Cart</button>
                <input id="quantity" v-model="quantity" class="mx-2 my-4 font-semibold text-center text-gray-700 bg-gray-200 rounded-lg outline-none max-h-12 focus:outline-none hover:text-black focus:text-black" type="number">
              </div>
            </div>
            <p class="max-w-md pt-3 pl-3">{{ product.description }}</p>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "Store",
    props: {
        productid:    {
            type: String,
            required: true,
        },
    },
  data() {
    return {
        cart: [],
        product: [],
        quantity: 1,
    };
  },
  async fetch() {   
      this.product = await fetch('http://localhost:8080/productlist/products/get/' + this.productid).then(res => res.json())
  },
  methods: {
    isInCart() {
      return false
    },
    addToCart(product, quantity) {
      const payload = {product, quantity}
      this.$store.commit('cart/add', payload)
      console.log(quantity)
    },
    removeFromCart(product) {
      this.$store.commit('cart/remove', product)
    },
  },
}
</script>

<style>

</style>