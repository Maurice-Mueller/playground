<template>
  <div id="app">
    <app-message></app-message>
    <app-input></app-input>
  </div>
</template>

<script>
  import Input from './Input.vue'
  export default {
    components: {
      'app-input': Input
    }
  }
</script>

<style>
</style>
