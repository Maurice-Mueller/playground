<template>
  <div>
    <p>{{msg}}</p>
    <input type='text' :value='msg' @input="changeMsg">
    <p>{{inputText}}</p>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        inputText: ''
      }
    },
    props: [
      'msg'
    ],
    methods: {
      changeMsg(event) {
        this.inputText = event.target.value;
        this.$emit('messageChanged', this.inputText);
      }
    }
  }
</script>
