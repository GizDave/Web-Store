<template>
    <div class="">
        <CreditCardCard v-for="cc in creditcards" :id="cc.id" :key="cc.id" :ccnumber="cc.ccnumber"/>
        <!-- <CreditCardCard :id=1 :key=1 :ccnumber="12"/> -->
    </div>
</template>
<script>
import axios from "axios";    
import CreditCardCard from '../../components/CreditCardCard';
export default {
    components:{
        CreditCardCard
    },
    data() {
        return {
            creditcards: [],
        };
    },
    async created() {
        const config = {
            headers: {
                Accept: "application/json"
            }
        };
        try{
            this.creditcards = await axios.get('https://mocki.io/v1/a7a503b2-d849-44ab-b39b-c0e98c57b28a', config).then(response=>response.data)
            // .then(jsondata=>console.log(jsondata))
            // const res = await axios.get(`https://localhost:3306/api/creditcard/${this.$route.params.id}`, config);
            // console.log(res.data);
            // this.creditcards = res.data.results;
            // this.creditcards = [
            //     {"id":1, "ccnumber": "123"}, 
            //     {"id":2, "ccnumber": "222"}, 
            //     {"id":3, "ccnumber": "333"}]

        } catch(err){
            console.log(err);
        };
    }
}
</script>
<style>
</style>