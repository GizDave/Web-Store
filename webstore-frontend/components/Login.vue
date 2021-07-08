<template>
  <div>
      <div class="flex flex-col items-center justify-center">
        <div class="p-10 mx-auto xs:p-0 md:w-full md:max-w-md">
            <div class="w-full bg-white divide-y divide-gray-200 rounded-lg">
                <div class="px-5 py-7">
                    <label class="block pb-1 text-sm font-semibold text-gray-600">Username</label>
                    <input type="text" class="w-full px-3 py-2 mt-1 mb-5 text-sm border rounded-lg" />
                    <label class="block pb-1 text-sm font-semibold text-gray-600">Password</label>
                    <input type="text" class="w-full px-3 py-2 mt-1 mb-5 text-sm border rounded-lg" />
                    <button type="button" class="transition duration-200 bg-black hover:bg-gray-600 focus:bg-gray-700 focus:shadow-sm focus:ring-4 focus:ring-gray-500 focus:ring-opacity-50 text-white w-full py-2.5 rounded-lg text-sm shadow-sm hover:shadow-md font-bold text-center inline-block">
                        <span class="inline-block mr-2">Login</span>
                    </button>
                </div>
                <div class="py-5">
                    <div class="grid grid-cols-2 gap-1">
                    <div class="text-center sm:text-left whitespace-nowrap">
                        <button class="px-5 py-4 mx-5 text-sm font-normal text-gray-500 transition duration-200 rounded-lg cursor-pointer hover:bg-gray-100 focus:outline-none focus:bg-gray-200 focus:ring-2 focus:ring-gray-400 focus:ring-opacity-50 ring-inset">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="inline-block w-4 h-4 align-text-top">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 11V7a4 4 0 118 0m-4 8v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2z" />
                            </svg>
                            <span class="inline-block ml-1">Forgot Password</span>
                        </button>
                    </div>
                    <div class="text-center sm:text-right whitespace-nowrap">
                        <button class="px-5 py-4 mx-5 text-sm font-normal text-gray-500 transition duration-200 rounded-lg cursor-pointer hover:bg-gray-100 focus:outline-none focus:bg-gray-200 focus:ring-2 focus:ring-gray-400 focus:ring-opacity-50 ring-inset">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="inline-block w-4 h-4 align-text-bottom ">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M18.364 5.636l-3.536 3.536m0 5.656l3.536 3.536M9.172 9.172L5.636 5.636m3.536 9.192l-3.536 3.536M21 12a9 9 0 11-18 0 9 9 0 0118 0zm-5 0a4 4 0 11-8 0 4 4 0 018 0z" />
                            </svg>
                            <span class="inline-block ml-1">Help</span>
                        </button>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>