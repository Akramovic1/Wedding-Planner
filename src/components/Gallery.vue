<template>
  <div>
    <v-container>
      <h2 class="text-center">Gallery</h2>
      <v-row>
        <v-col lg="12" class="text-center">
          <!-- <v-subheader class="text-h4 justify-center">Gallery</v-subheader> -->
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquid
            minus inventore dolor fugit. Nisi odio asperiores neque sit
            excepturi accusantium eveniet atque dolorum dicta mollitia enim
            similique, natus autem rerum.
          </p>
        </v-col>
        <v-col lg="12">
          <div class="text-center">
            <v-chip
              dark
              @click="activeGallery = 'halls'"
              :color="activeGallery == 'halls' ? '#FF4F5A' : ''"
              class="mx-5 active"
              >Halls</v-chip
            >
            <v-chip
              dark
              @click="activeGallery = 'photographers'"
              :color="activeGallery == 'photographers' ? '#FF4F5A' : ''"
              class="mx-5"
              >Photographers</v-chip
            >
            <v-chip
              dark
              @click="activeGallery = 'makeupArtists'"
              :color="activeGallery == 'makeupArtists' ? '#FF4F5A' : ''"
              class="mx-5"
              >Makeup Artists</v-chip
            >
          </div>
        </v-col>

        <slot v-if="activeGallery == 'halls'">
          <v-col
            v-for="item in halls"
            :key="item.id"
            class="d-flex child-flex"
            cols="6"
            sm="4"
          >
            <v-card flat tile class="d-flex">
              <v-img :src="item.src" aspect-ratio="1" class="grey lighten-2">
                <template v-slot:placeholder>
                  <v-row
                    class="fill-height ma-0"
                    align="center"
                    justify="center"
                  >
                    <v-progress-circular
                      indeterminate
                      color="grey lighten-5"
                    ></v-progress-circular>
                  </v-row>
                </template>
              </v-img>
            </v-card>
          </v-col>
        </slot>

        <slot v-if="activeGallery == 'makeupArtists'">
          <v-col
            v-for="item in makeupArtists"
            :key="item.id"
            class="d-flex child-flex"
            cols="6"
            sm="4"
          >
            <v-card flat tile class="d-flex">
              <v-img :src="item.src" aspect-ratio="1" class="grey lighten-2">
                <template v-slot:placeholder>
                  <v-row
                    class="fill-height ma-0"
                    align="center"
                    justify="center"
                  >
                    <v-progress-circular
                      indeterminate
                      color="grey lighten-5"
                    ></v-progress-circular>
                  </v-row>
                </template>
              </v-img>
            </v-card>
          </v-col>
        </slot>

        <slot v-if="activeGallery == 'photographers'">
          <v-col
            v-for="item in photographers"
            :key="item.id"
            class="d-flex child-flex"
            cols="6"
            sm="4"
          >
            <v-card flat tile class="d-flex">
              <v-img :src="item.src" aspect-ratio="1" class="grey lighten-2">
                <template v-slot:placeholder>
                  <v-row
                    class="fill-height ma-0"
                    align="center"
                    justify="center"
                  >
                    <v-progress-circular
                      indeterminate
                      color="grey lighten-5"
                    ></v-progress-circular>
                  </v-row>
                </template>
              </v-img>
            </v-card>
          </v-col>
        </slot>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "Gallery",
  data() {
    return {
      activeGallery: "halls",
      halls: [
        { id: 1, src: require("../assets/images/hall1.png") },
        { id: 2, src: require("../assets/images/hall2.jpg") },
        { id: 3, src: require("../assets/images/hall3.jpg") },
        { id: 4, src: require("../assets/images/hall4.jpg") },
        { id: 5, src: require("../assets/images/hall5.png") },
        { id: 6, src: require("../assets/images/hall6.jpg") },
        { id: 7, src: require("../assets/images/hall7.jpg") },
        { id: 8, src: require("../assets/images/hall8.jpg") },
        { id: 9, src: require("../assets/images/hall9.jpg") },
      ],

      makeupArtists: [
        { id: 1, src: require("../assets/images/m1.jpg") },
        { id: 2, src: require("../assets/images/m2.jpg") },
        { id: 3, src: require("../assets/images/m3.jpg") },
        { id: 4, src: require("../assets/images/m4.jpg") },
        { id: 5, src: require("../assets/images/m5.jpg") },
        { id: 5, src: require("../assets/images/m6.jpg") },
        { id: 5, src: require("../assets/images/m7.png") },
        { id: 5, src: require("../assets/images/m8.jpg") },
        { id: 5, src: require("../assets/images/m9.png") },
      ],

      photographers: [
        { id: 1, src: require("../assets/images/p1.jpg") },
        { id: 2, src: require("../assets/images/p2.jpg") },
        { id: 3, src: require("../assets/images/p3.jpg") },
        { id: 4, src: require("../assets/images/p4.jpg") },
        { id: 5, src: require("../assets/images/p5.jpg") },
        { id: 2, src: require("../assets/images/p6.jpg") },
        { id: 3, src: require("../assets/images/p7.jpg") },
        { id: 4, src: require("../assets/images/p8.jpg") },
        { id: 5, src: require("../assets/images/p9.jpg") },
      ],
    }
  },
}
</script>

<style scoped>
h2 {
  padding: 20px;
  font-size: 40px;
  font-weight: bold;
  font-family: cursive;
  color: rgb(109, 109, 109);
}
p {
  font-size: 18px;
  color: rgb(109, 109, 109);
  font-weight: bold;
}
</style>
