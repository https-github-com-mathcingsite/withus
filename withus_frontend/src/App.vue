<template>
  <v-app>
    <navi-bar />
    <router-view />
  </v-app>
</template>

<script>
import NaviBar from "@/components/layout/NaviBar.vue";
export default {
  name: "App",
  components: {
    NaviBar,
  },
  data: () => ({
    //
  }),
};
</script>
