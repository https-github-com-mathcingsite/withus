<template>
  <v-card outlined>
    <v-row app>
      <v-col cols="9" align-self="center">
        <v-item-group multiple>
          <v-item v-for="(n, idx) in options" :key="idx" v-slot="{ active, toggle }">
            <v-chip class="ml-2" active-class="purple--text" :input-value="active" @click="toggle">{{ n.name }} </v-chip>
          </v-item>
        </v-item-group>
      </v-col>
      <v-col cols="2" align-self="center" align="left">
        <v-text-field placeholder="검색"></v-text-field>
      </v-col>
      <v-col align-self="center"> <v-btn tile color="purple lighten-3" dark> Search </v-btn> </v-col>
    </v-row>
  </v-card>
</template>

<script>
export default {
  data() {
    return {
      options: [{ name: "JAVA" }, { name: "C/C++" }, { name: "Python" }, { name: "Spring" }, { name: "Vue.js" }, { name: "React.js" }, { name: "Swift" }, { name: "Android" }],
    };
  },
};
</script>

<style></style>
