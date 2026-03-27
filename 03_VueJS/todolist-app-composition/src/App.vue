<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default panel-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoCount :todoList="todoList" />
        <TodoList
          :todoList="todoList"
          @toggle-completed="toggleCompleted"
          @delete-todo="deleteTodo"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
import TodoCount from './components/TodoCount.vue';
import { reactive } from 'vue';

let ts = new Date().getTime();

const todoList = reactive([
  { id: ts, todo: '자전거 타기', completed: false },
  { id: ts + 1, todo: '딸과 공원 산책', completed: true },
  { id: ts + 2, todo: '일요일 애견 카페', completed: false },
  { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
]);

const addTodo = (newTodo) => {
  todoList.push({
    id: new Date().getTime(),
    todo: newTodo,
    completed: false,
  });
};

const toggleCompleted = (itemId) => {
  let index = todoList.findIndex((item) => itemId === item.id);
  todoList[index].completed = !todoList[index].completed;
};

const deleteTodo = (itemId) => {
  let index = todoList.findIndex((item) => itemId === item.id);
  todoList.splice(index, 1);
};
</script>
