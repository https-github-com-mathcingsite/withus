import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Teams from "../views/Teams.vue";
import TeamSearch from "@/components/main/TeamMain.vue";
import RecruitPost from "@/components/teams/RecruitPost.vue";

import User from "@/views/User.vue";
import UserMyPage from "@/components/user/UserMyPage.vue";
import UserUpdate from "@/components/user/UserUpdate.vue";

Vue.use(VueRouter);

import store from "@/store/index.js";

const loginCheck = async (to, from, next) => {
  const checkUserInfo = store.getters["userStore/checkUserInfo"];
  const getUserInfo = store._actions["userStore/getUserInfo"];
  let token = sessionStorage.getItem("access-token");
  if (checkUserInfo == null && token) {
    await getUserInfo(token);
  }
  if (checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다.");
  } else {
    console.log("로그인");
    next();
  }
};
const routes = [
  {
    path: "/",
    name: "Home", //team list 화면
    component: Home, //팀원 찾기와 팀원 모집
    children: [
      //redirect로 하려면 searchbar와 배너때문에 children으로 줌
      {
        path: "/teams/list",
        name: "TeamSearch",
        component: TeamSearch,
      },
    ],
  },
  {
    path: "/teams",
    name: "Teams",
    component: Teams,
    children: [
      {
        path: "/teams/post",
        name: "TeamPost",
        component: RecruitPost,

        /*  path: "/teams/post",
        name: "TeamPost",
        component: RecruitView,*/
      },
    ],
  },
  {
    path: "/user",
    name: "User",
    component: User,
    children: [
      {
        path: "usermypage",
        name: "UserMyPage",
        beforeEnter: loginCheck,
        component: UserMyPage,
      },
      {
        path: "userupdate",
        name: "UserUpdate",
        beforeEnter: loginCheck,
        component: UserUpdate,
      },
    ],
  },
  // 로그인 필요 페이지 예시
  {
    path: "mypage",
    name: "MyPage",
    beforeEnter: loginCheck,
    // component : userInfo,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
