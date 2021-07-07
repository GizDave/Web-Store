<template>
    <div class="">
        <CreditCardCard v-for="cc in creditcards" :id=cc.id :key=cc.id :ccnumber="cc.ccnumber"/>
        <CreditCardCard :id=1 :key=1 :ccnumber="12"/>
        <ul id="example-1">
  <li v-for="item in items" :key="item.message">
    {{ item.message }}
  </li>
</ul>
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
            creditcards: [
                {"id":1, "ccnumber": "123"}, 
                {"id":2, "ccnumber": "222"}, 
                {"id":3, "ccnumber": "333"}],
                items: [
      { message: 'Foo' },
      { message: 'Bar' }
    ]
        };
    },
    async created() {
        const config = {
            headers: {
                Accept: "application/json"
            }
        };
        try{
            await axios.get('https://mocki.io/v1/744fd1d3-c5b0-44dc-8968-a6c0e6d97ff22', config);
            // const res = await axios.get(`https://localhost:3306/api/creditcard/${this.$route.params.id}`, config);
            // console.log(res.data);
            // this.creditcards = res.data.results;
            this.creditcards = [
                {"id":1, "ccnumber": "123"}, 
                {"id":2, "ccnumber": "222"}, 
                {"id":3, "ccnumber": "333"}]

        } catch(err){
            // console.log(err);
        };
    }
}
</script>
<style>
</style>