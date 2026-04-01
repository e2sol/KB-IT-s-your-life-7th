<script setup>
import DefaultLayout from './components/layouts/DefaultLayout.vue';
import Footer from './components/layouts/Footer.vue';
import Header from './components/layouts/Header.vue';
import NavBar from './components/layouts/NavBar.vue';
</script>

<template>
  <div>
    <Header />
    <NavBar />
    <RouterView />
    <DefaultLayout />
    <Footer />
  </div>
</template>

<style scoped></style>
