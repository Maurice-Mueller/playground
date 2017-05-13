<template>
  <div id="app">
    <app-message></app-message>
    <hr>
      <router-link to="/home">HOME</router-link>
      <router-link to="/users/100">USERS 100</router-link>
      <router-link to="/users/200">USERS 200</router-link>
    <hr>
    <router-view></router-view>
  </div>
</template>

