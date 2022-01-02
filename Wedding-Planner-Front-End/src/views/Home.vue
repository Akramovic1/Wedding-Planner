<template>

  <v-content>
  <Header  app/>
    <v-divider id="Home"  class="mb-10"></v-divider>
    <Hero />
    <v-divider id="AboutUs" class="mb-10 mt-10"></v-divider>
    <AboutUs />
    <v-divider id="Gallery" class="mb-10 mt-10"></v-divider>
    <Gallery />
    <v-divider id="ContactUs" class="mb-10 mt-10"></v-divider>
    <ContactUs/>
    <v-divider class="mb-10 mt-10"></v-divider>
    <Footer class="mb-10"/>
   <v-divider></v-divider>
   <v-row justify="center">
           <div class="mt-1">
           <v-card-text>
           {{ new Date().getFullYear() }} —
           <strong>Wedding Planner</strong>
          </v-card-text>
         </div>
  </v-row>
  </v-content>

</template>

<script>
import Hero from "../components/Hero";
import Gallery from "../components/Gallery";
import AboutUs from "../components/AboutUs";
import ContactUs from "../components/ContactUs";
import Header from "../components/common/Header";
import Footer from "../components/common/Footer";

export default {
  name: "Home",

  components: {
    Hero,
    Gallery,
    AboutUs,
    ContactUs,
    Header,
    Footer,
  }
};
</script>
<style scoped>

</style>