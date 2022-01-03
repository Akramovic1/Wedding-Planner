<template >
  <v-row justify="center" >
    <v-dialog
        v-model="dialog"
        max-width="1100px"
    >
      <template v-slot:activator="{ on, attrs }" style="position:relative; padding:40px ">
            <v-btn
            style="margin: 0px 50px 0px 0px; width:10px "
            color="red"
            text
            v-bind="attrs"
            v-on="on"
            >
            
            <span style="margin-right: 40px"></span>
        </v-btn>
      </template>

      <v-row no-gutters style="overflow-x:hidden;">
        <!-- image cornter -->
        <v-col cols="3">
        <v-card tile class="rounded-tr rounded-td" height="700">
        <v-card-title>
              <v-row>
                <v-col  align="center" justify="center" style="padding:10px 10px 0px 15px ;">
                  <v-avatar size="70">
                    <img
                        src="..\assets\images\team2.jpg"
                    >
                  </v-avatar>
                </v-col>
                <v-col  align="center" justify="center" style="padding:10px 10px">
                  <v-list-item >
                    <v-list-item-content>
                      <v-list-item-title Style="font-weight:bold">Account Name</v-list-item-title>
                    </v-list-item-content>
                  </v-list-item>
                </v-col>
        </v-row>

            </v-card-title>
            <v-divider></v-divider>
            <v-col align="center" justify="center" justify-content="center">
              <v-list >
              <v-list-item>
              <v-btn outlined rounded   style="width:100%" class="mt-4" :color="selectedOption == 'Profile' ? '#FF4F5A' :'' "  @click="selectedOption='Profile'">Profile</v-btn>
              </v-list-item>
              <v-list-item>
              <v-btn outlined rounded  style="width:100%" class="mt-4" :color="selectedOption == 'Orders' ? '#FF4F5A' :'' " @click="selectedOption='Orders'">Order</v-btn>
              </v-list-item>
              <v-list-item>
              <v-btn outlined rounded  style="width:100%" class="mt-4" :color="selectedOption == 'Payment' ? '#FF4F5A' :'' " @click="selectedOption='Payment'">Payment</v-btn>
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

            <v-card-title style="padding:10px">
              
                <v-row  >
                  <v-col >
                  <v-list-item >
                    <v-list-item-content>
                      <v-list-item-title Style="font-size:20px;font-weight:bold">{{selectedOption}}</v-list-item-title>
                    </v-list-item-content>
                  </v-list-item>
                  </v-col>
                  <v-col >
                    
                  </v-col>
                  <v-col>
             

            </v-col>
                </v-row>

            </v-card-title>

            <v-divider></v-divider>
         
          <v-card-text style="height: 530px; overflow-y:auto;">
          <slot v-if="selectedOption == 'Profile'">
            <i>Profile -- TO DO</i>
          </slot>
          <slot v-if="selectedOption == 'Orders'">
          <i>Orders -- TO DO</i>
          </slot>
          <slot v-if="selectedOption == 'Payment'">
          <i>Payment -- TO DO</i>
          </slot>
         
          </v-card-text>

          </v-card>

        </v-col>
      </v-row>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  
  data () {
    return {
      selectedOption:"Profile",
      dialog: false,

    }
  },
  mounted () {

  },
}
</script>

<style lang="scss" scoped>
.btnProfile{
    width: 10px;
    
}
.span{
      font-weight: bold;
      position: absolute;
      margin:0px 40px 0px 60px;
      left: 100%;
    }
.serviceTitles{
  padding:15px 15px;
}
$borderRadius: 10px;
$spacer: 1rem;
$primary: #ffcfcc;
$text: #6a778e;
$linkHeight: $spacer * 3.5;
$timing: 250ms;
$transition: $timing ease all;
.navbar{
  $ref: &;
  position: fixed;
  top: $spacer;
  left: $spacer;
  background: var(--projects-section);
  margin-top: 13% ;
  margin-left: 2%;
  border-radius: 32px;
  padding:  0;
  box-shadow: 0 0 40px rgba(0,0,0,0.03);
  width: 90px;

&__link{
   position:relative;
   display: flex;
   align-items: flex-start;
   justify-content: center;
   height: $linkHeight;
   width: $spacer * 5.5;
   color: $text;
   transition: $transition;

&:hover{
   color: #fff;
span{
  opacity: 3;
  transform: translate(2);
}
}
}
&__menu{
   position: relative;
 }
&__item{
&:last-child{
&:before{
   content: '';
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
}}
.button:hover span {
  color: #6a778e;
}

</style>
