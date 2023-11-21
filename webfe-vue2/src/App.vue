<script setup>
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
var type = 'A'
let arr = ['a', 'b', 'c']
function add1() {
  arr.every( (v, i , a) => a[i] = v +1)
}
</script>

<template>
  <div id="app">
    <div v-if="type == 'A'">A</div>
    <div v-else-if="type == 'B'">B</div>
    <div v-else-if="type == 'C'">C</div>
    <div v-else>others</div>
    <ol>
      <li v-for="(item, idx) in arr">{{ idx }} - {{ item }}</li>
  </ol>
  <button v-on:click="add1()">click</button>
  </div>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
