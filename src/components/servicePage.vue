<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" max-width="1100px">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          style="margin-left: 60%"
          color="red"
          text
          v-bind="attrs"
          v-on="on"
        >
          More<v-icon>mdi-chevron-right</v-icon>
        </v-btn>
      </template>

      <v-row no-gutters>
        <!-- image cornter -->
        <v-col cols="6">
          <v-carousel cycle hide-delimiters show-arrows-on-hover height="610">
            <v-carousel-item
              v-for="(photo, i) in photos"
              :key="i"
              :src="photo.src"
            ></v-carousel-item>
          </v-carousel>
        </v-col>

        <!-- text corner -->
        <v-col cols="6" class="card">
          <v-card tile class="rounded-tr rounded-td" height="610">
            <v-card-title>
              <v-row>
                <v-col cols="1" style="padding: 10px 10px 0px 15px">
                  <v-avatar size="45">
                    <img
                      src="..\assets\images\team2.jpg"
                      alt="Mostafa el gamed"
                    />
                  </v-avatar>
                </v-col>
                <v-col cols="8" style="padding: 0px 10px">
                  <v-list-item two-line>
                    <v-list-item-content>
                      <v-list-item-title>Mostafa Ahmed</v-list-item-title>
                      <v-list-item-subtitle>Hall owner</v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>
                </v-col>
              </v-row>
            </v-card-title>

            <v-divider></v-divider>

            <v-card-text style="height: 445px; overflow-y: auto">
              <!-- name of the service -->
              <h1 style="padding: 10px 10px 15px 15px">
                {{ this.serviceInfo.title }}
              </h1>
              <v-timeline dense>
                <!-- description -->
                <v-timeline-item
                  icon="mdi-card-text-outline"
                  fill-dot
                  color="#ff4f5a"
                >
                  <v-col>
                    <strong>Description</strong>
                    <div class="text-caption">
                      Lorem ipsum dolor sit amet, no nam oblique veritus.
                      Commune scaevola imperdiet nec ut, sed euismod convenire
                      principes at. Est et nobis iisque percipit, an vim zril
                      disputando voluptatibus, vix an salutandi sententiae.
                    </div>
                  </v-col>
                </v-timeline-item>

                <!-- locations -->
                <v-timeline-item
                  icon="mdi-map-marker-outline"
                  fill-dot
                  color="#ff616b"
                >
                  <v-col>
                    <strong>Location</strong>
                    <div class="text-caption">
                      {{ this.serviceInfo.address }}
                    </div>
                  </v-col>
                </v-timeline-item>

                <!-- Cost -->
                <v-timeline-item
                  icon="mdi-cash-multiple"
                  fill-dot
                  color="#ff727b"
                >
                  <v-col>
                    <strong>Cost</strong>
                    <div class="text-caption">
                      <h2>255$</h2>
                    </div>
                  </v-col>
                </v-timeline-item>

                <!-- rating  -->
                <v-timeline-item
                  icon="mdi-star-shooting-outline"
                  fill-dot
                  color="#ff848c"
                >
                  <v-col>
                    <strong>Rating</strong>

                    <v-rating
                      background-color="#FEC260"
                      color="#FEC260"
                      length="5"
                      size="50"
                      value="4.5"
                      readonly
                    ></v-rating>
                  </v-col>
                </v-timeline-item>

                <!-- Reviews  -->
                <v-timeline-item
                  icon="mdi-message-text"
                  fill-dot
                  color="#ff959c"
                >
                  <v-card class="elevation-2">
                    <v-card-text><h3>Reviews</h3></v-card-text>
                    <v-divider class="mx-5"></v-divider>
                    <v-card-text
                      ><strong>Mostafa : </strong>WTF is this place i hate
                      it</v-card-text
                    >
                    <v-divider class="mx-4"></v-divider>
                    <v-card-text
                      ><strong>Mohamed : </strong>Lorem ipsum dolor sit amet, no
                      nam oblique veritus. Commune scaevola imperdiet nec ut,
                      sed euismod convenire principes at. Est et nobis iisque
                      percipit, an vim zril disputando voluptatibus, vix an
                      salutandi sententiae.</v-card-text
                    >
                    <v-divider class="mx-4"></v-divider>
                    <v-card-text
                      ><strong>Amr : </strong>Lorem ipsum dolor sit amet, no nam
                      oblique veritus. Commune scaevola imperdiet nec ut, sed
                      euismod convenire principes at. Est et nobis iisque
                      percipit, an vim zril disputando voluptatibus, vix an
                      salutandi sententiae.</v-card-text
                    >
                    <v-divider class="mx-4"></v-divider>
                    <v-card-text
                      ><strong>Ahmed : </strong>this is an awesome place ,
                      thanks for your effort</v-card-text
                    >
                  </v-card>
                </v-timeline-item>
              </v-timeline>
            </v-card-text>

            <v-divider></v-divider>

            <v-card-actions style="padding: 14px 20px">
              <v-spacer></v-spacer>
              <v-btn color="#FF4F5A" text @click="dialog = false">
                Close
              </v-btn>
              <v-btn color="#ff616b" dark @click="dialog = false"> Book </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  props: ["service"],
  data() {
    return {
      dialogm1: "",
      dialog: false,
      serviceInfo: "",
      photos: [
        {
          src: require("../assets/images/hall1.png"),
        },
        {
          src: require("../assets/images/hall2.jpg"),
        },
        {
          src: require("../assets/images/hall9.jpg"),
        },
        {
          src: require("../assets/images/hall4.jpg"),
        },
        {
          src: require("../assets/images/hall8.jpg"),
        },
      ],
    }
  },
  mounted() {
    this.serviceInfo = JSON.parse(JSON.stringify(this.service))
    //this.photos = JSON.parse(JSON.stringify(this.service.image));
  },
}
</script>

<style lang="scss">
.serviceTitles {
  padding: 15px 15px;
}
</style>
