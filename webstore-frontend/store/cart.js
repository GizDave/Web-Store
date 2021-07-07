export const state = () => ({
  list: []
})

export const mutations = {
  add (state, product) {
    state.list.push({
      product
    })
  },
  
  remove (state, { productid }) {
    state.list.splice(state.list.indexOf(productid), 1)
  },

}