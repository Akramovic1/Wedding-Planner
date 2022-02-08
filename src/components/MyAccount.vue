<template>
  <v-dialog max-width="1100px" :value="value" @input="$emit('input')">
    <v-row no-gutters style="overflow-x: hidden">
      <!-- image cornter -->
      <v-col cols="3">
        <v-card tile class="rounded-tr rounded-td" height="625">
          <v-card-title>
            <v-row>
              <v-col
                align="center"
                justify="center"
                style="padding: 10px 10px 0px 15px"
              >
                <v-avatar size="70">
                  <img src="..\assets\images\team1.jpg" />
                </v-avatar>
              </v-col>
              <v-col align="center" justify="center" style="padding: 10px 10px">
                <v-list-item>
                  <v-list-item-content>
                    <v-list-item-title Style="font-weight:bold"
                      >Account Name</v-list-item-title
                    >
                  </v-list-item-content>
                </v-list-item>
              </v-col>
            </v-row>
          </v-card-title>
          <v-divider></v-divider>
          <v-col align="center" justify="center" justify-content="center">
            <v-list>
              <v-list-item>
                <v-btn
                  rounded
                  style="width: 100%"
                  class="mt-4"
                  :color="selectedOption == 'Profile' ? '#FF4F5A' : ''"
                  @click="selectedOption = 'Profile'"
                  >Profile</v-btn
                >
              </v-list-item>
              <v-list-item>
                <v-btn
                  rounded
                  style="width: 100%"
                  class="mt-4"
                  :color="selectedOption == 'Orders' ? '#FF4F5A' : ''"
                  @click="selectedOption = 'Orders'"
                  >Order</v-btn
                >
              </v-list-item>
              
            </v-list>
          </v-col>
        </v-card>
        <!-- <v-carousel
              cycle
              hide-delimiters
              show-arrows-on-hover
              height="610"
          >
            <v-carousel-item
                v-for="(photo,i) in photos"
                :key="i"
                :src="photo.src"
            ></v-carousel-item> -->
        <!-- </v-carousel> -->
      </v-col>

      <!-- text corner -->
      <v-col cols="9">
        <v-card tile class="rounded-tr rounded-td" height="625">
          <v-card-title style="padding: 10px">
            <v-row>
              <v-col>
                <v-list-item>
                  <v-list-item-content>
                    <v-list-item-title
                      Style="font-size:20px;font-weight:bold"
                      >{{ selectedOption }}</v-list-item-title
                    >
                  </v-list-item-content>
                </v-list-item>
              </v-col>
              <v-col> </v-col>
              <v-col> </v-col>
            </v-row>
          </v-card-title>

          <v-divider></v-divider>

          <v-card-text style="height: 530px; overflow-y: auto">
            <slot v-if="selectedOption == 'Profile'">
              <!-- <i>Profile -- TO DO</i>-->
              <v-col>
                <v-row>
                  <h3 class="mb-7">User information</h3>
                </v-row>
                <v-row>
                  <v-col>
                    <v-text-field
                      v-model="username"
                      label="User Name"
                      dense
                      :rules="lastNameRules"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <v-text-field
                      v-model="email"
                      label="Email"
                      dense
                      :rules="emailRules"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                  <!-- <v-col>
                    <v-text-field
                      v-model="date"
                      label="Birth-date"
                      dense
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col> -->
                  <v-col cols="12" lg="6">
      <v-menu
        ref="menu"
        v-model="menu"
        :close-on-content-click="false"
        transition="scale-transition"
        offset-y
        min-width="auto"
      >
        <template v-slot:activator="{ on, attrs2 }">
          <v-text-field
            v-model="date"
            label="Birth-date"
            prepend-icon="mdi-calendar"
            readonly
            dense
            color="#FF4F5A"
            v-bind="attrs2"
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker
          v-model="date"
          no-title
          scrollable
        >
        
        </v-date-picker>
      </v-menu>
    </v-col>
                  
                </v-row>
                
                <v-row style="margin-top: 20px">
                  <h3 class="mb-7">Contact information</h3>
                </v-row>
                <v-row>
                  <v-col>
                    <v-text-field
                      v-model="phone"
                      label="Phone"
                      dense
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                  <v-col>
                    <v-text-field
                      v-model="address"
                      label="Address"
                      dense
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col> </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark text style="margin-left: 60px" @click="reset()">
                      Reset
                    </v-btn>
                  </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark style="margin-left: 40px" @click="save()">
                      Save
                    </v-btn>
                  </v-col>
                </v-row>
 
                <v-divider></v-divider>
              
                <v-row style="margin-top: 20px">
                  <h3 class="mb-7">Password</h3>
                </v-row>
                <v-row>
                  <v-col>
                    <v-text-field
                      v-model="oldPassword"
                      label="Old Password"
                      type="password"
                      dense
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                  <v-col>
                    <v-text-field
                      v-model="newPassword"
                      label="New Password"
                      type="password"
                      :rules="passwordRules"
                      dense
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col> </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark text style="margin-left: 60px" @click="oldPassword = newPassword = ''">
                      Reset
                    </v-btn>
                  </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark style="margin-left: 40px" @click="savePasswordChange()">
                      Save
                    </v-btn>
                  </v-col>
                </v-row>
              </v-col>
            </slot>
            <slot v-if="selectedOption == 'Orders'">
              <v-row v-for="(service, i) in ordersList" :key="i">

                <v-col cols="2" style="padding: 10px 10px 20px 25px">
                  <v-avatar size="90">
                    <img class="image" :src="service.imageSrc" />
                  </v-avatar>
                </v-col>

                <v-col cols="8" style="padding: 5px 0px">
                  <v-list-item three-line>
                    <v-list-item-content>
                      <v-list-item-title>{{ service.name }}</v-list-item-title>
                      <v-list-item-subtitle>{{
                        service.address
                      }}</v-list-item-subtitle>
                      <v-list-item-subtitle>{{
                        service.description
                      }}</v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>
                </v-col>

                <v-col cols="2" style="padding: 35px 25px">
                  <v-btn icon color="pink" 
                    ><v-icon>mdi-close</v-icon></v-btn
                  >
                </v-col>

              </v-row>
            </slot>
            
          </v-card-text>
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
</template>

<script>

import axios from "axios"

export default {
  data(){
      return{
      selectedOption: "Profile",
      dialog: false,
      username: 'Rana Ayman',
      email: 'ranaayman@gmail.com',
      // date: '6-10-2000',
      oldPassword: '',
      newPassword: '',
      phone: '0100123456789',
      address: 'Alexandria',
      date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      menu1: false,

      snackbar: false,
      message: '',

      userData : {
        ID : 5,
        email : 'mostata@gmail.com',
        password : '123',
        type : '',
        username: '',
        phonenumber : ''
      },

      ordersList: [
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
    // nameRules: [
    //   (v) => v.length <= 10 || "Name must be less than 10 characters",
    // ],
    lastNameRules: [
      (v) => v.length <= 20 || "Name must be less than 20 characters",
    ],
    emailRules: [
      (v) => /.+@.+/.test(v) || "Invalid E-mail",
    ],
    passwordRules: [
      (v) => v.length >= 8 || "Min 8 characters",
    ],
    
      }
      },
  props: ["value"],
  mounted() {
    // request the user data from the database to be showed
    /*
    axios.get("http://localhost:8080/api/returnUser", {})
    .then((Response) => {
      const Data = Response.data
      this.userData = Data
    })
    */
    // request to get the orders of the user from the database 

  },
  methods : {
    reset(){
      this.email = this.userData.email;
      this.phonenumber = this.userData.phonenumber;
    },
    save(){
      // alert(this.date)
      switch(this.userData.type){
        case "admin" :
          this.saveAdmin() ;
          break ;
        case "sp" :
          this.saveProvider();
          break ;
        case "customer" :
          this.saveCustomer();
          break ;
      }
    },
    saveCustomer(){
      
      axios.post("http://localhost:8080/api/updateCustomer", {
        ID : this.userData.ID ,
        email: this.email,
        password: this.userData.password,
        type : this.userData.type ,
        username: this.username,
        phoneNumber: this.phonenumber,
      })
      .then((Response) => {
        const Data = Response.data
        this.message = Data
        this.snackbar = true
      })
    },
    saveProvider(){

      axios.post("http://localhost:8080/api/updateProvider", {
        ID : this.userData.ID ,
        email: this.email,
        password: this.userData.password,
        type : this.userData.type ,
        username: this.username,
        phoneNumber: this.phonenumber,
      })
      .then((Response) => {
        const Data = Response.data
        this.message = Data
        this.snackbar = true
      })
    },
    saveAdmin(){

      axios.post("http://localhost:8080/api/updateAdmin", {
        ID : this.userData.ID ,
        email: this.email,
        password: this.userData.password,
        type : this.userData.type ,
        username: this.username,
        phoneNumber: this.phonenumber,
      })
      .then((Response) => {
        const Data = Response.data
        this.message = Data
        this.snackbar = true
      })
    },
    savePasswordChange(){
      if (this.oldPassword != this.userData.password){
        // window.alert("wrong Password or new password is empty");
        this.message = "wrong Password";
        this.snackbar = true
      }
      else if ( this.newPassword == ''){
        this.message = "New Password cant be empty";
        this.snackbar = true
      }
      else{
        this.userData.password = this.newPassword ;
        this.save();
        //request to change the password 
      }
    },

  },
    computed: {
    computedDateFormatted() {
      return this.formatDate(this.date)
    },
  },

  watch: {
    // eslint-disable-next-line
    date(val) {
      this.dateFormatted = this.formatDate(this.date)
    },
  },
}
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css?family=Roboto:300,400,500");

* {
  margin: 0;
  box-sizing: border-box;
}

html {
  --card-color: #cacaca;
  --text-color: #e1e1e1;
}

body {
  font-family: "Roboto", sans-serif;
}

.tips {
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 30px;
  background: #f1f1f1;
  line-height: 30px;
  font-size: 14px;
  padding: 2px 15px;
}

.container {
  position: absolute;
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: auto;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 680px;

  .col1 {
    perspective: 1000;
    transform-style: preserve-3d;
    margin-right: 200px;
    .card {
      position: relative;
      width: 420px;
      height: 250px;
      margin-top: 60px;
      margin-bottom: 10px;
      margin-right: 10px;
      border-radius: 17px;
      box-shadow: 0 5px 20px -5px rgba(0, 0, 0, 0.1);
      transition: all 1s;
      transform-style: preserve-3d;
      .front {
        position: absolute;
        background: var(--card-color);
        border-radius: 17px;
        padding: 50px;
        width: 100%;
        height: 100%;
        transform: translateZ(1px);
        -webkit-transform: translateZ(1px);
        transition: background 0.3s;
        z-index: 50;
        background-image: repeating-linear-gradient(
            45deg,
            rgba(255, 255, 255, 0) 1px,
            rgba(255, 255, 255, 0.03) 2px,
            rgba(255, 255, 255, 0.04) 3px,
            rgba(255, 255, 255, 0.05) 4px
          ),
          -webkit-linear-gradient(-245deg, rgba(255, 255, 255, 0) 40%, rgba(
                  255,
                  255,
                  255,
                  0.2
                )
                70%, rgba(255, 255, 255, 0) 90%);
        -webkit-backface-visibility: hidden;
        -moz-backface-visibility: hidden;
        -ms-backface-visibility: hidden;
        backface-visibility: hidden;
        .type {
          position: absolute;
          width: 75px;
          height: 45px;
          top: 20px;
          right: 20px;
          img {
            width: 100%;
            float: right;
          }
        }
        .card_number {
          position: absolute;
          font-size: 26px;
          font-weight: 500;
          letter-spacing: -1px;
          top: 110px;
          color: var(--text-color);
          word-spacing: 3px;
          transition: color 0.5s;
        }
        .date {
          position: absolute;
          bottom: 40px;
          right: 55px;
          width: 90px;
          height: 35px;
          color: var(--text-color);
          transition: color 0.5s;
          .date_value {
            font-size: 12px;
            position: absolute;
            margin-left: 22px;
            margin-top: 12px;
            color: var(--text-color);
            font-weight: 500;
            transition: color 0.5s;
          }
          &:after {
            content: "MONTH / YEAR";
            position: absolute;
            display: block;
            font-size: 7px;
            margin-left: 20px;
          }
          &:before {
            content: "valid \a thru";
            position: absolute;
            display: block;
            font-size: 8px;
            white-space: pre;
            margin-top: 8px;
          }
        }
        .fullname {
          position: absolute;
          font-size: 20px;
          bottom: 40px;
          color: var(--text-color);
          transition: color 0.5s;
        }
      }
      .back {
        position: absolute;
        width: 100%;
        border-radius: 17px;
        height: 100%;
        background: var(--card-color);
        transform: rotateY(180deg);
        .magnetic {
          position: absolute;
          width: 100%;
          height: 50px;
          background: rgba(0, 0, 0, 0.7);
          margin-top: 25px;
        }

        .bar {
          position: absolute;
          width: 80%;
          height: 37px;
          background: rgba(255, 255, 255, 0.7);
          left: 10px;
          margin-top: 100px;
        }

        .seccode {
          font-size: 13px;
          color: var(--text-color);
          font-weight: 500;
          position: absolute;
          top: 100px;
          right: 40px;
        }

        .chip {
          bottom: 45px;
          left: 10px;
        }

        .disclaimer {
          position: absolute;
          width: 65%;
          left: 80px;
          color: #f1f1f1;
          font-size: 8px;
          bottom: 55px;
        }
      }
    }
  }

  .col2 {
    input {
      display: block;
      width: 260px;
      height: 30px;
      padding-left: 10px;
      padding-top: 3px;
      padding-bottom: 3px;
      margin: 7px;
      font-size: 17px;
      border-radius: 20px;
      background: rgba(0, 0, 0, 0.05);
      border: none;
      transition: background 0.5s;
      &:focus {
        outline-width: 0;
        background: rgba(31, 134, 252, 0.15);
        transition: background 0.5s;
      }
    }

    label {
      padding-left: 8px;
      font-size: 15px;
      color: #444;
    }

    .ccv {
      width: 100%;
    }

    .buy {
      width: 260px;
      height: 40px;
      position: relative;
      display: block;
      margin: 20px auto;
      border-radius: 10px;
      border: none;
      background: #fabeba;
      color: white;
      font-size: 20px;
      transition: background 0.4s;
      cursor: pointer;
      i {
        font-size: 20px;
      }
      &:hover {
        background: #ff857f;
        transition: background 0.4s;
      }
    }
  }
}

.chip {
  position: absolute;
  width: 55px;
  height: 40px;
  background: #bbb;
  border-radius: 7px;
  &:after {
    content: "";
    display: block;
    width: 35px;
    height: 25px;
    border-radius: 4px;
    position: absolute;
    top: 0;
    bottom: 0;
    margin: auto;
    background: #ddd;
  }
}
.btnProfile {
  width: 10px;
}
.span {
  font-weight: bold;
  position: absolute;
  margin: 0px 40px 0px 60px;
  left: 100%;
}
.serviceTitles {
  padding: 15px 15px;
}
$borderRadius: 10px;
$spacer: 1rem;
$primary: #ffcfcc;
$text: #6a778e;
$linkHeight: $spacer * 3.5;
$timing: 250ms;
$transition: $timing ease all;
.navbar {
  $ref: &;
  position: fixed;
  top: $spacer;
  left: $spacer;
  background: var(--projects-section);
  margin-top: 13%;
  margin-left: 2%;
  border-radius: 32px;
  padding: 0;
  box-shadow: 0 0 40px rgba(0, 0, 0, 0.03);
  width: 90px;

  &__link {
    position: relative;
    display: flex;
    align-items: flex-start;
    justify-content: center;
    height: $linkHeight;
    width: $spacer * 5.5;
    color: $text;
    transition: $transition;

    &:hover {
      color: #fff;
      span {
        opacity: 3;
        transform: translate(2);
      }
    }
  }
  &__menu {
    position: relative;
  }
  &__item {
    &:last-child {
      &:before {
        content: "";
        position: absolute;
        opacity: 0;
        z-index: -1;
        top: 0;
        left: $spacer;
        width: $linkHeight;
        height: $linkHeight;
        background: $primary;
        border-radius: $borderRadius * 1.75;
        transition: $timing cubic-bezier(1, 0.2, 0.1, 1.2) all;
      }
    }
  }
}
.button:hover span {
  color: #6a778e;
}
</style>
