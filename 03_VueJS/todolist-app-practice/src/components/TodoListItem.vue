<template>
  <li
    class="list-group-item bg-subtle"
    :class="{ 'list-group-item-success': todoItem.completed }"
    @click="toggleCompleted"
  >
    <input type="checkbox" class="pointer me-3" :checked="todoItem.completed" />
    <span class="pointer" :class="[todoItem.completed ? 'todo-done' : '']">
      {{ todoItem.todo }} {{ todoItem.completed ? '(완료)' : '' }}
    </span>
    <span class="float-end badge bg-secondary pointer" @click="deleteTodo"
      >삭제</span
    >
  </li>
</template>
<script>
export default {
  name: 'TodoListItem',
  props: ['todoItem'],
  methods: {
    toggleCompleted() {
      this.$emit('toggle-completed', this.todoItem.id);
    },
    deleteTodo() {
      this.$emit('delete-todo', this.todoItem.id);
    },
  },
};
</script>
