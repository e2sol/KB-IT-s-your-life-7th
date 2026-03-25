<template>
  <div class="container text-center">
    <div class="row">
      <div class="col">
        전체 todo 개수 :
        <span
          ><b>{{ todoList.length }}</b></span
        >
      </div>
      <div class="col">
        완료 todo 개수 :
        <span :class="{ 'text-success': completedTodo != 0 }"
          ><b>{{ completedTodo }}</b></span
        >
      </div>
      <div class="col">
        미완료 todo 개수 :
        <span :class="{ 'text-danger': uncompletedTodo != 0 }"
          ><b>{{ uncompletedTodo }}</b></span
        >
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'TodoCount',
  props: ['todoList'],

  computed: {
    completedTodo() {
      return this.todoList.filter((item) => item.completed).length;
    },
    uncompletedTodo() {
      return this.todoList.filter((item) => item.completed === false).length;
    },
  },
};
</script>
