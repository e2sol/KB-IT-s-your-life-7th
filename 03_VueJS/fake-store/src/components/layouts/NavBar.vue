<template>
  <nav class="navbar navbar-expand-md bg-primary navbar-dark">
    <router-link class="navbar-brand" to="/"
      ><i class="fa-solid fa-house"></i> Fake Store</router-link
    >
    <button class="navbar-toggler" type="button" @click="changeIsNavShow">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div :class="navClass">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/electronics"
            ><i :class="['fas', menus[0].icon]"></i>
            {{ menus[0].title }}</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/jewelery"
            ><i :class="['fas', menus[1].icon]"></i>
            {{ menus[1].title }}</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/mensclothing"
            ><i :class="['fas', menus[2].icon]"></i>
            {{ menus[2].title }}</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/womensclothing"
            ><i :class="['fas', menus[3].icon]"></i>
            {{ menus[3].title }}</router-link
          >
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import { reactive, computed } from 'vue';
import info from '@/config/index.js';

export default {
  setup() {
    const state = reactive({ isNavShow: false });
    const navClass = computed(() =>
      state.isNavShow
        ? 'collapse navbar-collapse show'
        : 'collapse navbar-collapse',
    );
    const changeIsNavShow = () => {
      state.isNavShow = !state.isNavShow;
    };

    const menus = reactive([]);
    for (let i = 0; i < info.menus.length; i++) {
      menus.push(info.menus[i]);
    }

    return { state, changeIsNavShow, navClass, menus };
  },
};
</script>
