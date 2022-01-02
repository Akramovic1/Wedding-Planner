<template>
    <v-app-bar  app class="px-12" color="white" elevate-on-scroll>
    <slot class="logocontainer">
      <img src="../../assets/images/rings.png" style="width:4%" @click="()=>$router.push('/#Home')" />
    </slot>
    <v-toolbar-title style="margin-left:10px" > Wedding Planner </v-toolbar-title>
    <v-spacer/>
    <v-list class="d-flex align-center">
      <v-list-item link v-for = "(menu,index) in menus" :key="index" :to="menu.route">
        <v-list-item-title>{{menu.title}} </v-list-item-title>
      </v-list-item>
    </v-list>
    <v-spacer/>
    <v-list right style="padding-left:20px;">
      <v-btn bold dark style="margin-left:20px" rounded color="#FF4F5A"   @click="()=>$router.push('/Registration')">Registration</v-btn>
    </v-list>
  </v-app-bar> 
</template>
<script>
export default {
  name: "Header",

  data () {
    return{
      menus:[
        {title:'Home',route:'/#Home'},
        {title:'About Us',route:'/#AboutUs'},
        {title:'Gallery',route:'/#Gallery'},
        {title:'Contact Us',route:'/#ContactUs'},
      ]
    }
  },
};
</script>
<style scoped>
img{
     display:block;
     margin:0 auto;
     width:5%;
 }
</style>
