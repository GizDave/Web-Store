export default async (api, params, error) => {
  const currentPage = parseInt(params.page)

  const perPage = 6

  const allProducts = await fetch(api).then(res => res.json())
  
  const paginatedProducts = allProducts.slice((currentPage - 1) * perPage, currentPage * perPage)


  return {
    allProducts,
    paginatedProducts,
  }
}
