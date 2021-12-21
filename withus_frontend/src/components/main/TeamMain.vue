<template>
  <!--메인 페이지 : 리스트 - 작성 검색 -->
  <!-- 이미 바깥에 main으로 감싸져 있음-->
  <v-container>
    <v-list-item-title>
      <h1>팀원 모집</h1>
    </v-list-item-title>
    <v-container>
      <v-row>
        <v-spacer> </v-spacer>
        <v-btn
          tile
          color="purple lighten-3"
          elevation="2"
          dark
          style="margin-right: 1%"
          to="/teams/post"
        >
          프로젝트 등록
        </v-btn>
      </v-row>
    </v-container>
    <v-container>
      <team-search></team-search>
    </v-container>
  </v-container>
</template>

<script>
import TeamSearch from "@/components/main/TeamSearch.vue";

export default {
  components: {
    TeamSearch,
  },
};
</script>

<style></style>
