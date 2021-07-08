<template>
  <div>
      <Product :productid="productId" />
  </div>
</template>

<script>

export default {
  asyncData( {params} ) {  
    return {  
      productId: params.product,
    }
  },
}
</script>

<style>

</style>