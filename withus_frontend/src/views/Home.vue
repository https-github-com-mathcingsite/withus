<template>
  <v-app>
    <navi-bar />
    <slide-bar />
    <search-bar />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import NaviBar from "@/components/layout/NaviBar.vue";
import SearchBar from "@/components/layout/SearchBar.vue";
import SlideBar from "@/components/layout/SlideBar.vue";

export default {
  name: "Home",
  components: {
    NaviBar,
    SearchBar,
    SlideBar,
  },
};
</script>
