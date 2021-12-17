<template>
  <v-app-bar class="" app color="white">
    <v-img width="120" src="@/assets/Logo.png"></v-img>
    <v-app-bar-title class="font-weight-bold" style="overflow: visible"
      >프로젝트 이름</v-app-bar-title
    >
    <v-tabs class="ml-2" color="purple lighten-3">
      <v-tab>팀원 찾기</v-tab>
      <v-tab>팀원 모집</v-tab>
      <v-tab>알림</v-tab>
    </v-tabs>
    <v-spacer></v-spacer>
    <!-- 로그인을 하지 않았을 때 !-->
    <v-dialog v-model="dialog" persistent max-width="600px">
      <template v-slot:activator="{ on, attrs }">
        <div color="primary" dark v-bind="attrs" v-on="on" style="width: 200px">
          로그인 / 회원가입
        </div>
      </template>
      <v-card>
        <v-card-title>
          <span class="text-h5">로그인</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12" sm="6" md="4"> </v-col>
              <v-col cols="12" sm="6" md="4"
                ><v-img width="120" src="@/assets/Logo.png"></v-img>
              </v-col>
            </v-row>
            <v-row v-if="!emailLogin">
              <v-col cols="12" sm="6" md="4"> </v-col>
              <v-col cols="12">
                <v-btn
                  class="rounded-0"
                  color="#000000"
                  x-large
                  block
                  dark
                  @click="emailLogin = true"
                >
                  이메일 로그인</v-btn
                >
              </v-col>
              <v-col cols="12">
                <v-btn class="rounded-0" color="#000000" x-large block dark>
                  카카오톡 로그인</v-btn
                >
              </v-col>
            </v-row>
            <v-row v-if="emailLogin && !userSignUp">
              <v-col cols="12">
                <v-text-field
                  label="아이디"
                  prepend-inner-icon="mdi-mail"
                  class="rounded-0"
                  outlined
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="비밀번호"
                  prepend-inner-icon="mdi-lock"
                  class="rounded-0"
                  outlined
                  required
                ></v-text-field>
              </v-col>
              <v-btn class="rounded-0" color="#000000" x-large block dark>
                Login</v-btn
              >
            </v-row>
            <v-row v-if="userSignUp">
              <v-col cols="12">
                <v-text-field
                  label="아이디"
                  prepend-inner-icon="mdi-mail"
                  class="rounded-0"
                  outlined
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="비밀번호"
                  prepend-inner-icon="mdi-lock"
                  class="rounded-0"
                  outlined
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="이름"
                  prepend-inner-icon="mdi-mail"
                  class="rounded-0"
                  outlined
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="이메일"
                  prepend-inner-icon="mdi-mail"
                  class="rounded-0"
                  outlined
                  required
                ></v-text-field>
              </v-col>
              <v-btn class="rounded-0" color="#000000" x-large block dark>
                회원가입</v-btn
              >
            </v-row>
            <v-card-actions
              v-if="emailLogin && !userSignUp"
              class="text--secondary"
            >
              <v-checkbox color="#000000" label="아이디 저장"></v-checkbox>
              <v-spacer></v-spacer>
              회원이 아니신가요?
              <a href="#" @click="userSignUp = true"> 회원가입</a>
            </v-card-actions>
          </v-container>
        </v-card-text>
      </v-card>
    </v-dialog>
    <!-- 로그인을 했을때 !-->
    <v-badge v-if="user" borred dot left color="error">
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
      dialog: false,
      emailLogin: false,
      userSignUp: false,
    };
  },
};
</script>

<style scoped></style>
