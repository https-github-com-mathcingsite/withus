<template>
  <v-card app>
    <v-carousel cycle height="300" hide-delimiters show-arrows-on-hover>
      <v-carousel-item v-for="(picture, i) in pictures" :key="i" :src="require(`@/assets/${picture.name}`)"> </v-carousel-item>
    </v-carousel>
  </v-card>
</template>

<script>
export default {
  data() {
    return {
      pictures: [{ name: "Slide_1.jpg" }, { name: "Slide_2.jpg" }, { name: "Slide_3.jpg" }],
    };
  },
};
</script>

<style></style>
