<template>
  <v-content>
    <v-app-bar app class="px-1 app-name" color="white" elevate-on-scroll>
      <slot class="logocontainer">
        <img
          src="../assets/images/rings.png"
          style="width: 3%"
          @click="() => $router.push('/#Home')"
        />
      </slot>
      <v-toolbar-title style="margin-left: 20px">
        Wedding Planner
      </v-toolbar-title>
      <v-spacer />
      <v-list class="d-flex align-center">
        <v-list-item
          link
          v-for="(menu, index) in menus"
          :key="index"
          :to="menu.route"
        >
          <v-list-item-title>{{ menu.title }} </v-list-item-title>
        </v-list-item>
      </v-list>
      <v-spacer />
      <v-list right style="padding-left: 20px">
        <v-btn
          bold
          dark
          style="margin-left: 20px"
          rounded
          color="#FF4F5A"
          @click="() => $router.push('/Registration')"
          >Registration</v-btn
        >
      </v-list>
    </v-app-bar>
    <v-form>
      <v-container id="container">
        <v-row
          style="margin: 0px 0px 100px 0px"
          align="center"
          justify="center"
        >
          <v-col cols="12" sm="10">
            <v-card class="elevation-6 mt-10">
              <v-window v-model="step">
                <v-window-item :value="1">
                  <v-row>
                    <v-col cols="12" md="6">
                      <v-card-text class="mt-12">
                        <h4 class="text-center bold">
                          Login in to Your Account
                        </h4>
                        <v-row align="center" justify="center">
                          <v-col cols="12" sm="8">
                            <v-text-field
                              v-model="EmailAddress"
                              label="Email"
                              :rules="emailRules"
                              outlined
                              dense
                              color="#FF4F5A"
                              autocomplete="false"
                              class="mt-16"
                            />
                            <v-text-field
                              v-model="password"
                              label="Password"
                              outlined
                              dense
                              color="#FF4F5A"
                              autocomplete="false"
                              type="password"
                            />
                            <v-row>
                              <v-col cols="12" sm="7">
                                <v-checkbox
                                  label="Remember Me"
                                  class="mt-n1"
                                  color="#FF4F5A"
                                >
                                </v-checkbox>
                              </v-col>
                              <v-col cols="12" sm="5">
                                <span class="caption">Forgot password</span>
                              </v-col>
                            </v-row>

                            <!-- here is the login button-->
                            <v-btn
                              class="bold"
                              color="#FF4F5A"
                              dark
                              block
                              tile
                              @click="checkLogin"
                              >Login</v-btn
                            >

                            <h5 class="text-center grey--text mt-4 mb-3">
                              Or Log in using
                            </h5>
                            <div
                              class="d-flex justify-space-between align-center mx-10 mb-16"
                            >
                              <v-btn depressed outlined color="grey">
                                <v-icon color="red">fab fa-google</v-icon>
                              </v-btn>
                              <v-btn depressed outlined color="grey">
                                <v-icon color="blue">fab fa-facebook-f</v-icon>
                              </v-btn>
                              <v-btn depressed outlined color="grey">
                                <v-icon color="light-blue lighten-3"
                                  >fab fa-twitter</v-icon
                                >
                              </v-btn>
                            </div>
                          </v-col>
                        </v-row>
                      </v-card-text>
                    </v-col>
                    <v-col
                      cols="12"
                      md="6"
                      class="rounded-bl-xl"
                      style="background-color: #ff4f5a"
                    >
                      <div style="text-align: center; padding: 180px 0">
                        <v-card-text class="white--text">
                          <h3 class="text-center bold">
                            Don't Have an Account Yet?
                          </h3>
                          <h6 class="text-center">
                            Let's get you all set up so you can start creating
                            your account
                          </h6>
                        </v-card-text>
                        <div class="text-center">
                          <v-btn class="bold" tile outlined dark @click="step++"
                            >SIGN UP</v-btn
                          >
                        </div>
                      </div>
                    </v-col>
                  </v-row>
                </v-window-item>
                <v-window-item :value="2">
                  <v-row>
                    <v-col
                      cols="12"
                      md="6"
                      class="rounded-br-xl"
                      style="background-color: #ff4f5a"
                    >
                      <div style="text-align: center; padding: 180px 0">
                        <v-card-text class="white--text">
                          <h3 class="text-center bold">Alredy Signed up?</h3>
                          <h6 class="text-center">Log in to your account</h6>
                        </v-card-text>
                        <div class="text-center bold">
                          <v-btn class="bold" tile outlined dark @click="step--"
                            >Login</v-btn
                          >
                        </div>
                      </div>
                    </v-col>

                    <v-col cols="12" md="6">
                      <v-card-text class="mt-12">
                        <h4 class="text-center bold">Sign Up for an Account</h4>
                        <v-row align="center" justify="center">
                          <v-col cols="12" sm="8">
                            <v-row>
                              <v-col cols="12" sm="6">
                                <v-text-field
                                  v-model="FirstName"
                                  label="First Name"
                                  :rules="nameRules"
                                  outlined
                                  dense
                                  color="#FF4F5A"
                                  autocomplete="false"
                                  class="mt-4"
                                />
                              </v-col>
                              <v-col cols="12" sm="6">
                                <v-text-field
                                  v-model="LastName"
                                  label="Last Name"
                                  :rules="lastNameRules"
                                  outlined
                                  dense
                                  color="#FF4F5A"
                                  autocomplete="false"
                                  class="mt-4"
                                />
                              </v-col>
                            </v-row>
                            <v-text-field
                              v-model="EmailAddress"
                              label="Email"
                              :rules="emailRules"
                              outlined
                              dense
                              color="#FF4F5A"
                              autocomplete="false"
                            />
                            <v-text-field
                              v-model="password"
                              label="Password"
                              :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                              :rules="[
                                passwordRules.required,
                                passwordRules.min,
                              ]"
                              :type="show ? 'text' : 'password'"
                              outlined
                              dense
                              color="#FF4F5A"
                              autocomplete="false"
                              hint="At least 8 characters"
                              @click:append="show = !show"
                            />

                            <v-text-field
                              v-model="rePassword"
                              label="Confirm Password"
                              :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
                              :rules="[
                                passwordRules.required,
                                passwordConfirmationRule,
                              ]"
                              :type="show2 ? 'text' : 'password'"
                              outlined
                              dense
                              color="#FF4F5A"
                              autocomplete="false"
                              hint="At least 8 characters"
                              @click:append="show2 = !show2"
                            />

                            <v-select
                              :items="userTypes"
                              label="make an account as"
                              v-model="userType"
                              color="#FF4F5A"
                            ></v-select>

                            <v-row>
                              <v-col cols="12" sm="7">
                                <v-checkbox
                                  label="I Accept Condition"
                                  class="mt-n1"
                                  color="#FF4F5A"
                                >
                                </v-checkbox>
                              </v-col>
                              <v-col cols="12" sm="5">
                                <span class="caption ml-n4"
                                  >Terms &Conditions</span
                                >
                              </v-col>
                            </v-row>

                            <!-- here is the sing-up button-->
                            <v-btn
                              class="bold"
                              color="#FF4F5A"
                              dark
                              block
                              tile
                              @click="signUp"
                              >Sign up</v-btn
                            >

                            <h5 class="text-center grey--text mt-4 mb-3">
                              Or Sign up using
                            </h5>
                            <div
                              class="d-flex justify-space-between align-center mx-10 mb-11"
                            >
                              <v-btn depressed outlined color="grey">
                                <v-icon color="red">fab fa-google</v-icon>
                              </v-btn>
                              <v-btn depressed outlined color="grey">
                                <v-icon color="blue">fab fa-facebook-f</v-icon>
                              </v-btn>
                              <v-btn depressed outlined color="grey">
                                <v-icon color="light-blue lighten-3"
                                  >fab fa-twitter</v-icon
                                >
                              </v-btn>
                            </div>
                          </v-col>
                        </v-row>
                      </v-card-text>
                    </v-col>
                  </v-row>
                </v-window-item>
              </v-window>
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
      </v-container>
    </v-form>
  </v-content>
</template>

<script>
// import Header from "./common/Header";
import axios from "axios"

export default {
  data: () => ({
    components: {
      // Header,
    },
    menus: [
      { title: "Home", route: "/#Home" },
      { title: "About Us", route: "/#AboutUs" },
      { title: "Gallery", route: "/#Gallery" },
      { title: "Contact Us", route: "/#ContactUs" },
    ],
    step: 1,
    userTypes: ["Customer", "Service Provider"],
    FirstName: "",
    LastName: "",
    EmailAddress: "",
    password: "",
    userType: "",
    rePassword: "",
    show: false,
    show2: false,
    snackbar: false,
    message: "",

    nameRules: [
      (v) => !!v || "Required",
      (v) => v.length <= 10 || "Name must be less than 10 characters",
    ],
    lastNameRules: [
      (v) => !!v || "Required",
      (v) => v.length <= 20 || "Name must be less than 20 characters",
    ],
    emailRules: [
      (v) => !!v || "Required",
      (v) => /.+@.+/.test(v) || "E-mail must be valid",
    ],
    passwordRules: {
      required: (value) => !!value || "Required",
      min: (v) => v.length >= 8 || "Min 8 characters",
    },
  }),
  props: {
    source: String,
  },
  computed: {
    passwordConfirmationRule() {
      return () =>
        this.password === this.rePassword || "Password you entered don't match"
    },
  },
  methods: {
    //login request
    checkLogin: function () {
      axios
        .get("http://localhost:8080/api/login", {
          params: {
            email: this.EmailAddress,
            password: this.password,
          },
        })
        .then((Response) => {
          const Data = Response.data
          if (Data == -1) this.message = "not a correct login input"
          else {
            this.message = "correct login input"
            this.$router.push("/dashboard")
          }
          this.snackbar = true
        })
    },

    //sign-up request
    signUp: function () {
      if (this.userType == "Customer") {
        axios
          .post("http://localhost:8080/api/signUpCustomer", {
            username: this.FirstName + " " + this.LastName,
            email: this.EmailAddress,
            password: this.password,
            phoneNumber: "",
          })
          .then((Response) => {
            const Data = Response.data
            this.message = Data
            this.snackbar = true
          })
      } else {
        axios
          .post("http://localhost:8080/api/signUpProvider", {
            username: this.FirstName + " " + this.LastName,
            email: this.EmailAddress,
            password: this.password,
            phoneNumber: "",
          })
          .then((Response) => {
            const Data = Response.data
            this.message = Data
            this.snackbar = true
          })
      }
    },
  },
}
</script>

<style>
.bold {
  font-weight: bold;
}
.v-application .rounded-bl-xl {
  border-bottom-left-radius: 300px !important;
}
.v-application .rounded-br-xl {
  border-bottom-right-radius: 300px !important;
}
.btn-dimensions {
  min-height: 25px;
  max-width: 200px;
}
.v-text-field--outlined.v-input--dense.v-text-field--outlined
  > .v-input__control
  > .v-input__slot,
.v-text-field--outlined.v-input--dense.v-text-field--outlined.v-text-field--filled
  > .v-input__control
  > .v-input__slot {
  min-height: 20px;
  max-width: 250px !important;
}
</style>
