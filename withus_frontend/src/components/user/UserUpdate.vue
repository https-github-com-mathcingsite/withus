<template>
  <v-row justify="center">
    <v-col cols="12" sm="10" md="8" lg="6">
      <br /><br /><br /><br /><br />
      <v-card ref="form">
        <v-card-text>
          <v-text-field
            ref="userId"
            v-model="user.userId"
            label="아이디"
            value="user.userId"
            disabled
          ></v-text-field>
          <v-text-field
            ref="userPwd"
            v-model="user.userPwd"
            :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show1 ? 'text' : 'password'"
            name="input-10-1"
            label="비밀번호"
            hint="8글자 이상 써주세요."
            counter
            disabled
            @click:append="show1 = !show1"
          ></v-text-field>
          <v-text-field
            ref="userName"
            v-model="user.userName"
            label="이름"
            value="user.userName"
            disabled
          ></v-text-field>
          <!-- <v-text-field label="이메일"></v-text-field> -->
          <v-text-field
            ref="email"
            v-model="user.email"
            label="이메일"
            value="user.email"
            disabled
          ></v-text-field>
          <v-text-field
            ref="mbti"
            v-model="user.mbti"
            value="user.mbti"
            :rules="[() => !!user.mbti || 'This field is required']"
            :error-messages="errorMessages"
            label="mbti"
            required
          ></v-text-field>
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
          <v-btn color="primary" text @click="submit"> Submit </v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
const userStore = "userStore";

export default {
  name: "UserUpdate",
  data() {
    return {
      user: {
        userId: "",
        userPwd: "",
        userName: "",
        email: "",
        mbti: "",
      },
      show1: false,
      rules: {
        required: (value) => !!value || "Required.",
        min: (v) => v.length >= 8 || "Min 8 characters",
      },
    };
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
    ...mapMutations(userStore, ["SET_USER_INFO"]),
    form() {
      return {
        userId: this.userId,
        userPwd: this.userPwd,
        userName: this.userName,
        email: this.email,
        mbti: this.mbti,
      };
    },
  },
  created() {
    (this.user.userId = this.userInfo.userId),
      (this.user.userPwd = this.userInfo.userPwd),
      (this.user.userName = this.userInfo.userName),
      (this.user.email = this.userInfo.email),
      (this.user.mbti = this.userInfo.mbti);
  },
  watch: {
    name() {
      this.errorMessages = "";
    },
  },
  methods: {
    ...mapActions(userStore, ["updateUser"]),
    resetForm() {
      this.errorMessages = [];
      this.formHasErrors = false;

      Object.keys(this.form).forEach((f) => {
        this.$refs[f].reset();
      });
    },
    submit() {
      this.formHasErrors = false;

      Object.keys(this.form).forEach((f) => {
        if (!this.form[f]) {
          this.formHasErrors = true;
          this.updateUser(this.user);
          this.$router.push({ name: "UserMyPage" });
          // this.$router.go(this.$router.currentRoute);
        }

        this.$refs[f].validate(true);

        // this.updateUser(this.user);
        // this.$router.push({ name: "UserMyPage" });
        // this.$router.go(this.$router.currentRoute);
      });
    },
  },
};
</script>

<style></style>
