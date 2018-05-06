<template>
    <router-view>
    </router-view>
</template>

<script>

    import Login from "~/components/login";

    export default {
        components: {Login},
        created: function () {
            console.log(new Date().toLocaleString() + ' created');
            // localStorage.created = true;
            // this.$router.push('/login');
        }
    }
</script>

<style>

</style>
