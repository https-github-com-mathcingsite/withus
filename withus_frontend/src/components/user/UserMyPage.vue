<template>
  <v-row justify="center">
    <v-col cols="12" sm="10" md="8" lg="6">
      <br /><br /><br /><br /><br />
      <v-card>
        <v-card-text>
          <v-text-field
            label="아이디"
            :value="userInfo.userId"
            disabled
          ></v-text-field>
          <v-text-field
            label="이름"
            :value="userInfo.userName"
            disabled
          ></v-text-field>
          <v-text-field
            ref="email"
            label="이메일"
            :value="userInfo.email"
            disabled
          ></v-text-field>
          <v-text-field
            ref="mbti"
            label="mbti"
            :value="userInfo.mbti"
            disabled
          ></v-text-field>
        </v-card-text>
        <v-divider class="mt-12"></v-divider>
        <v-card-actions>
          <v-btn color="error" text> 탈퇴 </v-btn>
          <v-spacer></v-spacer>
          <v-slide-x-reverse-transition>
            <v-tooltip v-if="formHasErrors" left>
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  icon
                  class="my-0"
                  v-bind="attrs"
                  @click="resetForm"
                  v-on="on"
                >
                  <v-icon>mdi-refresh</v-icon>
                </v-btn>
              </template>
              <span>Refresh form</span>
            </v-tooltip>
          </v-slide-x-reverse-transition>
          <v-btn color="primary" text @click="submit">수정 </v-btn>
          <!-- <v-btn color="primary" text @click="submit"
            ><router-link :to="{ name: 'UserUpdate' }" class="link"
              >Submit</router-link
            >
          </v-btn> -->
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { mapState, mapMutations } from "vuex";
const userStore = "userStore";

export default {
  name: "UserMyPage",
  components: {},
  data() {
    return {
      title: this.userInfo.userId,
      description: "California is a state in the western United States",
      rules: [(v) => v.length <= 25 || "Max 25 characters"],
      wordsRules: [(v) => v.trim().split(" ").length <= 5 || "Max 5 words"],
    };
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
    ...mapMutations(userStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
  },
  methods: {
    submit() {
      this.$router.push({ name: "UserUpdate" }).catch(() => {});
    },
    updateUser() {
      this.updateUser(this.user);
      this.$router.push({ name: "UserMyPage" });
    },
  },
};
</script>

<style></style>
