<template>
  <h1>콘솔을 확인하세요</h1>
</template>

<script setup>
// axios를 활용하기 위해 import 해야함
import axios from 'axios';

// 에러 처리 구문을 가지는 코드
// async/await 구문 이용하기

const url = '/api/todos2'; // 에러를 발생시키는 url
const requestAPI = async () => {
  let todoList = [];
  try {
    const result = await axios.get(url);
    todoList = result.data;
    console.log(todoList);
  } catch (err) {
    console.error(err);
  }
};

requestAPI();
</script>
<style scoped></style>
