<template>
  <div class="relative flex flex-col items-center">
    <h1 class="flex-auto pt-4">KEYBOARD STORE</h1>
    <NavBar/>
    <div>
      <div class="flex flex-col items-center">
        <h2 class="pt-3">KEYBOARDS</h2>
        <div class="flex flex-wrap justify-center px-0">
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
        </div>
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
