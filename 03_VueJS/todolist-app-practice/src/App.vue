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

<script>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
import TodoCount from './components/TodoCount.vue';
let ts = new Date().getTime();
export default {
  name: 'App',
  components: { InputTodo, TodoList, TodoCount },
  data() {
    return {
      todoList: [
        { id: ts, todo: '자전거 타기', completed: false },
        { id: ts + 1, todo: '딸과 공원 산책', completed: true },
        { id: ts + 2, todo: '일요일 애견 카페', completed: false },
        { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
      ],
    };
  },
  methods: {
    addTodo(newTodo) {
      this.todoList.push({
        id: new Date().getTime(),
        todo: newTodo,
        completed: false,
      });
    },
    toggleCompleted(itemId) {
      this.todoList.find((item) => itemId === item.id).completed =
        !this.todoList.find((item) => itemId === item.id).completed;
      // console.log(this.todoList.find((item) => itemId === item.id).completed);
    },
    deleteTodo(itemId) {
      let index = this.todoList.findIndex((item) => itemId === item.id);
      this.todoList.splice(index, 1);
      // console.log(this.todoList.length);
    },
  },
};
</script>
