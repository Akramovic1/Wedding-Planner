<template>
    <v-container>
      <v-row>
            <v-col lg="6">
                <img src="./../assets/aboutus.jpg">
            </v-col>
            <v-col lg="6">
                <h1>About Us</h1>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur culpa, praesentium vel temporibus dolore voluptatum perspiciatis aliquid ex sit facilis inventore aspernatur nesciunt officiis, officia, eligendi ab odio perferendis impedit! Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed cumque quibusdam quis et qui rerum id earum aliquam consectetur odit, temporibus veritatis ad! Voluptatem placeat quo fugiat asperiores voluptatum nihil? Lorem ipsum dolor sit amet consectetur, adipisicing elit.</p>
            </v-col>
      </v-row>
    </v-container>
</template>
<script>
export default {
  name: "AboutUs",

  data () {
    return{
      
    }
  },
};
</script>
<style scoped>
img{
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 110%;
}
h1{
    padding: 20px;
    font-size: 40px;
    font-weight: bold;
    font-family: cursive;
    color: rgb(109, 109, 109);
}
p{
    font-size: 18px;
    color: rgb(109, 109, 109);
    font-weight: bold;
}
</style>