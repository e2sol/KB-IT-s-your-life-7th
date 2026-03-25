import './assets/main.css'; // CSS 파일 연결

import { createApp } from 'vue';
import App from './App.vue';
import CheckboxItem from './components/CheckboxItem.vue';

createApp(App).mount('#app').component('CheckboxItem', CheckboxItem);
