<template>
      <div id="container">
    <v-dialog
      :value="value"
      max-width="900px"
      height="610px"
    >
      <!-- <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="red lighten-2"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Check out
        </v-btn>
      </template> -->

        <div class="container">
                    <v-col style="background-color: white; border-radius:10%">
                    <v-row>
                        <div class="col1" style="margin-left: 10%">
                        <div class="card">
                            <div class="front">
                            <div class="type">
                                <img class="bankid" />
                            </div>
                            <span class="chip"></span>
                            <span class="card_number"
                                >&#x25CF;&#x25CF;&#x25CF;&#x25CF;
                                &#x25CF;&#x25CF;&#x25CF;&#x25CF;
                                &#x25CF;&#x25CF;&#x25CF;&#x25CF;
                                &#x25CF;&#x25CF;&#x25CF;&#x25CF;
                            </span>
                            <div class="date">
                                <span class="date_value">MM / YYYY</span>
                            </div>
                            <span class="fullname">Ahmed Akram</span>
                            </div>
                            <div class="back">
                            <div class="magnetic"></div>
                            <div class="bar"></div>
                            <span class="seccode">&#x25CF;&#x25CF;&#x25CF;</span>
                            <span class="chip"></span>
                            </div>
                        </div>
                        </div>
                    </v-row>
                    <v-row>
                        <div class="col2">
                        <v-row>
                            <v-col>
                            <label>Card Number</label>
                            <input
                                class="number"
                                type="text"
                                ng-model="ncard"
                                maxlength="19"
                                onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                            />
                            </v-col>
                            <v-col>
                            <label>Cardholder name</label>
                            <input class="inputname" type="text" placeholder="" />
                            </v-col>
                        </v-row>
                        <v-row>
                            <v-col>
                            <label>Expiry date</label>
                            <input
                                class="expire"
                                type="text"
                                placeholder="MM / YYYY"
                            />
                            </v-col>
                            <v-col>
                            <label>Security Number</label>
                            <input
                                class="ccv"
                                type="text"
                                placeholder="CVC"
                                maxlength="3"
                                onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                            />
                            </v-col>
                        </v-row>
                        <!-- <v-row>
                    <v-col> -->
                        <button class="buy" @click="value = false; dialog2 = true">
                            <i class="material-icons"></i> Pay
                        </button>
                        <success  v-model="dialog2" />
                        <!-- </v-col>
                    <v-col>
                    </v-col>
                    </v-row> -->
                        </div>
                    </v-row>
                    </v-col>
                </div>
    </v-dialog>
      </div>
</template>

<script>
import Success from './success.vue'


export default {
  name: "Pay",
  data() {
    return {
        dialog: false,
        dialog2:false,
    }
  },
  components: {
    Success

  },

  props: ["value"]

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
  align-self: center;
  align-content: center;
  justify-content: center;
  justify-items: center;
  align-items: center;
  width: 680px;

  .col1 {
    perspective: 1000;
    transform-style: preserve-3d;
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
        background: #fd6860;
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
