<template>
  <v-content>
    <v-divider id="Home"  class="mb-10"></v-divider>
    <Hero />
    <v-divider id="AboutUs" class="mb-10 mt-10"></v-divider>
    <AboutUs />
    <v-divider id="Gallery" class="mb-10 mt-10"></v-divider>
    <Gallery />
    <v-divider id="ContactUs" class="mb-10 mt-10"></v-divider>
    <ContactUs/>
    <v-divider class="mb-10 mt-10"></v-divider>
  </v-content>
</template>

<script>
import Hero from "../components/Hero";
import Gallery from "../components/Gallery";
import AboutUs from "../components/AboutUs";
import ContactUs from "../components/ContactUs";

export default {
  name: "Home",

  components: {
    Hero,
    Gallery,
    AboutUs,
    ContactUs,
  }
};
</script>
