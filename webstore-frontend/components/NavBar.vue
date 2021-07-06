<template>
  <header class="flex flex-col justify-center h-20 min-w-full mb-6">
    <div class="flex items-center min-w-full md:text-lg">
      <nav class="justify-between mx-auto md:text md:text-xl">
        <ul class="flex justify-between min-w-full">
         <li class="flex-auto px-5 font-semibold lowercase md:px-10">
            <a href="/">home</a>
         </li>
          <li class="flex-auto px-5 font-semibold lowercase md:px-10">
              <div class="relative group">
                 <a href="/products">products</a> 
                 <div class="absolute hidden group-hover:block">
                     <ul class="top-0 block px-3 pb-1 bg-white rounded-lg bg-opacity-95">
                         <li class="opacity-50 hover:opacity-100">
                             <a href="/products/keyboards">keyboards</a>

                         </li>
                         <li class="opacity-50 hover:opacity-100">
                             <a href="/products/keycaps">keycaps</a>
                         </li>
                         <li class="opacity-50 hover:opacity-100">
                             <a href="/products/deskmats">deskmats</a>
                         </li>
                     </ul>
                 </div>

              </div>
          </li>
          <li class="flex-auto px-5 font-semibold lowercase md:px-10">
            <a href="/cart">cart</a>
          </li>
          <li class="flex-auto px-5 font-semibold lowercase md:px-10">
            <a href="/account">account</a>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>

<script>
export default {}
</script>

<style>
/* Sample `apply` at-rules with Tailwind CSS
.container {
@apply min-h-screen flex justify-center items-center text-center mx-auto;
}
*/
</style>
