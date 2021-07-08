<template>
  <div>
    <NavBar />
    <div class="flex flex-wrap items-center justify-center px-10 md:px-70">
      <div v-for="product in paginatedProducts" :key="product.productid" class="">
        <div>
          <ProductCard :product="product" />
        </div>
      </div>
      <Pagination :total="allProducts.length"/>
    </div>
  </div>
</template>


<script>
import getProducts from '@/utils/getProducts'
export default {
  async asyncData( {params} ) {
    const api = 'http://localhost:8080/productlist/products/get/category/' + params.category
    const list = await getProducts(api, params)
    return {  
      allProducts: list.allProducts,
      paginatedProducts: list.paginatedProducts
    }
  },
}
</script>

<style>

</style>