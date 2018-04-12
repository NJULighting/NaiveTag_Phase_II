<template>
  <div id="app">
    <div>
      <a router-link="{ path: '/home'}">Home</a>
      <a router-link="{ path: '/about'}">About</a>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>

    export default {

    }
</script>

<style>

</style>
