<template>
  <v-row justify="center">
    <v-col cols="12" sm="10" md="8" lg="6">
      <br /><br /><br /><br /><br />
      <v-card ref="form">
        <v-card-text>
          <p>아이디 : {{ userInfo.userId }}</p>
          <p>비밀번호 : {{ userInfo.userPwd }}</p>
          <p>이름 : {{ userInfo.userName }}</p>
          <p>mbti : {{ userInfo.mbti }}</p>
        </v-card-text>
        <v-divider class="mt-12"></v-divider>
        <v-card-actions>
          <v-btn text> Cancel </v-btn>
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
          <v-btn color="primary" text @click="submit">Submit </v-btn>
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
  computed: {
    ...mapState(userStore, ["userInfo"]),
    ...mapMutations(userStore, ["SET_USER_INFO"]),
  },
  methods: {
    resetForm() {
      this.errorMessages = [];
      this.formHasErrors = false;

      Object.keys(this.form).forEach((f) => {
        this.$refs[f].reset();
      });
    },
    submit() {
      this.$router.push({ name: "UserUpdate" });
    },
  },
};
</script>

<style></style>
