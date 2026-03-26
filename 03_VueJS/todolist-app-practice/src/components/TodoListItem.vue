<template>
  <li
    class="list-group-item bg-subtle"
    :class="{ 'list-group-item-success': todoItem.completed }"
    @click="toggleCompleted"
  >
    <!-- 객체 props에 v-model 사용 시 부모의 데이터도 같이 변경 -->
    <!-- 하지만, props는 읽기 전용이 원칙이기 때문에 권장하지 않음 -->
    <!-- 해결 방법 : 자식 컴포넌트에서 $emit 이벤트를 사용하여 부모 컴포넌트에 변경 사항을 알림 -->
    <!-- <input type="checkbox" class="pointer me-3" v-model="todoItem.completed" /> -->
    <input
      type="checkbox"
      class="pointer me-3"
      :checked="todoItem.completed"
      @click.stop="toggleCompleted"
    />
    <!-- checkbox 클릭 시 자동으로 change 이벤트가 발생하는데, 이를 .stop으로 막지 않으면, 
         change를 통해 모양 변경 및 true/false값으로 인한 상태 변경이 겹쳐 최종적으로 모양이 변하지 않음 -->

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
  props: {
    todoItem: {
      type: Object,
      required: true,
    },
  },
  emits: ['toggle-completed', 'delete-todo'],
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
