<template>
  <v-app-bar  app class="px-12" color="white" elevate-on-scroll>
    <slot class="logocontainer">
      <img src="../assets/images/logo.jpg" @click="()=>$router.push('/#Home')" />
    </slot>
    <v-toolbar-title > Wedding Planner </v-toolbar-title>
    <v-spacer/>

        <v-layout class="wrapme" column align-center justify-center>
          <div :class="['search-bar', searchIsFocused ? 'elevation-6' : 'elevation-3']">
            <input
                   placeholder="Search"
                   v-on:focus="searchFocus()"
                   v-on:blur="searchUnfocus()"
                   type="text"
                   name="search"
                   v-model="filter.search">
          </div>
        </v-layout>

    <v-spacer/>
    <v-list right style="padding-left:20px;">
      <v-btn bold dark style="margin-left:20px" rounded color="#FF4F5A" ><i class="fas fa-user-circle"></i>My Account</v-btn>
    </v-list>
    <v-list right style="padding-left:20px;">
      <v-btn bold dark style="margin-left:20px" rounded color="#FF4F5A"   @click="()=>$router.push('/Registration')"><i class="fas fa-sign-out-alt"></i>Log Out</v-btn>
    </v-list>
  </v-app-bar>
</template>
<script>
export default {
  name: "Mainbar",

  data () {

    return{
      searchIsFocused: false,
      filter: {
        search: ''
      },
      menus:[
        {title:'Home',route:'/#Home'},
        {title:'About Us',route:'/#AboutUs'},
        {title:'Gallery',route:'/#Gallery'},
        {title:'Contact Us',route:'/#ContactUs'},
      ]
    }
  },
  methods: {
    searchFocus() {
      this.searchIsFocused = true;
    },
    searchUnfocus() {
      this.searchIsFocused = false;
    },

  }
};
</script>

<style scoped>
@import url(https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css);
img{
  display:block;
  margin:0 auto;
  width:5%;
}
.wrapme {
  width: 70%;
  max-width: 900px;

}

.search-bar {
  background: #fff;
  width: 100%;
  border-radius: 10em;
  transition: box-shadow 300ms ease;
}

.search-bar input {
  width: 100%;
  border-style: none;

  color: inherit;
  background-color: transparent;

  padding-left: 1em;
  font-size: 1.4em;
}

.search-bar input:focus {
  outline: none;
}

</style>
