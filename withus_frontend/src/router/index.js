import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

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
    name: "Home",
    component: Home,
  },
  {
    path: "/user",
    name: "User",
    component: User,
    children: [
      {
        path: "usermypage",
        name: "UserMyPage",
        component: UserMyPage,
      },
      {
        path: "userupdate",
        name: "UserUpdate",
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
