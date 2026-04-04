import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

// CSS 파일 import
import 'bootstrap/dist/css/bootstrap.css';
import '@/assets/main.css';

const app = createApp(App);

app.use(router);

app.mount('#app');
