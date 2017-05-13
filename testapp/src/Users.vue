<template>
  <div>
    <h1>This is the users page.</h1>
    <h3>Team ID is {{$route.params.teamId}}</h3>
  </div>
</template>

<script>
  export default {
    watch: {
      '$route' (to, from) {
        console.log('route changed inside users');
        alert(to.params.teamId);
      }
    },
    created() {
        console.log('users got created');
        alert(this.$route.params.teamId);
    }
  }
</script>
