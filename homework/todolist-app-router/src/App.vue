<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>

<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
// axios 연결
import axios from 'axios';
// axios 활용 시 사용할 변수 선언
const BASEURI = '/api/todos';
const states = reactive({ todoList: [] });

// 내부 데이터 사용 안함
// const states = reactive({
//   todoList: [
//     { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
//     { id: 2, todo: 'React학습', desc: '설명2', done: false },
//     { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
//     { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
//   ],
// });

//TodoList 목록을 조회
const fetchTodoList = async () => {
  try {
    const response = await axios.get(BASEURI);
    if (response.status === 200) {
      // get 실행 시 상태가 200이라면 데이터를 todoList에 넣기
      states.todoList = response.data;
    } else {
      alert('데이터 조회 실패');
    }
  } catch (error) {
    // Promise 객체 reject
    alert('에러발생 :' + error);
  }
};

// 기존 TodoItem 추가 관련 함수
// const addTodo = ({ todo, desc }) => {
//   states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
// };

// axios 사용 시 TodoItem 추가 함수
const addTodo = async ({ todo, desc }, successCallback) => {
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      states.todoList.push({ ...response.data, done: false });
      successCallback();
    } else {
      alert('Todo 추가 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
};

// -----------------------------------------
// 아래 내용 교안보고 코드리뷰하기
const updateTodo = ({ id, todo, desc, done }) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index] = { ...states.todoList[index], todo, desc, done };
};
const deleteTodo = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList.splice(index, 1);
};
const toggleDone = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index].done = !states.todoList[index].done;
};
provide(
  'todoList',
  computed(() => states.todoList),
);
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>
