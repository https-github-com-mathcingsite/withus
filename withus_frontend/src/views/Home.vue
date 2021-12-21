<template>
  <v-app>
    <slide-bar />
    <search-bar />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import SearchBar from "@/components/layout/SearchBar.vue";
import SlideBar from "@/components/layout/SlideBar.vue";

export default {
  name: "Home",
  components: {
    SearchBar,
    SlideBar,
  },
};
</script>
