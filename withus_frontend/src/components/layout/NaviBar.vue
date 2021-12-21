<template>
  <!-- 
  <v-toolbar flat>
-->
  <v-app-bar class="" app color="white" dense>
    <v-btn to="/" x-large plain>
      <v-img width="120" src="@/assets/Logo.png"></v-img>
    </v-btn>
    <v-app-bar-title class="font-weight-bold" style="overflow: visible"
      >프로젝트 이름</v-app-bar-title
    >
    <v-tabs class="ml-2" color="purple lighten-3">
      <v-tab>팀원 찾기</v-tab>
      <v-tab to="/teams/list">팀원 모집</v-tab>
      <v-tab>알림</v-tab>
    </v-tabs>
    <v-spacer></v-spacer>
    <v-badge bordered dot left color="error">
      <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="grey lighten-1" rounded dark v-bind="attrs" v-on="on">
            <v-icon>mdi-account-circle</v-icon>
          </v-btn>
        </template>
        <v-list>
          <v-list-item v-for="(menu, index) in menues" :key="index">
            <v-list-item-title>{{ menu.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-badge>
  </v-app-bar>
  <!-- 

  </v-app-bar>
  -->
</template>

<script>
export default {
  data() {
    return {
      menues: [
        { title: "내 작성글" },
        { title: "내 관심글" },
        { title: "내 쪽지함" },
        { title: "내 정보 수정" },
      ],
    };
  },
};
</script>

<style></style>
