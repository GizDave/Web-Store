<template>
<div class="space-y-3 max-w-md mx-auto bg-white rounded-xl shadow-md overflow-hidden md:max-w-xs">
    <h4>Address {{id}}</h4>
  <div class="md:flex">
    <div class="p-8">
      <!-- <div class="uppercase tracking-wide text-sm text-indigo-500 font-semibold">Case study</div> -->
      <a href="#" class="block mt-1 text-lg leading-tight font-medium text-black hover:underline">{{street}}</a>
      <p class="mt-2 text-gray-500">{{city}}, {{state}} {{zipcode}} {{country}}
          <br/>
          Edit | Remove 
      </p>
    </div>
  </div>
</div>
</template>
<script>
export default {
    name: "CreditCardNumber",
    props:
    {"id": {
        type: Number,
        default: 0
    },
    "street": {
        type: String,
        default: ""
    },
    "city": {
        type: String,
        default: ""
    },
    "state": {
        type: String,
        default: ""
    },
    "zipcode": {
        type: String,
        default: ""
    },
    "country": {
        type: String,
        default: ""}
    }
}
</script>
<style>
</style>