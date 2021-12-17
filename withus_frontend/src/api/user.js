import { apiInstance } from "./index.js";

const api = apiInstance();

async function registerUser(user, success, fail) {
  await api.post(`/user`, JSON.stringify(user)).then(success).catch(fail);
}

async function getById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${userid}`).then(success).catch(fail);
}

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

export { registerUser, getById, login };
