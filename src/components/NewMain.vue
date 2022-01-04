<template>
  <div class="app-container">
    <v-app-bar
      app
      class="px-12"
      style="background-color: var(--app-container)"
      elevate-on-scroll
    >
      <div class="app-header-left">
        <img src="../assets/images/rings.png" style="width: 4%" />
        <p class="app-name" style="margin: 10px 20px">Wedding Planner</p>
        <div class="search-wrapper">
          <input
            class="search-input"
            type="text"
            placeholder="Search"
            v-model="searchKeyword"
          />

          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="20"
            height="20"
            fill="none"
            stroke="currentColor"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            class="feather feather-search"
            viewBox="0 0 24 24"
          >
            <defs></defs>
            <circle cx="11" cy="11" r="8"></circle>
            <path d="M21 21l-4.35-4.35"></path>
          </svg>
        </div>
      </div>

      <div class="app-header-right">
        <cartPage/>
        <button class="mode-switch" title="Switch Theme">
          <svg
            class="moon"
            fill="none"
            stroke="currentColor"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            width="24"
            height="24"
            viewBox="0 0 24 24"
          >
            <defs></defs>
            <path d="M21 12.79A9 9 0 1111.21 3 7 7 0 0021 12.79z"></path>
          </svg>
        </button>
        <button class="profile-btn">
          <img
            src="https://scontent.fcai20-6.fna.fbcdn.net/v/t1.6435-9/60104594_2264725093609458_3750581041635524608_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=-0f2j_VkSxcAX9FtQh5&_nc_ht=scontent.fcai20-6.fna&oh=00_AT9xiFC13iuDIcm51Fpexl2fb76nYu8mHWoKbRRrckAJgQ&oe=61F59BFE"
          />
          <span> </span>
        </button>
        <button
          class="add-btn"
          title="Signout"
          @click="() => $router.push('/#Home')"
        >
          <i class="fas fa-sign-out-alt"></i>
        </button>
      </div>
    </v-app-bar>
    <div class="app-content">
      <nav class="navbar" style="padding: 20px 0px">
        <ul class="navbar__menu">
          <li class="navbar__item">

            <!-- hall button -->
            <a
              class="navbar__link"
              style="margin: 20px 0px"
              @click="
                sidebarOptionSelected = 'Halls'
                disabled = false
              "
              ><i
                ><img
                  src="../assets/images/home.png"
                  style="width: 42%; margin-top: 5px" /></i
              ><span>Halls</span></a
            >
          </li>
          <li class="navbar__item">
            <a
              class="navbar__link"
              style="margin: 20px 0px"
              @click="
                sidebarOptionSelected = 'Photographers'
                disabled = true
              "
              ><i
                ><img src="../assets/images/camera.png" style="width: 42%" /></i
              ><span>Photographers</span></a
            >
          </li>
          <li class="navbar__item">
            <a
              class="navbar__link"
              style="margin: 20px 0px"
              @click="
                sidebarOptionSelected = 'Makeup Artists'
                disabled = true
              "
              ><i
                ><img
                  src="../assets/images/make-up.png"
                  style="width: 42%" /></i
              ><span>MakeUpArtists</span></a
            >
          </li>
          <li class="navbar__item">
            <a class="navbar__link" style="margin: 20px 0px">
              <i
                ><img
                  src="../assets/images/gear.png"
                  style="width: 42%"
                  @click="dialog = true"
                /><MyAccount v-model="dialog" /> </i
              ><span>MyAccount</span></a
            >
          </li>
        </ul>
      </nav>
      <div class="projects-section">
        <v-container class="flex">
          <v-card-title
            class=""
            style="font-size: 3em; color: var(--main-color)"
            >{{ sidebarOptionSelected }}</v-card-title
          >
          <v-row
            style="display: flex; flex-wrap: wrap; margin-top: 20px"
            align="center"
            justify="center"
          >
            <v-col lg="2" md="3" sm="4" xs="4" style="padding-left: 60px">
              <v-combobox
                hide-details
                v-model="inputAddress"
                outlined
                solo
                :items="addresses"
                item-text="title"
                label="Address"
                style="background: var(--main_color)"
              ></v-combobox>
            </v-col>
            <v-col lg="1" md="3" sm="3" xs="4">
              <v-text-field
                v-model="inputPrice"
                hide-details
                label="Price"
                solo
                filled
                outlined
                background-color="var(--app-container)"
              ></v-text-field>
            </v-col>
            <v-col lg="1" md="2" sm="4" xs="4" style="margin-right: 40px">
              <v-rating
                v-model="inputRating"
                color="yellow darken-3"
                background-color="grey darken-1"
                empty-icon="$ratingFull"
                half-increments
                hover
                size="20"
              ></v-rating>
            </v-col>

            <v-col lg="2" md="3" sm="4" xs="4">
              <v-slider
                hide-details
                class="priceSlider"
                id="sliderCapacity"
                :disabled="disabled"
                v-model="inputCapacity"
                :min="200"
                :max="1000"
                :step="100"
                :label="ex3.label"
                :thumb-color="ex3.color"
                :color="ex3.color"
                :track-color="ex3.trackColor"
                thumb-label="always"
              ></v-slider>
            </v-col>
            <v-col lg="2" md="0" sm="0" xs="0"> </v-col>

            <v-col style="flex-grow: 0">
              <v-btn
                tile
                color="red"
                rounded
                style="color: var(--app-container)"
                @click="filter()"
              >
                <v-icon left> mdi-filter </v-icon>
                Filter
              </v-btn>
            </v-col>
            <v-col style="flex-grow: 0">
              <v-btn
                tile
                color="red"
                style="color: var(--app-container)"
                @click="resetFilter()"
              >
                <v-icon left> mdi-close </v-icon>
                Reset
              </v-btn>
            </v-col>
          </v-row>
          <v-divider></v-divider>
        </v-container>
        <v-container class="flex" wrap>
          <v-layout row>
            <!-- ***************************Halls ***********************************-->

            <slot v-if="sidebarOptionSelected == 'Halls'">
              <v-col
                v-for="(item,c) in halls"
                :key="c"
                class="d-flex child-flex"
                cols="12"
                lg="3"
                md="4"
                sm="6"
                xs="12"
              >
                <v-card
                  class="mx-2 my-2"
                  max-width="250"
                  style="background-color: var(--app-container)"
                >
                  <v-img height="150" :src="item.image"></v-img>
                  <v-card-title style="color: var(--main-color)">
                    {{ item.name }}
                  </v-card-title>
                  <v-card-text style="color: var(--main-color)">
                    <v-row align="center" class="mx-0">
                      <v-rating
                        :value="item.rate/2"
                        color="amber"
                        dense
                        half-increments
                        readonly
                        size="14"
                      ></v-rating>
                      <div class="grey--text ms-2">
                        {{ item.rate/2 }}
                      </div>
                    </v-row>
                    <div class="my-2 text-subtitle-1">
                      <i class="fa fa-map-marker" aria-hidden="true"></i>
                      {{ item.location }}
                    </div>
                  </v-card-text>
                  <v-card-actions>
                    
                    <servicePage :service="item" />
                  </v-card-actions>
                </v-card>
              </v-col>
            </slot>

            <!-- ***************************Photographer ***********************************-->

            <slot v-if="sidebarOptionSelected == 'Photographers'">
              <v-col
                v-for="item in photographers"
                :key="item.id"
                class="d-flex child-flex"
                cols="12"
                lg="3"
                md="4"
                sm="6"
                xs="12"
              >
                <v-card
                  class="mx-2 my-2"
                  max-width="250"
                  style="background-color: var(--app-container)"
                >
                  <v-img height="150" :src="item.image"></v-img>
                  <v-card-title style="color: var(--main-color)">
                    {{ item.title }}
                  </v-card-title>
                  <v-card-text style="color: var(--main-color)">
                    <v-row align="center" class="mx-0">
                      <v-rating
                        :value="item.rate"
                        color="amber"
                        dense
                        half-increments
                        readonly
                        size="14"
                      ></v-rating>
                      <div class="grey--text ms-2">
                        {{ item.rate }}
                      </div>
                    </v-row>
                    <div class="my-2 text-subtitle-1">
                      <i class="fa fa-map-marker" aria-hidden="true"></i>
                      {{ item.address }}
                    </div>
                  </v-card-text>
                  <v-card-actions>
                     <servicePage :service="item" /> 
                  </v-card-actions>
                </v-card>
              </v-col>
            </slot>
            <!-- ***************************MakeupArtist***********************************-->

            <slot v-if="sidebarOptionSelected == 'Makeup Artists'">
              <v-col
                v-for="item in makeupArtist"
                :key="item.id"
                class="d-flex child-flex"
                cols="12"
                lg="3"
                md="4"
                sm="6"
                xs="12"
              >
                <v-card
                  class="mx-2 my-2"
                  max-width="250"
                  style="background-color: var(--app-container)"
                >
                  <v-img height="150" :src="item.image"></v-img>
                  <v-card-title style="color: var(--main-color)">
                    {{ item.title }}
                  </v-card-title>
                  <v-card-text style="color: var(--main-color)">
                    <v-row align="center" class="mx-0">
                      <v-rating
                        :value="item.rate"
                        color="amber"
                        dense
                        half-increments
                        readonly
                        size="14"
                      ></v-rating>
                      <div class="grey--text ms-2">
                        {{ item.rate }}
                      </div>
                    </v-row>
                    <div class="my-2 text-subtitle-1">
                      <i class="fa fa-map-marker" aria-hidden="true"></i>
                      {{ item.address }}
                    </div>
                  </v-card-text>
                  <v-card-actions>
                    <servicePage :service="item" />
                  </v-card-actions>
                </v-card>
              </v-col>
            </slot>
          </v-layout>
        </v-container>
      </div>
    </div>
  </div>
</template>

<script>
// eslint-disable-next-line
import MyAccount from "./MyAccount.vue"
import servicePage from "./servicePage.vue"
import cartPage from "./cartPage.vue"

import axios from "axios"

export default {
  name: "NewMain",

  components: {
    servicePage,
    // eslint-disable-next-line
    MyAccount,
    // eslint-disable-next-line
    cartPage
  },
  data() {
    return {
      coco : "" ,
      searchKeyword: "",
      inputPrice: "",
      inputAddress: "",
      inputRating: "",
      inputCapacity: "600",
      disabled: false,
      sidebarOptionSelected: "Halls",
      dialog: false,
      dialog1: false,
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
      ex3: {
        label: "Capacity",
        val: 1000,
        color: "red",
        trackColor: "#F1D3D7",
      },
      drawer: true,
      ite: [
        { title: "Home", icon: "mdi-home-city" },
        { title: "My Account", icon: "mdi-account" },
        { title: "Users", icon: "mdi-account-group-outline" },
      ],
      mini: true,

      addresses: [
        { title: "Loran" },
        { title: "Gleem" },
        { title: "Sporting" },
      ],
      halls: [
        {
          id: 0,
          title: "Sample 1",
          image: require("../assets/images/hall1.png"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 1,
          title: "Sample 2",
          image: require("../assets/images/hall2.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 2,
          title: "Sample 3",
          image: require("../assets/images/hall3.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 3,
          title: "Sample 4",
          image: require("../assets/images/hall4.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 4,
          title: "Sample 5",
          image: require("../assets/images/hall5.png"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 5,
          title: "Sample 6",
          image: require("../assets/images/hall6.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 6,
          title: "Sample 7",
          image: require("../assets/images/hall7.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 7,
          title: "Sample 8",
          image: require("../assets/images/hall8.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 8,
          title: "Sample 9",
          image: require("../assets/images/hall9.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
      ],
      photographers: [
        {
          id: 0,
          title: "Photographer 1",
          image: require("../assets/images/p1.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 1,
          title: "Photographer 2",
          image: require("../assets/images/p2.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 2,
          title: "Photographer 3",
          image: require("../assets/images/p4.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 3,
          title: "Photographer 4",
          image: require("../assets/images/p5.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 4,
          title: "Photographer 5",
          image: require("../assets/images/p6.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 5,
          title: "Photographer 6",
          image: require("../assets/images/p7.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 6,
          title: "Photographer 7",
          image: require("../assets/images/p8.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 7,
          title: "Photographer 8",
          image: require("../assets/images/p9.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 8,
          title: "Photographer 9",
          image: require("../assets/images/p3.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
      ],
      makeupArtist: [
        {
          id: 0,
          title: "Makeup Artist 1",
          image: require("../assets/images/m1.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 1,
          title: "Makeup Artist 2",
          image: require("../assets/images/m2.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 2,
          title: "Makeup Artist 3",
          image: require("../assets/images/m3.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 3,
          title: "Makeup Artist 4",
          image: require("../assets/images/m4.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 4,
          title: "Makeup Artist 5",
          image: require("../assets/images/m5.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 5,
          title: "Makeup Artist 6",
          image: require("../assets/images/m6.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 6,
          title: "Makeup Artist 7",
          image: require("../assets/images/m7.png"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 7,
          title: "Makeup Artist 8",
          image: require("../assets/images/m8.jpg"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
        {
          id: 8,
          title: "Makeup Artist 9",
          image: require("../assets/images/m9.png"),
          rate: 4.5,
          address: "Address, Alexandria",
        },
      ],
    }
  },
  methods: {
    changeClass: function (id) {
      var element = document.getElementById(id)
      element.classList.add("app-sidebar-link active")
    },

    filter: function () {
      // window.alert(
      //   this.inputAddress.title +
      //     " , " +
      //     this.inputPrice +
      //     " , " +
      //     this.inputRating +
      //     " , " +
      //     this.inputCapacity +
      //     " , " +
      //     this.searchKeyword
      // )
      var arr = [{
                  "columnName":"location",
                  "val":this.inputAddress.title,
                }
                ,
                {
                    "columnName":"cost",
                    "val":"0," + this.inputPrice,
                }
                ,
                {
                    "columnName":"rate",
                    "val":"0," + this.inputRating,
                }
                ,
                {
                    "columnName":"capacity",
                    "val":"0," + this.inputCapacity,
                }
      ];

      window.alert(JSON.stringify(arr));
      document.write(JSON.stringify(arr));

    },
    resetFilter: function () {},
    
  },
  mounted: function () {
    var modeSwitch = document.querySelector(".mode-switch")
    modeSwitch.addEventListener("click", function () {
      document.documentElement.classList.toggle("dark")
      modeSwitch.classList.toggle("active")
    })

    axios.post("http://localhost:8080/api/setPlacePage",[]
    ).then(() => {})

    axios.get("http://localhost:8080/api/getPlacePage",{
      params: {
        pageNumber: 1,
      },
    }).then((Response) => {
      const Data = Response.data
      this.halls = Data ;
    })
    
  },
}
</script>
<style lang="scss">
@import url("https://fonts.googleapis.com/css?family=DM+Sans:400,500,700&display=swap");

* {
  box-sizing: border-box;
}

:root {
  --app-container: #fff;
  --main-color: #1f1c2e;
  --secondary-color: #4a4a4a;
  --link-color: #1f1c2e;
  --link-color-hover: #f1d3d7;
  --link-color-active: #fff;
  --link-color-active-bg: #e2e2e2;
  --projects-section: #f5f5f5;
  --more-list-bg: #fff;
  --more-list-bg-hover: #f6fbff;
  --more-list-shadow: rgba(209, 209, 209, 0.4);
  --button-bg: #1f1c24;
  --search-area-bg: #fff;
  --star: #1ff1c2e;
}

.dark:root {
  --app-container: #1f1d2b;
  --app-container: #111827;
  --main-color: #fff;
  --secondary-color: rgba(255, 255, 255, 0.8);
  --projects-section: #1f2937;
  --link-color: rgba(255, 255, 255, 0.8);
  --link-color-hover: rgba(195, 207, 244, 0.1);
  --link-color-active-bg: rgba(195, 207, 244, 0.2);
  --button-bg: #1f2937;
  --search-area-bg: #1f2937;
  --star: #ffd92c;
  --light-font: rgba(255, 255, 255, 0.8);
  --more-list-bg: #2f3142;
  --more-list-bg-hover: rgba(195, 207, 244, 0.1);
  --more-list-shadow: rgba(195, 207, 244, 0.1);
}
.theme--light.v-application {
  background: var(--app-container) !important;
}
html,
body {
  width: 100%;
  height: 100vh;
  margin: 0;
  background-color: var(--app-container);
}

body {
  font-family: "DM Sans", sans-serif;
}

button,
a {
  cursor: pointer;
}
ul {
  list-style: none;
}

.app {
  &-container {
    width: 100%;
    display: flex;
    flex-direction: column;
    height: 100%;
    background-color: var(--app-container);
    transition: 0.2s;
    max-width: 1800px;

    button,
    input,
    optgroup,
    select,
    textarea {
      font-family: "DM Sans", sans-serif;
    }
  }

  &-content {
    display: flex;
    height: 100%;
    overflow: hidden;
    padding: 16px 24px 24px 0;
  }

  &-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    padding: 16px 24px;
    position: relative;

    &-left,
    &-right {
      display: flex;
      align-items: center;
    }

    &-left {
      flex-grow: 1;
    }

    &-right button {
      margin-left: 10px;
    }
  }

  &-icon {
    width: 26px;
    height: 2px;
    border-radius: 4px;
    background-color: var(--main-color);
    position: relative;

    &:before,
    &:after {
      content: "";
      position: absolute;
      width: 12px;
      height: 2px;
      border-radius: 4px;
      background-color: var(--main-color);
      left: 50%;
      transform: translatex(-50%);
    }

    &:before {
      top: -6px;
    }
    &:after {
      bottom: -6px;
    }
  }

  &-name {
    color: var(--main-color);
    margin: 0;
    font-size: 20px;
    line-height: 24px;
    font-weight: 700;
    margin: 0 32px;
  }
}

.mode-switch {
  background-color: transparent;
  border: none;
  padding: 0;
  color: var(--main-color);
  display: flex;
  justify-content: center;
  align-items: center;
}
.cart {
  background-color: transparent;
  border: none;
  padding: 0;
  color: var(--main-color);
  display: flex;
  justify-content: center;
  align-items: center;
}

.search-wrapper {
  border-radius: 20px;
  background-color: var(--search-area-bg);
  padding-right: 12px;
  height: 40px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  max-width: 480px;
  color: var(--light-font);
  box-shadow: 0 2px 6px 0 rgba(136, 148, 171, 0.2),
    0 24px 20px -24px rgba(71, 82, 107, 0.1);
  overflow: hidden;

  .dark & {
    box-shadow: none;
  }
}

.search-input {
  border: none;
  flex: 1;
  outline: none;
  height: 100%;
  padding: 0 20px;
  font-size: 16px;
  background-color: var(--search-area-bg);
  color: var(--main-color);

  &:placeholder {
    color: var(--main-color);
    opacity: 0.6;
  }
}

.add-btn {
  color: #fff;
  background-color: var(--button-bg);
  padding: 0;
  border: 0;
  border-radius: 50%;
  width: 32px;
  height: 32px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.notification-btn {
  color: var(--main-color);
  padding: 0;
  border: 0;
  background-color: transparent;
  height: 32px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.profile-btn {
  padding: 0;
  border: 0;
  background-color: transparent;
  display: flex;
  align-items: center;
  padding-left: 12px;
  border-left: 2px solid #ddd;

  img {
    width: 32px;
    height: 32px;
    object-fit: cover;
    border-radius: 50%;
    margin-right: 4px;
  }

  span {
    color: var(--main-color);
    font-size: 16px;
    line-height: 24px;
    font-weight: 700;
  }
}

.page-content {
  flex: 1;
  width: 100%;
}
.sideHover {
  margin-top: 40px;
  display: flex;
  flex-direction: column;
  position: fixed;
  height: 100%;
  justify-content: center;

  &-link {
    display: flex;
    justify-content: center;
    align-items: center;
  }
}

.app-sidebar {
  padding: 40px 16px;
  display: flex;
  flex-direction: column;
  position: fixed;
  margin-left: 2em;
  height: 100%;
  justify-content: center;

  &-link {
    color: var(--main-color);
    color: var(--link-color);
    margin: 16px 0;
    transition: 0.2s;
    border-radius: 20%;
    flex-shrink: 0;
    width: 40px;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;

    &:hover {
      background-color: var(--link-color-hover);
      color: var(--link-color-active);
    }

    &.active {
      background-color: var(--link-color-active-bg);
      color: var(--link-color-active);
    }
  }
}

.projects-section {
  flex: 2;
  background-color: var(--projects-section);
  border-radius: 32px;
  padding: 0px 0px 0 0px;
  overflow-x: auto;
  height: 100%;
  width: 100%;
  flex-direction: column;
  margin-left: 15em;
  margin-top: 5em;

  &-line {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 32px;
  }

  &-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 24px;
    color: var(--main-color);

    p {
      font-size: 24px;
      line-height: 32px;
      font-weight: 700;
      opacity: 0.9;
      margin: 0;
      color: var(--main-color);
    }

    .time {
      font-size: 20px;
    }
  }
}

.projects-status {
  display: flex;
}

.item-status {
  display: flex;
  flex-direction: column;
  margin-right: 0px;

  &:not(:last-child) .status-type:after {
    content: "";
    position: absolute;
    right: 8px;
    top: 50%;
    transform: translatey(-50%);
    width: 6px;
    height: 6px;
    border-radius: 50%;
    border: 1px solid var(--secondary-color);
  }
}

.status-number {
  font-size: 24px;
  line-height: 32px;
  font-weight: 700;
  color: var(--main-color);
}

.status-type {
  position: relative;
  padding-right: 24px;
  color: var(--secondary-color);
}

.view-actions {
  display: flex;
  align-items: center;
}

.view-btn {
  width: 36px;
  height: 36px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 6px;
  border-radius: 4px;
  background-color: transparent;
  border: none;
  color: var(--main-color);
  margin-left: 8px;
  transition: 0.2s;

  &.active {
    background-color: var(--link-color-active-bg);
    color: var(--link-color-active);
  }

  &:not(.active):hover {
    background-color: var(--link-color-hover);
    color: var(--link-color-active);
  }
}

.star-checkbox {
  input {
    opacity: 0;
    position: absolute;
    width: 0;
    height: 0;
  }

  label {
    width: 24px;
    height: 24px;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
  }

  .dark & {
    color: var(--secondary-color);

    input:checked + label {
      color: var(--star);
    }
  }

  input:checked + label svg {
    fill: var(--star);
    transition: 0.2s;
  }
}

.project-boxes {
  margin: 0 -8px;
  overflow-y: auto;

  &.jsGridView {
    display: flex;
    flex-wrap: wrap;

    .project-box-wrapper {
      width: 33.3%;
    }
  }

  &.jsListView {
    .project-box {
      display: flex;
      border-radius: 10px;
      position: relative;
      > * {
        margin-right: 24px;
      }
    }

    .more-wrapper {
      position: absolute;
      right: 16px;
      top: 16px;
    }

    .project-box-content-header {
      order: 1;
      max-width: 120px;
    }

    .project-box-header {
      order: 2;
    }

    .project-box-footer {
      order: 3;
      padding-top: 0;
      flex-direction: column;
      justify-content: flex-start;
    }

    .project-box-footer:after {
      display: none;
    }

    .participants {
      margin-bottom: 8px;
    }

    .project-box-content-header p {
      text-align: left;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }

    .project-box-header > span {
      position: absolute;
      bottom: 16px;
      left: 16px;
      font-size: 12px;
    }

    .box-progress-wrapper {
      order: 3;
      flex: 1;
    }
  }
}

.project-box {
  --main-color-card: #dbf6fd;
  border-radius: 30px;
  padding: 16px;
  background-color: var(--main-color-card);

  &-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 16px;
    color: var(--main-color);

    span {
      color: #4a4a4a;
      opacity: 0.7;
      font-size: 14px;
      line-height: 16px;
    }
  }

  &-content-header {
    text-align: center;
    margin-bottom: 16px;

    p {
      margin: 0;
    }
  }

  &-wrapper {
    padding: 8px;
    transition: 0.2s;
  }
}

.project-btn-more {
  padding: 0;
  height: 14px;
  width: 24px;
  height: 24px;
  position: relative;
  background-color: transparent;
  border: none;
  flex-shrink: 0;

  /*&:after, &:before {
    content: '';
    position: absolute;
    width: 6px;
    height: 6px;
    border-radius: 50%;
    background-color: var(--main-color);
    opacity: .8;
    left: 50%;
    transform: translatex(-50%);
  }
  
  &:before { top: 0;}
  &:after { bottom: 0; }*/
}

.more-wrapper {
  position: relative;
}

.box-content-header {
  font-size: 16px;
  line-height: 24px;
  font-weight: 700;
  opacity: 0.7;
}

.box-content-subheader {
  font-size: 14px;
  line-height: 24px;
  opacity: 0.7;
}

.box-progress {
  display: block;
  height: 4px;
  border-radius: 6px;

  &-bar {
    width: 100%;
    height: 4px;
    border-radius: 6px;
    overflow: hidden;
    background-color: #fff;
    margin: 8px 0;
  }

  &-header {
    font-size: 14px;
    font-weight: 700;
    line-height: 16px;
    margin: 0;
  }

  &-percentage {
    text-align: right;
    margin: 0;
    font-size: 14px;
    font-weight: 700;
    line-height: 16px;
  }
}

.project-box-footer {
  display: flex;
  justify-content: space-between;
  padding-top: 16px;
  position: relative;

  &:after {
    content: "";
    position: absolute;
    background-color: rgba(255, 255, 255, 0.6);
    width: calc(100% + 32px);
    top: 0;
    left: -16px;
    height: 1px;
  }
}

.participants {
  display: flex;
  align-items: center;

  img {
    width: 20px;
    height: 20px;
    border-radius: 50%;
    overflow: hidden;
    object-fit: cover;

    &:not(:first-child) {
      margin-left: -8px;
    }
  }
}

.add-participant {
  width: 20px;
  height: 20px;
  border-radius: 50%;
  border: none;
  background-color: rgba(255, 255, 255, 0.6);
  margin-left: 6px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0;
}

.days-left {
  background-color: rgba(255, 255, 255, 0.6);
  font-size: 12px;
  border-radius: 20px;
  flex-shrink: 0;
  padding: 6px 16px;
  font-weight: 700;
}

.mode-switch.active .moon {
  fill: var(--main-color);
}

@media screen and (max-width: 980px) {
  .project-boxes.jsGridView .project-box-wrapper {
    width: 50%;
  }

  .status-number,
  .status-type {
    font-size: 14px;
  }

  .status-type:after {
    width: 4px;
    height: 4px;
  }

  .item-status {
    margin-right: 0;
  }
}

@media screen and (max-width: 720px) {
  .app-name,
  .profile-btn span {
    display: none;
  }

  .add-btn,
  .notification-btn,
  .mode-switch {
    width: 20px;
    height: 20px;

    svg {
      width: 16px;
      height: 16px;
    }
  }

  .app-header-right button {
    margin-left: 4px;
  }
}

@media screen and (max-width: 520px) {
  .projects-section {
    overflow: auto;
  }
  .project-boxes {
    overflow-y: visible;
  }

  .app-sidebar,
  .app-icon {
    display: none;
  }

  .app-content {
    padding: 16px 12px 24px 12px;
  }

  .status-number,
  .status-type {
    font-size: 10px;
  }

  .view-btn {
    width: 24px;
    height: 24px;
  }

  .app-header {
    padding: 16px 10px;
  }

  .search-input {
    max-width: 120px;
  }

  .project-boxes.jsGridView .project-box-wrapper {
    width: 100%;
  }

  .projects-section {
    padding: 24px 16px 0 16px;
  }

  .profile-btn img {
    width: 24px;
    height: 24px;
  }

  .app-header {
    padding: 10px;
  }

  .projects-section-header p,
  .projects-section-header .time {
    font-size: 18px;
  }

  .status-type {
    padding-right: 4px;

    &:after {
      display: none;
    }
  }

  .search-input {
    font-size: 14px;
  }

  .box-content-header {
    font-size: 12px;
    line-height: 16px;
  }

  .box-content-subheader {
    font-size: 12px;
    line-height: 16px;
  }

  .project-boxes.jsListView .project-box-header > span {
    font-size: 10px;
  }

  .box-progress-header {
    font-size: 12px;
  }

  .box-progress-percentage {
    font-size: 10px;
  }

  .days-left {
    font-size: 8px;
    padding: 6px 6px;
    text-align: center;
  }

  .project-boxes.jsListView .project-box > * {
    margin-right: 10px;
  }

  .project-boxes.jsListView .more-wrapper {
    right: 2px;
    top: 10px;
  }
}

$borderRadius: 10px;
$spacer: 1rem;
$primary: #ffcfcc;
$text: #6a778e;
$linkHeight: $spacer * 3.5;
$timing: 250ms;
$transition: $timing ease all;

@mixin gooeyEffect($i) {
  @keyframes gooeyEffect-#{$i} {
    0% {
      transform: scale(1, 1);
    }
    50% {
      transform: scale(0.5, 1.5);
    }
    100% {
      transform: scale(1, 1);
    }
  }
}
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@600&display=swap");

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
    span {
      font-weight: bold;
      position: absolute;
      margin: 0px 18px;
      left: 100%;
      transform: translate(-($spacer * 3));
      opacity: 0;
      color: var(--main-color);
      background: var(--app-container);
      padding: $spacer * 0.55;
      transition: $transition;
      border-radius: $borderRadius * 1.75;
    }
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

    @for $i from 1 to 6 {
      &:first-child:nth-last-child(#{$i}),
      &:first-child:nth-last-child(#{$i}) ~ li {
        &:hover {
          ~ li:last-child:before {
            opacity: 1;
          }
        }
        &:last-child:hover:before {
          opacity: 1;
        }
        @for $j from 1 to $i {
          &:nth-child(#{$j}):hover,
          &:nth-child(#{$j}):focus,
          &:nth-child(#{$j}):focus-within {
            ~ li:last-child:before {
              @include gooeyEffect($j);
              top: (100% / $i) * ($j - 1);
              animation: gooeyEffect-#{$j} $timing 1;
            }
          }
        }
        &:last-child:hover:before,
        &:last-child:focus:before,
        &:last-child:focus-within:before {
          @include gooeyEffect($i);
          top: (100% / $i) * ($i - 1);
          animation: gooeyEffect-#{$i} $timing 1;
        }
      }
    }
  }
}

.priceSlider {
  width: 250px;
}
.v-text-field.v-text-field--solo:not(.v-text-field--solo-flat)
  > .v-input__control
  > .v-input__slot {
  min-height: 20px;
  max-width: 130px;
}
.v-text-field--outlined.v-input--dense.v-text-field--outlined
  > .v-input__control
  > .v-input__slot,
.v-text-field--outlined.v-input--dense.v-text-field--outlined.v-text-field--filled
  > .v-input__control
  > .v-input__slot {
  min-height: 20px;
  max-width: 130px;
}

.v-text-field.v-text-field--solo .v-input__control {
  min-height: 0px;
}
.v-rating .v-icon {
  padding: 0.1rem;
}
.v-text-field.v-text-field--solo.v-input--dense > .v-input__control {
  min-height: 0px;
}
.theme--light.v-label {
  color: var(--main-color);
}
.theme--light.v-text-field--solo > .v-input__control > .v-input__slot {
  background: var(--app-container);
}
.theme--light.v-list {
  background: var(--app-container);
  color: var(--main-color);
}
.theme--light.v-list-item:not(.v-list-item--active):not(.v-list-item--disabled) {
  color: var(--main-color) !important;
}
.theme--light.v-input:not(.v-input--is-disabled) input,
.theme--light.v-input:not(.v-input--is-disabled) textarea {
  color: var(--main-color);
}
</style>
