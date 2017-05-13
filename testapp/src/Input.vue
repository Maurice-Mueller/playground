<template>
  <div>
    <input type='text' v-model='inputText'>
    <p>{{inputText}}</p>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        inputText: ''
      }
    }
  }
</script>
