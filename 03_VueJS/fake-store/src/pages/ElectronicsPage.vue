<template>
  <div class="mt-3 ms-2">
    <h2><i :class="menu.icon"></i> {{ menu.title }}</h2>
  </div>
</template>
<script setup>
import { useRoute } from 'vue-router';
import info from '@/config/index.js';

const currentRoute = useRoute();
const url = currentRoute.path.toString();

const menu = info.menus.find((m) => m.url === url);
</script>
