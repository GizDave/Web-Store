<template>
    <div class="">
        <p>{{ccnumber}}</p>
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
    "ccnumber": {
        type: String,
        default: ""}
    }
}
</script>
<style>
</style>