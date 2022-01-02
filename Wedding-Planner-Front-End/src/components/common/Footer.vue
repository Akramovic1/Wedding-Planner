<template>
    <v-footer padless>
      <v-col lg="12">
        <v-row justify="center">
          <v-col lg="4" class="text-center">
            <h1 class="blod"> Wedding Planner</h1>
             <v-card-text>
          <v-btn v-for="icon in icons" :key="icon" class="mx-4 black--text" icon>
            <v-icon size="24px">{{ icon }}</v-icon>
          </v-btn>
        </v-card-text>
        <p justify="center">Subscribe for our new offers and deals.</p>

        <v-text-field
      v-model="emailSubscribe"
      :rules="emailRules"
      label="E-mail"
      color="#FF4F5A"
      required
    ></v-text-field>

    <v-btn dark color="#FF4F5A" class="mr-4">
      Subscribe
    </v-btn>
          </v-col>
        </v-row>
      </v-col>
  
    </v-footer>
</template>

<script>
export default {
  name: "Header",
  data: () => ({
    emailSubscribe:"",
    icons: [
      "fab fa-facebook",
      "fab fa-twitter",
      "fab fa-google-plus",
      "fab fa-linkedin",
      "fab fa-instagram"
    ]
  })
};
</script>
><style scoped>
p{
    font-size: 18px;
    /* color: rgb(109, 109, 109); */
    font-weight: bold;
}
h1{
font-size: 25px;
font-weight: 700;

}
</style>