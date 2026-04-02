<template>
  <div class="mt-3 ms-2">
    <h2><i :class="['fas', menu.icon]"></i> {{ menu.title }}</h2>
  </div>
</template>
<script setup>
import { useRoute } from 'vue-router';
import menus from '@/config/index.js';

const currentRoute = useRoute();
const url = currentRoute.path.toString();

const menu = menus.menus.find((m) => m.url === url);
</script>
