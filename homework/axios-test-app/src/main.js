import { createApp } from 'vue';
// import App from './App.vue' // 심화 1 풀이
// import App from './App2.vue'; // 심화 2 (async/await 구문 활용)
// import App from './App4.vue'; // 심화 2 (json 서버 데이터 추가)
import App from './App6.vue'; // 심화 2 (error 처리 코드 추가)
import router from './router';

const app = createApp(App);

app.use(router);

app.mount('#app');
