import { createApp } from 'vue';
import App from './App.vue';

// main.js
import VCalendar from 'v-calendar';
import 'v-calendar/style.css';

// app.use(VCalendar);
// createApp(App).mount('#app');

const app = createApp(App);
app.use(VCalendar);
app.mount('#app');
