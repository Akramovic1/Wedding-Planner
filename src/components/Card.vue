<template>
  <v-card
      :loading="loading"
      class="mx-auto my-12"
      max-width="250"
  >
    <v-img
        height="200"
        src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
    ></v-img>

    <v-card-title>Cafe Badilico</v-card-title>

    <v-card-text>
      <v-row
          align="center"
          class="mx-0"
      >
        <v-rating
            :value="4.5"
            color="amber"
            dense
            half-increments
            readonly
            size="14"
        ></v-rating>

        <div class="grey--text ms-2">
          4.5
        </div>
      </v-row>
      <div class="my-2 text-subtitle-1"><i class="fa fa-map-marker" aria-hidden="true"></i>
        Italian, Cafe
      </div>

    </v-card-text>

    <v-divider class="mx-2"></v-divider>

  </v-card>
</template>

<script>
export default {
  name: "Card"
}
</script>

<style scoped>
</style>