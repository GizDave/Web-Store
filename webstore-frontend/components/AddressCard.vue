<template>
    <div class="">
        <div>{{id}}</div>
        <div>{{street}}</div>
        <div>{{city}}</div>
        <div>{{state}}</div>
        <div>{{zipcode}}</div>
        <div>{{country}}</div>
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