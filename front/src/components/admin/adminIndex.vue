<template>
   <div>
       <div>
           <admin-navi></admin-navi>
       </div>
       <div style="width: 100%">
           <router-view></router-view>
       </div>
   </div>
</template>

<script>
    import AdminNavi from "~/components/admin/adminNavi";
    export default {
        name: "adminIndex",
        components: {AdminNavi}
    }
</script>

<style scoped>

</style>