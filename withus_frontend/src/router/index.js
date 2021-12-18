import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

import Member from "@/views/Member.vue";
import MemberMyPage from "@/components/member/MemberMyPage.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/user",
    name: "Member",
    component: Member,
    children: [
      {
        path: "mypage",
        name: "MyPage",
        component: MemberMyPage,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
