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
    /*
     * 할일 추가
     * @param newTodo - 새로 추가할 할 일 내용
     */
    addTodo(newTodo) {
      this.todoList.push({
        id: new Date().getTime(),
        todo: newTodo,
        completed: false,
      });
    },
    toggleCompleted(itemId) {
      // 배열.findIndex((item) => 조건) : 조건에 맞는 첫 번째 요소의 인덱스를 반환, 없으면 -1 반환
      let index = this.todoList.findIndex((item) => itemId === item.id);
      this.todoList[index].completed = !this.todoList[index].completed;
      // == (동등 비교) : 값만 비교 ex. 1 == '1' -> true
      // === (일치 비교) : 값과 타입 모두 비교 ex. 1 === '1' -> false

      // this.todoList.find((item) => itemId === item.id).completed =
      //   !this.todoList.find((item) => itemId === item.id).completed;
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
