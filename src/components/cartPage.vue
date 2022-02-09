<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" max-width="900px">
      <template v-slot:activator="{ on, attrs }">
        <v-btn v-bind="attrs" v-on="on" icon color="black" @click="loadCart()">
          <v-icon>mdi-cart-outline</v-icon>
        </v-btn>
      </template>

      <v-row no-gutters>
        <!-- image cornter -->
        <v-col cols="4">
          <v-img src="..\assets\images\cart.jpg" height="610"> </v-img>
        </v-col>

        <!-- text corner -->
        <v-col cols="8" class="card">
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
                      <v-list-item-subtitle>Cart List</v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>
                </v-col>
              </v-row>
            </v-card-title>

            <v-divider></v-divider>

            <v-card-text style="height: 445px; overflow-y: auto">
              <!-- List of Services -->
              <v-row v-for="(service, i) in ServicesList" :key="i">
                <v-col cols="2" style="padding: 10px 10px 20px 25px">
                  <v-avatar size="90">
                    <img class="image" :src="service.imgUrl[0]" />
                  </v-avatar>
                </v-col>

                <v-col cols="8" style="padding: 5px 20px">
                  <v-list-item four-line>
                    <v-list-item-content>
                      <v-list-item-title>{{ service.name }}</v-list-item-title>
                      <v-list-item-subtitle>{{
                        service.location
                      }}</v-list-item-subtitle>
                      <v-list-item-subtitle>{{
                        service.description
                      }}</v-list-item-subtitle>
                      <v-list-item-subtitle>{{
                        service.cost
                      }}</v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>
                </v-col>

                <v-col cols="2" style="padding: 35px 25px">
                  <v-btn icon color="pink" @click="removeFromCart(service.id)"
                    ><v-icon>mdi-close</v-icon></v-btn
                  >
                </v-col>
              </v-row>
            </v-card-text>

            <v-divider></v-divider>

            <v-card-actions style="padding: 14px 20px">
              <v-spacer></v-spacer>
              <v-btn color="#FF4F5A" text @click="dialog = false">
                Close
              </v-btn>
              <v-btn
                color="#ff616b"
                dark
                @click="payment()">
                Check Out
              </v-btn>
              <pay v-model="dialog2" />
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>

      <v-snackbar v-model="snackbar">
        {{ message }}
        <template v-slot:action="{ attrs }">
          <v-btn color="blue" text v-bind="attrs" @click="snackbar = false">
            Close
          </v-btn>
        </template>
      </v-snackbar>


    </v-dialog>
  </v-row>
</template>

<script>

import Pay from "./Pay.vue"
import axios from "axios"

export default {
  components: { Pay },
  data() {
    return {
      dialog: false,
      dialog2: false,

      snackbar: false,
      message: '',


      ServicesList: [
        {
          name: "Alexandria Hall",
          address: "Alexandria , sidi-gaber",
          description:
            "Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdi nec ut, sed euismod convenire principes at",
          cost: "200$",
          imageSrc: require("../assets/images/hall1.png"),
        },
        {
          name: "Mostafa Ahmed photographer",
          address: "Alexandria , loran",
          description:
            "Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdi nec ut, sed euismod convenire principes at",
          cost: "110$",
          imageSrc: require("../assets/images/p5.jpg"),
        },
        {
          name: "Mohamed Radwan Makeup artist",
          address: "Alexandria , miamai",
          description:
            "Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdi nec ut, sed euismod convenire principes at",
          cost: "100$",
          imageSrc: require("../assets/images/m1.jpg"),
        },
        {
          name: "Rana Makeup artist",
          address: "Alexandria , loran",
          description:
            "Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdi nec ut, sed euismod convenire principes at",
          cost: "100$",
          imageSrc: require("../assets/images/m3.jpg"),
        },
        {
          name: "Amr photographer",
          address: "Alexandria , sidi-beshr",
          description:
            "Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdi nec ut, sed euismod convenire principes at",
          cost: "100$",
          imageSrc: require("../assets/images/p4.jpg"),
        },
      ],
    }
  },
  methods: {
    removeFromCart(id) {
      axios.get("http://localhost:8080/api/deleteServiceFromCart", {
        params: {
          serviceID: id,
        },
      })
      .then((Response) => {
        const Data = Response.data
        if (Data == true) {
            this.message = "service has been deleted from the cart successfully"
            this.loadCart();
        }
        else 
          this.message = "something went wrong"
        
        this.snackbar = true
        
      })
    },
    loadCart(){
      axios.get("http://localhost:8080/api/loadCart", {})
      .then((Response) => {
        const Data = Response.data
        this.ServicesList = Data.services ;
      })
    },
    payment(){
    
      this.dialog = false;
        this.dialog2 = true;

      axios.get("http://localhost:8080/api/pay", {
        params: {
          paymentMethod : 'credit card',
        },
      })
      .then((Response) => {
        this.message = Response ;
      })

    }
  },
  mounted() {
    this.loadCart();
  },
}
</script>

<style></style>
