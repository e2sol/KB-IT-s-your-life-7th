<template>
  <h1>콘솔을 확인하세요</h1>
</template>

<script setup>
// axios를 활용하기 위해 import 해야함
import axios from 'axios';

// 주어진 데이터 서버에 추가하기
// async/await 구문 이용하기
const url = '/api/todos';
let data = { todo: '윗몸일으키기 3세트', desc: '너무 빠르지 않게...' };
const requestAPI = async () => {
  // let todoList = [];
  const start = await axios.get(url);
  console.log('## 초기 데이터 : ', start.data);

  const plusTodo = await axios.post(url, data); // 새로운 데이터 추가 시 .post(url, data) 방식 이용
  console.log('## 추가된 데이터 : ', plusTodo.data); // id값은 자동으로 생성. 입력 불필요
};

requestAPI();
</script>
<style scoped></style>
