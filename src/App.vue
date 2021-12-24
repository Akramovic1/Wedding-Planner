<template>
  <v-app>
    <!-- <v-app-bar flat max-height="65"> -->
      <Header  app/>
    <!-- </v-app-bar> -->

    <router-view></router-view>

    <!-- <v-footer> -->
      <Footer class="mb-10"/>
    <!-- </v-footer> -->
    <v-divider></v-divider>
    <v-row justify="center">
            <div class="mt-1">
            <v-card-text>
            {{ new Date().getFullYear() }} —
            <strong>Wedding Planner</strong>
           </v-card-text>
          </div>
    </v-row>
  </v-app>
</template>

<script>
import Header from "./components/common/Header";
import Footer from "./components/common/Footer";

export default {
  name: "App",

  components: {
    Header,
    Footer
  },

  data: () => ({
    //
  })
};
</script>
