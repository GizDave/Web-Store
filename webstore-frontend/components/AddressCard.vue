<template>
<<<<<<< HEAD
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
=======
    <div class="">
        <div>{{id}}</div>
        <div>{{street}}</div>
        <div>{{city}}</div>
        <div>{{state}}</div>
        <div>{{zipcode}}</div>
        <div>{{country}}</div>
    </div>
>>>>>>> c9a012e20b0d51b1a0d934cfde080667e0bdfad1
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