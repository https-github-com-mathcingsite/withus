import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Teams from "../views/Teams.vue";
import TeamSearch from "@/components/main/TeamMain.vue";
import RecruitPost from "@/components/teams/RecruitPost.vue";
//view : import RecruitView from "@/components/teams/RecruitView.vue";

Vue.use(VueRouter);

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
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
