<template>
  <v-container>
    <!--제목 -->
    <v-row>
      <div class="category">
        <span>
          <v-icon>groups</v-icon>
          팀원 모집 > 프로젝트 등록
        </span>
      </div>
    </v-row>
    <v-form>
      <v-text-field
        class="subject"
        label="제목을 입력하세요"
        flat
        v-model="teaminfo.subject"
        value=""
        solo
      ></v-text-field>
      <!-- 내용-->
      <tiptap-vuetify v-model="content" :extensions="extensions" />
      <!-- chips-->
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
    </v-form>
    <v-container>
      <v-row>
        <v-col col="8"></v-col>
        <v-col>
          <v-btn @click="onSubmit" style="float: left; margin-right: 10px"
            >등록</v-btn
          >

          <v-btn @click="onReset" style="float: left">취소</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-container>
</template>

<script>
// import the component and the necessary extensions
import { postTeamInfo } from "@/api/team";

import {
  TiptapVuetify,
  Heading,
  Bold,
  Italic,
  Strike,
  Underline,
  Code,
  Paragraph,
  BulletList,
  OrderedList,
  ListItem,
  Link,
  Blockquote,
  HardBreak,
  HorizontalRule,
  History,
} from "tiptap-vuetify";

export default {
  // specify TiptapVuetify component in "components"
  components: { TiptapVuetify },
  data: () => ({
    // tiptap : declare extensions you want to use
    extensions: [
      History,
      Blockquote,
      Link,
      Underline,
      Strike,
      Italic,
      ListItem,
      BulletList,
      OrderedList,
      [
        Heading,
        {
          options: {
            levels: [1, 2, 3],
          },
        },
      ],
      Bold,
      Code,
      HorizontalRule,
      Paragraph,
      HardBreak,
    ],
    // starting editor's content
    //content: `
    // <h1>프로젝트 소개</h1>
    // <p>설명설명 <strong>tags</strong> .</p>
    //  `,
    content: "",
    //기술스택 옵션
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
    //teaminfo dto로 넘길 데이터
    teaminfo: {
      teamno: 0,
      userid: "test1",
      subject: "",
      content: "",
      C: 0,
      JAVA: 0,
      Python: 0,
      Spring: 0,
      Vue: 0,
      React: 0,
      swift: 1,
      android: 0,
    },
  }),
  methods: {
    //등록 버튼
    onSubmit(event) {
      event.preventDefault();
      let err = true;
      let msg = "";
      // 제목 missing 시 에러 메시지
      !this.teaminfo.subject && ((msg = "제목 입력해주세요"), (err = false));
      this.teaminfo.content = this.content;
      if (!err) alert(msg);
      else this.postTeam(); //에러 없을 경우 postTeam 메서드
    },
    onReset() {
      this.$router.push({ name: "Home" });
    },
    postTeam() {
      postTeamInfo(
        {
          userid: this.userid,
          subject: this.teaminfo.subject,
          content: this.teaminfo.content, //나중에 options도 추가하기
          /*     C: this.teaminfo.C,
          Java: this.teaminfo.Java,
          Python: this.teaminfo.Python,
          Spring: this.teaminfo.Spring,
          Vue: this.teaminfo.Vue,
          React: this.teaminfo.React,
          swfit: this.teaminfo.swift,
          android: this.teaminfo.android,*/
        },
        console.log(this.teaminfo.userid),
        console.log(this.teaminfo.subject),
        console.log(this.teaminfo.content),
        ({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.push({ name: "Team" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>
<style scoped>
.tiptap-vuetify-editor >>> .ProseMirror {
  height: 500px;
}
.v-text-field >>> input {
  font-size: 32px;
  font-weight: bold;
  line-height: 38px;
  min-height: 100%;
  padding-top: 0.8%;
}
.v-text-field >>> label {
  font-size: 32px;
  font-weight: bold;
  line-height: 38px;
  height: 100%;
}
.category {
  margin: 2%;
}
</style>
