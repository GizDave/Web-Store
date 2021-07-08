<template>
  <div></div>
</template>

<script>
export default {
  middleware({ redirect }) {
    return redirect('301', '/products/page/1')
  }
}
</script>
