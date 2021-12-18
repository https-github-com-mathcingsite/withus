import jwt_decode from "jwt-decode";

import { login, getById, register } from "@/api/user.js";

const userStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
    isRegist: false,
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    SET_REGIST: (state, isRegist) => {
      state.isRegist = isRegist;
    },
  },
  actions: {
    async userLogin({ commit }, user) {
      await login(
        user,
        ({ data }) => {
          if (data.message === "success") {
            let token = data["access-token"];
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            sessionStorage.setItem("access-token", token);
          } else {
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
          }
        },
        () => {}
      );
    },
    async getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      await getById(
        decode_token.userid,
        ({ data }) => {
          if (data.message === "success") {
            commit("SET_USER_INFO", data.userInfo);
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async userRegister({ commit }, user) {
      console.log(user);
      await register(user, ({ data }) => {
        if (data === "success") {
          commit("SET_REGIST", true);
        } else {
          commit("SET_REGIST", false);
        }
      });
    },
  },
};
export default userStore;
