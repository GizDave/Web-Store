<template>
  <div>
    <NavBar/>
    <div class="flex flex-col items-center justify-center leading-loose">
        <form class="container px-40 py-8 m-4 bg-white rounded">
            <p class="font-medium text-gray-800">Customer information</p>
            <div class="">
                <label class="block text-sm text-gray-00" for="cus_name">Name</label>
                <input id="cus_name" class="w-full px-5 py-1 text-gray-700 bg-gray-200 rounded" name="cus_name" type="text" required="" placeholder="Your Name" aria-label="Name">
            </div>
            <div class="mt-2">
                <label class="block text-sm text-gray-600" for="cus_email">Email</label>
                <input id="cus_email" class="w-full px-5 py-4 text-gray-700 bg-gray-200 rounded" name="cus_email" type="text" required="" placeholder="Your Email" aria-label="Email">
            </div>
            <div class="mt-2">
                <label class="block text-sm text-gray-600 " for="cus_email">Address</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-gray-200 rounded" name="cus_email" type="text" required="" placeholder="Street" aria-label="Email">
            </div>
            <div class="mt-2">
                <label class="block text-sm text-gray-600" for="cus_email">City</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-gray-200 rounded" name="cus_email" type="text" required="" placeholder="City" aria-label="Email">
            </div>
            <div class="inline-block w-1/2 pr-1 mt-2">
                <label class="block text-sm text-gray-600" for="cus_email">Country</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-gray-200 rounded" name="cus_email" type="text" required="" placeholder="Country" aria-label="Email">
            </div>
            <div class="inline-block w-1/2 pl-1 mt-2 -mx-1">
                <label class="block text-sm text-gray-600" for="cus_email">Zip</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-gray-200 rounded"  name="cus_email" type="text" required="" placeholder="Zip" aria-label="Email">
            </div>
             <p class="mt-4 font-medium text-gray-800">Payment information</p>
            <div class="">
                <label class="block text-sm text-gray-600" for="cus_name">Card</label>
                <input id="cus_name" class="w-full px-2 py-2 text-gray-700 bg-gray-200 rounded" name="cus_name" type="text" required="" placeholder="Card Number MM/YY CVC" aria-label="Name">
            </div>
            <div class="mt-4">
                <button class="px-4 py-1 font-light tracking-wider text-white bg-gray-900 rounded" type="submit">$3.00</button>
            </div>
        </form>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>