<template>
  <v-content>
    <Mainbar app />
    <v-container class="my-5" style="width:100%" mx2 >
      <v-layout row wrap>
        <v-flex xl2 md2 xs4>
          <SideBar fixed/>
        </v-flex>
        <v-flex xl10 md10 xs8>
          <v-container class="flex"  style="display: flex; height: 80vh;overflow:auto">
            <v-layout row wrap justify-space>
            <v-col v-for="item in items" :key="item.id" class="d-flex child-flex" cols="5" lg="4" md="4" sm="5"  xs="10">
            <v-card
                class="mx-10 my-5 "
                max-width="250"
            >
              <v-img
                  height="200"
                  :src= "item.image"
              ></v-img>
              <v-card-title> {{item.title}} </v-card-title>
              <v-card-text>
                <v-row
                    align="center"
                    class="mx-0"
                >
                  <v-rating
                      :value= item.rate
                      color="amber"
                      dense
                      half-increments
                      readonly
                      size="14"
                  ></v-rating>
                  <div class="grey--text ms-2">
                    {{item.rate}}
                  </div>
                </v-row>
                <div class="my-2 text-subtitle-1"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  {{item.address}}
                </div>
              </v-card-text>
              <v-divider class="mx-2"></v-divider>
            </v-card>
            </v-col>
            </v-layout>
          </v-container>
        </v-flex>
      </v-layout>
    </v-container>
    <!-- <v-container height="100%">
       <v-layout class="split">
      <v-row no-gutters>
        <v-col
          cols="4"
          sm="3"
          md="2"
        >
        <SideBar app />

        </v-col>
        <v-col
          cols="12"
          md="10"
        >
      
      <v-container class="flex" style="overflow:auto">
      <v-col v-for="item in items" :key="item.id" class="d-flex child-flex" cols="5" lg="3" md="4" sm="5"  xs="10">
      <v-card
          class="mx-auto my-12 "
          max-width="250"
      >
        <v-img
            height="200"
            :src= "item.image"
        ></v-img>
        <v-card-title> {{item.title}} </v-card-title>
        <v-card-text>
          <v-row
              align="center"
              class="mx-0"
          >
            <v-rating
                :value= item.rate
                color="amber"
                dense
                half-increments
                readonly
                size="14"
            ></v-rating>
            <div class="grey--text ms-2">
              {{item.rate}}
            </div>
          </v-row>
          <div class="my-2 text-subtitle-1"><i class="fa fa-map-marker" aria-hidden="true"></i>
            {{item.address}}
          </div>
        </v-card-text>
        <v-divider class="mx-2"></v-divider>
      </v-card>
      </v-col>
      </v-container>
      </v-col>
    </v-row>
       </v-layout>
    </v-container> -->
    
  </v-content>
</template>

<script>
import Mainbar from "../components/Mainbar";
import SideBar from '../components/SideBar.vue';

export default {
  name: "MainPage.vue",
  components: {Mainbar,SideBar},
  data() {
    return {
      items:[
        {
          id: 0,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 1,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 2,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 3,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 4,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 5,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 6,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 7,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
        {
          id: 8,
          title: "Cafe Badilico",
          image: "https://cdn.vuetifyjs.com/images/cards/cooking.png",
          rate: 4.5,
          address: "Al-Agmy, Alexandria",
        },
      ]
    }
  }
}
</script>

<style scoped>
.flex{
  display: flex;
  flex-wrap: wrap;
  margin: 0;
  padding: 0;
}
</style>