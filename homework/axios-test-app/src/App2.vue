<template>
  <h1>콘솔을 확인하세요</h1>
</template>

<script setup>
// axios를 활용하기 위해 import 해야함
import axios from 'axios';

// axios를 이용해서 todo 목록을 얻어 콘솔에 출력
// async/await 구문 이용하기
const url = '/api/todos';
const requestAPI = async () => {
  let todoList = [];
  const result = await axios.get(url);
  todoList = result.data;
  console.log(todoList);
};

requestAPI();
</script>
<style scoped></style>
