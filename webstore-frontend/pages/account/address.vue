<template>
    <div class="">
        <AddressCard v-for="address in addresses" :id="address.id" :key="address.id" :street="address.street" :city="address.city" :state="address.state" :zipcode="address.zipcode" :country="address.country"/>
        <!--         
        <div>{id}</div>
        <div>{street}</div>
        <div>{city}</div>
        <div>{state}</div>
        <div>{zipcode}</div>
        <div>{country}</div>
         -->
    </div>
</template>
<script>
import axios from "axios";    
import AddressCard from '../../components/AddressCard';
export default {
    components:{
        AddressCard
    },
    data() {
        return {
            addresses: [],
        };
    },
    async created() {
        const config = {
            headers: {
                Accept: "application/json"
            }
        };
        try{
            this.addresses = await axios.get('https://mocki.io/v1/e186667d-a603-4cc4-b80b-6c2699e91ebf', config).then(response=>response.data)
            // .then(jsondata=>console.log(jsondata))
            // const res = await axios.get(`https://localhost:3306/api/creditcard/${this.$route.params.id}`, config);
            // console.log(res.data);
            // this.creditcards = res.data.results;
            // this.creditcards = [
            //     {"id":1, "street": "street1","city": "city1","state": "state1","zipcode": "zipcode1","country": "country1"}, 
            //     {"id":2, "street": "madison","city": "city1","state": "state1","zipcode": "zipcode1","country": "country1"}, 
            //     {"id":3, "street": "greene","city": "city1","state": "state1","zipcode": "zipcode1","country": "country1"}]

        } catch(err){
            console.log(err);
        };
    }
}
</script>
<style>
</style>