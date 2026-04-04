<template>
  <h1>콘솔을 확인하세요</h1>
</template>

<script setup>
// axios를 활용하기 위해 import 해야함
import axios from 'axios';

// axios를 이용하여 /api/todos/1 을 요청하고 그 결과를 콘솔에 출력
const url = '/api/todos/1';
const requestAPI = () => {
  axios.get(url).then((resp) => {
    console.log('## /api/todos/1 요청 결과 : ', resp);
  });
};
requestAPI();

// axios를 이용해서 todo 목록을 얻어 콘솔에 출력하고, 이어서 id가 1인 todo를 얻어 그 결과를 콘솔에 출력
// Promise의 .then().catch() 구문 이용하기

const url2 = '/api/todos';
const requestAPI2 = () => {
  let todolist = [];
  axios
    .get(url2)
    .then((resp) => {
      todolist = resp.data;
      console.log('## TodoList : ', todolist);
      return todolist[0].id;
    })
    .then((id) => {
      axios.get(url2 + '/' + id).then((resp) => {
        console.log('## id가 1인 todo : ', resp.data);
      });
    });
};
requestAPI2();
</script>
<style scoped></style>
