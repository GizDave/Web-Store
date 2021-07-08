<template>
  <div class="container flex justify-between mt-8">
    <nuxt-link
      :to="{ params: { page: prevPage } }"
      class="flex items-center text-xl font-semibold"
      :class="{
        'btn-enabled': currentPage > 1,
        'btn-disabled': currentPage <= 1
      }"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
        class="w-6 mr-2"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="3"
          d="M11 19l-7-7 7-7m8 14l-7-7 7-7"
        />
      </svg>

      Previous
    </nuxt-link>

    <div class="py-2 items center">
      <span class="mx-1 text-xl font-semibold">
        {{ currentPage }} of {{ totalPages }}</span
      >
    </div>

    <nuxt-link
      :to="{ params: { page: nextPage } }"
      class="flex items-center text-xl font-semibold"
      :class="{
        'btn-enabled': currentPage < totalPages,
        'btn-disabled': currentPage >= totalPages
      }"
    >
      Next
      <div class="items-end">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          class="w-6 ml-2 font"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="3"
            d="M13 5l7 7-7 7M5 5l7 7-7 7"
          />
        </svg>
      </div>
    </nuxt-link>
  </div>
</template>

<script>
export default {
  props: {
    total: {
      type: Number,
      default: 0
    },
    perPage: {
      type: Number,
      default: 6
    }
  },
  computed: {
    totalPages() {
      return Math.ceil(this.total / this.perPage)
    },
    currentPage() {
      return parseInt(this.$route.params.page) || 1
    },
    prevPage() {
      return this.currentPage > 1 ? this.currentPage - 1 : 1
    },
    nextPage() {
      return this.currentPage < this.totalPages
        ? this.currentPage + 1
        : this.totalPages
    }
  }
}
</script>

<style>
/* Sample `apply` at-rules with Tailwind CSS
.container {
@apply min-h-screen flex justify-center items-center text-center mx-auto;
}
*/
</style>
