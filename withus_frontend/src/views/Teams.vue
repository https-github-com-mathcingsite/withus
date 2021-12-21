<template>
  <v-app>
    <navi-bar />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import NaviBar from "@/components/layout/NaviBar.vue";

export default {
  name: "Home",
  components: {
    NaviBar,
  },
};
</script>
