<template>
  <div>
    <div class="flex flex-col items-center justify-center leading-loose">
        <form class="container px-40 py-8 m-4 bg-white rounded">
            <p class="font-semibold text-gray-800">Customer information</p>
            <div class="">
                <label class="block text-sm text-gray-00" for="cus_name">Name</label>
                <input id="cus_name" class="w-full px-5 py-1 text-gray-700 bg-white border rounded" name="cus_name" type="text" required="" placeholder="Your Name" aria-label="Name">
            </div>
            <div class="mt-2">
                <label class="block text-sm text-gray-600" for="cus_email">Email</label>
                <input id="cus_email" class="w-full px-5 py-4 text-gray-700 bg-white border rounded" name="cus_email" type="text" required="" placeholder="Your Email" aria-label="Email">
            </div>
            <div class="mt-2">
                <label class="block text-sm text-gray-600 " for="cus_email">Address</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-white border rounded" name="cus_email" type="text" required="" placeholder="Street" aria-label="Email">
            </div>
            <div class="mt-2">
                <label class="block text-sm text-gray-600" for="cus_email">City</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-white border rounded" name="cus_email" type="text" required="" placeholder="City" aria-label="Email">
            </div>
            <div class="inline-block w-1/2 pr-1 mt-2">
                <label class="block text-sm text-gray-600" for="cus_email">Country</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-white border rounded" name="cus_email" type="text" required="" placeholder="Country" aria-label="Email">
            </div>
            <div class="inline-block w-1/2 pl-1 mt-2 -mx-1">
                <label class="block text-sm text-gray-600" for="cus_email">Zip</label>
                <input id="cus_email" class="w-full px-2 py-2 text-gray-700 bg-white border rounded"  name="cus_email" type="text" required="" placeholder="Zip" aria-label="Email">
            </div>
             <p class="mt-4 font-semibold text-gray-800">Payment information</p>
            <div class="">
                <label class="block text-sm text-gray-600" for="cus_name">Card</label>
                <input id="cus_name" class="w-full px-2 py-2 text-gray-700 bg-white border rounded" name="cus_name" type="text" required="" placeholder="Card Number MM/YY CVC" aria-label="Name">
            </div>
            <div class="flex justify-center mt-4">
                <button class="mt-5 px-8 max-w-sm transition duration-200 bg-black hover:bg-gray-600 focus:bg-gray-700 focus:shadow-sm focus:ring-4 focus:ring-gray-500 focus:ring-opacity-50 text-white w-full py-2.5 rounded-lg text-sm shadow-sm hover:shadow-md font-bold text-center inline-block" type="submit">Register</button>
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