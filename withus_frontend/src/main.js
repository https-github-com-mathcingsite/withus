import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
// import plugin
import "material-design-icons-iconfont/dist/material-design-icons.css"; // Ensure you are using css-loader
import { TiptapVuetifyPlugin } from "tiptap-vuetify";
// don't forget to import CSS styles
import "tiptap-vuetify/dist/main.css";

// Vuetify's CSS styles
import "vuetify/dist/vuetify.min.css";
Vue.use(TiptapVuetifyPlugin, {
  // the next line is important! You need to provide the Vuetify Object to this place.
  vuetify, // same as "vuetify: vuetify"
  iconsGroup: "md",
});
Vue.config.productionTip = false;
new Vue({
  router,
  store,
  vuetify,
  icons: {
    iconfont: "md",
  },
  render: (h) => h(App),
}).$mount("#app");
