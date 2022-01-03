<template>
  <v-container>
    <v-row>
      <v-col>
        <h1 class="intro-text">Wedding Planner</h1>
        <v-container>
          <p class="description">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur
            culpa, praesentium vel temporibus dolore voluptatum perspiciatis
            aliquid ex sit facilis inventore aspernatur nesciunt officiis,
            officia, eligendi ab odio perferendis impedit! Lorem ipsum dolor sit
            amet consectetur adipisicing elit. Sed cumque quibusdam quis et qui
            rerum id earum aliquam consectetur odit, temporibus veritatis ad!
            Voluptatem placeat quo fugiat asperiores voluptatum nihil?
          </p></v-container
        >
        <v-btn
          color="#FF4F5A"
          dark
          rounded
          @click="() => $router.push('/#AboutUs')"
          >Get Started</v-btn
        >
      </v-col>
      <div class="rounded">
        <v-col>
          <img
            style="border-radius: 20%; margin-top: 70px"
            src="./../assets/gifhero.gif"
          />
        </v-col>
      </div>
    </v-row>
  </v-container>
</template>
<script>
export default {
  name: "Hero",
  data() {
    return {}
  },
}
</script>
<style scoped>
h1.intro-text {
  font-size: 60px;
  font-weight: bold;
  font-family: montserrat;
  color: #444;
}
p.description {
  font-size: 18px;
  /* color: #444; */
  color: rgb(109, 109, 109);
  font-weight: bold;
}
</style>
