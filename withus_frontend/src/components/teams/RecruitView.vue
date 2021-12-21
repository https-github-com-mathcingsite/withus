<template>
  <v-container>
    <v-row>
      <div class="category">
        <span>
          <v-icon>groups</v-icon>
          팀원 모집 > 프로젝트 조회
        </span>
      </div>
    </v-row>
    <v-container>
      <!-- 제목 -->
      <div>
        <h1>Project Name</h1>
        <p class="project-info">regdate:author:</p>
      </div>
      <!-- 내용 :html 태그들로 데려올것-->
      <div class="contents">contents</div>
    </v-container>
    <!-- 태그 -->
    <v-divider class="my-2"></v-divider>
    <v-subheader>Tags</v-subheader>
    <v-item-group multiple>
      <v-item
        v-for="(n, idx) in options"
        :key="idx"
        v-slot="{ active, toggle }"
      >
        <v-chip
          class="ml-2"
          active-class="purple--text"
          :input-value="active"
          @click="toggle"
          >{{ n.name }}
        </v-chip>
      </v-item>
    </v-item-group>
    <v-container>
      <v-row>
        <v-col md="6"></v-col>
        <v-item-group>
          <!-- 닫기 버튼-->
          <v-btn>닫기 </v-btn>
          <!-- 찜 버튼 -->
          <!-- if userinfo.favorite==false:-->
          <v-btn><v-icon>favorite_border</v-icon></v-btn>
          <!-- else: 
          -->
          <v-btn><v-icon>favorite</v-icon></v-btn>
        </v-item-group>
      </v-row>
    </v-container>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      options: [
        { name: "JAVA" },
        { name: "C/C++" },
        { name: "Python" },
        { name: "Spring" },
        { name: "Vue.js" },
        { name: "React.js" },
        { name: "Swift" },
        { name: "Android" },
      ],
    };
  },
};
</script>

<style scoped>
.category {
  margin: 2%;
}
.contents {
  margin-top: 1%;
  background-color: rgb(255, 255, 255);
  height: 500px;
}
p {
  color: rgba(126, 40, 126, 0.74);
}
</style>
