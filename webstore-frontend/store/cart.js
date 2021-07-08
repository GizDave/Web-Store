export const state = () => ({
  list: []
})

export const mutations = {
  add(state, payload) {
    state.list.push({
      product: payload.product,
      quantity: payload.quantity,
      id: payload.product.productid,
      total: payload.quantity * payload.product.price
    })
  },
  
  remove (state, product) {
    const i = state.list.map(item => item.id).indexOf(product.id);
    state.list.splice(i, 1);
  },

}