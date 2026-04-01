<template>
  <div>
    <nav class="navbar bg-primary navbar-expand-lg" data-bs-theme="dark">
      <div class="container-fluid">
        <router-link class="nav-link" to="/" style="color: white"
          >Fake Store</router-link
        >
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" :class="navClass" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <router-link class="nav-link" to="/electronics">가전</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/jewelery">주얼리</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/mensclothing"
                >남성의류</router-link
              >
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/womensclothing"
                >여성의류</router-link
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>
<script setup>
import { ref, computed } from 'vue';
import info from '@/config/index.js';

const state = ref({ isNavShow: false });
const navClass = computed(() => {
  state.value.isNavShow
    ? 'collapse navbar-collapse show'
    : 'collapse navbar-collapse';
});
const changeIsNavShow = () => {
  state.value.isNavShow = !state.value.isNavShow;
};
</script>
<style></style>
