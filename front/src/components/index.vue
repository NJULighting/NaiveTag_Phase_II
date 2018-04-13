<template>
    <router-view></router-view>
</template>

<script>
    export default {
        name: "index",
        created:function () {
            this.$router.push('/login')
        }
    }
</script>

<style scoped>

</style>