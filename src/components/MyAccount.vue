<template>
  <v-dialog max-width="1100px" :value="value" @input="$emit('input')">
    <v-row no-gutters style="overflow-x: hidden">
      <!-- image cornter -->
      <v-col cols="3">
        <v-card tile class="rounded-tr rounded-td" height="700">
          <v-card-title>
            <v-row>
              <v-col
                align="center"
                justify="center"
                style="padding: 10px 10px 0px 15px"
              >
                <v-avatar size="70">
                  <img src="..\assets\images\team2.jpg" />
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
              <v-list-item>
                <v-btn
                  rounded
                  style="width: 100%"
                  class="mt-4"
                  :color="selectedOption == 'Payment' ? '#FF4F5A' : ''"
                  @click="selectedOption = 'Payment'"
                  >Payment</v-btn
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
        <v-card tile class="rounded-tr rounded-td" height="700">
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
                      v-model="firstName"
                      label="First Name"
                      dense
                      :rules="nameRules"
                      :readonly="editUserInfo == false"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                  <v-col>
                    <v-text-field
                      v-model="lastName"
                      label="Last Name"
                      :rules="lastNameRules"
                      dense
                      :readonly="editUserInfo == false"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <v-text-field
                      v-model="email"
                      label="Email"
                      :rules="emailRules"
                      dense
                      :readonly="editUserInfo == false"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                  <!-- <v-col>
                    <v-text-field
                      v-model="date"
                      label="Birth-date"
                      dense
                      readonly
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col> -->
                  <v-col cols="12" lg="6">
                    <v-menu
                      ref="menu1"
                      v-model="menu1"
                      :close-on-content-click="false"
                      transition="scale-transition"
                      offset-y
                      max-width="290px"
                      min-width="auto"
                    >
                      <template v-slot:activator="{ on, attrs }">
                        <v-text-field
                          v-model="dateFormatted"
                          label="Birth-date"
                          hint="MM/DD/YYYY format"
                          persistent-hint
                          color="#FF4F5A"
                          prepend-icon="mdi-calendar"
                          v-bind="attrs"
                          readonly
                          dense
                          @blur="date = parseDate(dateFormatted)"
                          v-on="editUserInfo? on : off"
                        ></v-text-field>
                      </template>
                      <v-date-picker
                        v-model="date"
                        no-title
                        @input="menu1 = false"
                      ></v-date-picker>
                    </v-menu>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col> </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark text style="margin-left: 60px" @click="editUserInfo=true">
                      Edit
                    </v-btn>
                  </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark style="margin-left: 40px" @click="saveUserInfo">
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
                      :rules="oldPassRules"
                      dense
                      :readonly="editPassword == false"
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
                      :readonly="editPassword == false"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col> </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark text style="margin-left: 60px" @click="editPassword=true">
                      Edit
                    </v-btn>
                  </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark style="margin-left: 40px" @click="savePassword">
                      Save
                    </v-btn>
                  </v-col>
                </v-row>
                <v-divider></v-divider>

                <v-row style="margin-top: 20px">
                  <h3 class="mb-7">Contact information</h3>
                </v-row>
                <v-row>
                  <v-col>
                    <v-text-field
                      v-model="phone"
                      label="Phone"
                      dense
                      :readonly="editContactInfo==false"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                  <v-col>
                    <v-text-field
                      v-model="address"
                      label="Address"
                      dense
                      :readonly="editContactInfo==false"
                      color="#FF4F5A"
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col> </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark text style="margin-left: 60px" @click="editContactInfo=true">
                      Edit
                    </v-btn>
                  </v-col>
                  <v-col lg="2" md="2" sm="3" xs="4">
                    <v-btn color="#ff616b" dark style="margin-left: 40px" @click="saveContactInfo">
                      Save
                    </v-btn>
                  </v-col>
                </v-row>
              </v-col>
            </slot>
            <slot v-if="selectedOption == 'Orders'">
              <i>Orders -- TO DO</i>
            </slot>
            <slot v-if="selectedOption == 'Payment'">
              <div class="tips">
                Payment card number: (4) VISA, (51 -> 55) MasterCard, (36-38-39)
                DinersClub, (34-37) American Express, (65) Discover, (5019)
                dankort
              </div>

              <!-- <div class="container">

              </div> -->
                <div class="wrapper" id="app">
                <CardForm
                  :form-data="formData"
                  @input-card-number="updateCardNumber"
                  @input-card-name="updateCardName"
                  @input-card-month="updateCardMonth"
                  @input-card-year="updateCardYear"
                  @input-card-cvv="updateCardCvv"
                />
                <!-- backgroundImage="https://images.unsplash.com/photo-1572336183013-960c3e1a0b54?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80" -->
              </div>
            </slot>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-dialog>
</template>

<script>
// import VueCardFormat from 'vue-credit-card-validation';
// Vue.use(VueCardFormat)
import CardForm from '@/components/CardForm'

export default {
  name: "MyAccount",

  components: {
    // eslint-disable-next-line
    // VueCardFormat,
    CardForm

  },
  // data() {
    // return {
     data:
      vm => ({
      selectedOption: "Profile",
      dialog: false,
      firstName: "Rana",
      lastName: "Ayman",
      email: "ranaayman@gmail.com",
      // date: "6-10-2000",
      oldPassword: "123456789",
      newPassword: "abcdefghi",
      phone: "0100123456789",
      address: "Alexandria",
      date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
      menu1: false,
      editUserInfo:false,
      editPassword:false,
      editContactInfo:false,
      formData: {
        cardName: '',
        cardNumber: '',
        cardMonth: '',
        cardYear: '',
        cardCvv: ''
      },
      
    nameRules: [
      (v) => v.length <= 10 || "Name must be less than 10 characters",
    ],
    lastNameRules: [
      (v) => v.length <= 20 || "Name must be less than 20 characters",
    ],
    emailRules: [
      (v) => /.+@.+/.test(v) || "E-mail must be valid",
    ],
    passwordRules: [
      (v) => v.length >= 8 || "Min 8 characters",
    ],
    }),
    // }
  // },
  props: ["value"],
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
  methods: {
    saveUserInfo(){
      this.editUserInfo=false;
      // alert(this.date)
    },
    savePassword(){
      this.editPassword=false
    },
    saveContactInfo(){
      this.editContactInfo=false
    },
    formatDate(date) {
      if (!date) return null

      const [year, month, day] = date.split("-")
      return `${month}/${day}/${year}`
    },
    parseDate(date) {
      if (!date) return null

      const [month, day, year] = date.split("/")
      return `${year}-${month.padStart(2, "0")}-${day.padStart(2, "0")}`
    },
    
  },
    mounted () {
    this.$i18n.locale = navigator.language
  }
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
