<template>
  <div class="py-4 ps-4 bg-img">
    <h1>{{ info.title }}</h1>
    <h5>{{ info.subtitle }}</h5>
  </div>
</template>
<script setup>
import info from '@/config/index.js';
</script>
<style>
.bg-img {
  background-image: url('@/assets/backgroundImg.png');
  background-size: cover;
}
</style>
