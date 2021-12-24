<template>
    <v-container class="my-15">
      <v-row justify="center">
            <v-col lg="12" class="text-center">
                <h2 class="text-center">Contact Us</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur culpa, praesentium vel temporibus dolore voluptatum perspiciatis aliquid ex sit facilis inventore aspernatur nesciunt officiis, officia, eligendi ab odio perferendis impedit! Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed cumque quibusdam quis et qui rerum id earum aliquam consectetur odit, temporibus veritatis ad! Voluptatem placeat quo fugiat asperiores voluptatum nihil? Lorem ipsum dolor sit amet consectetur, adipisicing elit. Repudiandae dolor temporibus aspernatur officiis! Repellendus deleniti rerum dolore porro. Voluptas vel nam sapiente ipsum quam, incidunt soluta libero debitis quidem quasi!</p>
            </v-col>
            <v-col lg="6">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3412.4706870162518!2d29.920149415432043!3d31.20768656963704!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14f5c47e53204b39%3A0x884cc003f3633cf1!2sFaculty%20of%20Engineering%2C%20Alexandria%20University!5e0!3m2!1sen!2seg!4v1640125231548!5m2!1sen!2seg" width="100%" height="100%" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            </v-col>
            <v-col lg="6">
                <v-form
    ref="form">
    <v-text-field
      v-model="contactInfo.name"
      :counter="10"
      label="Name"
      color="#FF4F5A"
      required
    ></v-text-field>
    
    <v-text-field
      v-model="contactInfo.email"
      :rules="emailRules"
      label="E-mail"
      color="#FF4F5A"
      required
    ></v-text-field>

    <v-textarea label="Message" v-model="contactInfo.message" color="#FF4F5A">
          
    </v-textarea>



    <v-btn dark color="#FF4F5A" class="mr-4">
      Send
    </v-btn>
  </v-form>
            </v-col>

      </v-row>
    </v-container>
</template>
<script>
export default {
  name: "ContactUs",

  data () {
    return{
      contactInfo:{}
    }
  },
};
</script>

<style scoped>
h2{
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