<template>
  <div class="container">
    <Header />
    <RouterView />
  </div>
</template>
<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
import axios from 'axios';
import router from './router';

// Local data 이용
// const states = reactive({
//   todoList: [
//     { id: 1, todo: 'ES6 학습', desc: '설명1', done: false },
//     { id: 2, todo: 'React 학습', desc: '설명2', done: false },
//     { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
//     { id: 4, todo: '야구경기관람', desc: '설명4', done: false },
//   ],
// });

// db.json data를 이용한 todoList
const states = reactive({
  todoList: [],
  isLoading: false,
});

const fetchTodoList = async () => {
  try {
    let resp = await axios.get('/api/todos');
    states.todoList = resp.data;
  } catch (err) {
    console.error(err);
  }
};
// 시작하자마자 함수 호출
fetchTodoList();

// --------------------------------------
// 데이터 추가/편집/삭제 관련 함수 선언
// const addTodo = ({ todo, desc }) => {
//   states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
// };
// axios 활용 데이터 추가
const addTodo = async ({ todo, desc }) => {
  try {
    const resp = await axios.post('/api/todos', {
      id: new Date().getTime(),
      todo,
      desc,
      done: false,
    });
    if (resp.status === 201) {
      await fetchTodoList();
      router.push('/todos');
    }
  } catch (err) {
    console.error(err);
  }
};

// 데이터 편집
// const updateTodo = ({ id, todo, desc, done }) => {
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   states.todoList[index] = { ...states.todoList[index], todo, desc, done };
//   // ...states.todoList[index] : 기존 객체 복사
//   // 같은 키(todo, desc, done)는 새 값으로 덮어쓰기
// };
// axios 활용 데이터 편집
const updateTodo = async ({ id, todo, desc, done }) => {
  try {
    const resp = await axios.put(`/api/todos/${id}`, { id, todo, desc, done });
    if (resp.status === 200) {
      await fetchTodoList();
      router.push('/todos');
    }
  } catch (err) {
    console.error(err);
  }
};

// 데이터 삭제
// const deleteTodo = (id) => {
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   states.todoList.splice(index, 1);
// };
// axios 활용 데이터 삭제
const deleteTodo = async (id) => {
  try {
    const resp = await axios.delete(`/api/todos/${id}`);
    if (resp.status === 200) {
      await fetchTodoList();
      router.push('/todos');
    }
  } catch (err) {
    console.error(err);
  }
};

const toggleDone = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index].done = !states.todoList[index].done;
};
// provide : 자식 컴포넌트로 데이터를 넘기는 함수 전달할 데이터의 key와 value를 지정
// 중간 컴포넌트를 거치지 않아도 자손 컴포넌트에 직접 접근이 가능
// 반응성 변수의 반응성이 유지되고 변경 권한은 부모만 가지는 구조가 권장
provide(
  'todoList',
  computed(() => states.todoList),
);
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>
