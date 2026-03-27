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
        <!-- 이벤트 방출 시 전달되는 데이터는 $event로 수신 가능 -->
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
  props: {
    todoList: {
      type: Array,
      required: true,
    },
  },
  emits: ['toggle-completed', 'delete-todo'],
  computed: {
    sortTodoList() {
      // computed 속성 중 false 값을 가진 객체들만 새로운 배열로 필터링
      let falseTodoList = this.todoList.filter(
        (item) => item.completed === false,
      );
      // false 값을 가진 객체들을 오름차순으로 정렬
      falseTodoList.sort((a, b) => {
        return a.todo < b.todo ? -1 : a.todo > b.todo ? 1 : 0;
      });

      // computed 속성 중 true 값을 가진 객체들만 새로운 배열로 필터링
      let trueTodoList = this.todoList.filter((item) => item.completed);
      // true 값을 가진 객체들을 오름차순으로 정렬
      trueTodoList.sort((a, b) => {
        return a.todo < b.todo ? -1 : a.todo > b.todo ? 1 : 0;
      });

      // 각 배열을 합쳐서 반환
      let sortedTodoList = falseTodoList.concat(trueTodoList);
      return sortedTodoList;

      // 두번 연속 sort() 메서드를 활용하여 정렬한 경우, 오류 발생
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
