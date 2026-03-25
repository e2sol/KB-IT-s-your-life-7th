<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="todoItem in sortTodoList"
          :key="todoItem.id"
          :todoItem="todoItem"
          @toggle-completed="$emit('toggle-completed', $event)"
          @delete-todo="$emit('delete-todo', $event)"
        />
      </ul>
    </div>
  </div>
</template>
<script>
import TodoListItem from './TodoListItem.vue';

export default {
  name: 'TodoList',
  components: {
    TodoListItem,
  },
  props: ['todoList'],
  computed: {
    sortTodoList() {
      let falseTodoList = this.todoList.filter(
        (item) => item.completed === false,
      );
      falseTodoList.sort((a, b) => {
        return a.todo < b.todo ? -1 : a.todo > b.todo ? 1 : 0;
      });

      let trueTodoList = this.todoList.filter((item) => item.completed);
      trueTodoList.sort((a, b) => {
        return a.todo < b.todo ? -1 : a.todo > b.todo ? 1 : 0;
      });

      let sortedTodoList = falseTodoList.concat(trueTodoList);
      return sortedTodoList;
      // let sortedTodoList = this.todoList.sort(function (a, b) {
      //   // 한글 오름차순
      //   return a.todo < b.todo ? -1 : a.todo > b.todo ? 1 : 0;
      // });
      // sortedTodoList.sort((a, b) => {
      //   return a.completed - b.completed;
      // });
      // return sortedTodoList;
    },
  },
};
</script>
