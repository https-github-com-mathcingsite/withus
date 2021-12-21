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
    <v-dialog v-if="!userInfo" v-model="dialog" persistent max-width="600px">
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
                  아이디 로그인</v-btn
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
                  v-model="user.userId"
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="비밀번호"
                  prepend-inner-icon="mdi-lock"
                  class="rounded-0"
                  outlined
                  required
                  v-model="user.userPwd"
                ></v-text-field>
              </v-col>
              <v-btn
                class="rounded-0"
                color="#000000"
                @click="Login"
                x-large
                block
                dark
              >
                로그인</v-btn
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
                  v-model="newUser.userId"
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="비밀번호"
                  prepend-inner-icon="mdi-lock"
                  class="rounded-0"
                  outlined
                  required
                  v-model="newUser.userPwd"
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="이름"
                  prepend-inner-icon="mdi-mail"
                  class="rounded-0"
                  outlined
                  required
                  v-model="newUser.userName"
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="이메일"
                  prepend-inner-icon="mdi-mail"
                  class="rounded-0"
                  outlined
                  required
                  v-model="newUser.email"
                ></v-text-field>
              </v-col>
              <v-btn
                class="rounded-0"
                color="#000000"
                x-large
                block
                dark
                @click="registerUser"
              >
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
    <!-- <v-badge v-if="userInfo" borred dot left color="error"> -->
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <div
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          style="width: 100px"
          class="ml-5"
        >
          로그아웃
        </div>
        <div
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          style="width: 100px"
          class="ml-5"
        >
          {{ userInfo.userId }}
        </div>
        <v-btn color="grey lighten-1" rounded dark v-bind="attrs" v-on="on">
          <v-icon>mdi-account</v-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(menu, index) in menues" :key="index">
          <v-list-item-title
            ><router-link :to="{ name: 'MyPage' }" class="link">{{
              menu.title
            }}</router-link></v-list-item-title
          >
        </v-list-item>
      </v-list>
    </v-menu>
    <!-- </v-badge> -->
  </v-app-bar>
</template>

<script>
import { mapState, mapActions } from "vuex";

const userStore = "userStore";
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
      user: {
        userId: null,
        userPwd: null,
      },
      newUser: {
        userId: null,
        userName: null,
        userPwd: null,
        email: null,
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo", "isRegist"]),
  },
  methods: {
    ...mapActions(userStore, ["userLogin", "getUserInfo", "userRegister"]),
    async Login() {
      await this.userLogin(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        console.log("로그인 완료");
        await this.getUserInfo(token);
        this.$router.push({ name: "Home" }).catch(() => {});
        this.dialog = false;
      }
    },
    async registerUser() {
      await this.userRegister(this.newUser);
      if (this.isRegist) {
        console.log("회원가입 완료");
        this.emailLogin = true;
        this.userSignUp = false;
      } else {
        console.log("회원가입 실패");
      }
    },
  },
};
</script>

<style scoped></style>
