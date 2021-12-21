import { apiInstance } from "./index.js";
const api = apiInstance();

//teaminfo
function postTeamInfo(teaminfo, success, fail) {
  api.post(`/teams/post/`, JSON.stringify(teaminfo)).then(success).catch(fail);
}

export { postTeamInfo };
