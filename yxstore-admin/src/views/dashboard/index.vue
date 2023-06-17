<template>
  <div class="dashboard-container">
    <div class="dashboard-text">Welcome: {{ name }}</div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    width: 300px;
    margin: 100px auto;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
