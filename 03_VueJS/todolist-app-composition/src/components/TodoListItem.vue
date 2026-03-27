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
      @click="toggleCompleted"
    />
    <!-- checkbox 클릭 시 부모 태그(li)의 클릭 이벤트가 발생(이벤트 버블링)
         이를 막아주어야 원하는대로 input 태그의 이벤트만 발생함  -->

    <span class="pointer" :class="[todoItem.completed ? 'todo-done' : '']">
      {{ todoItem.todo }} {{ todoItem.completed ? '(완료)' : '' }}
    </span>
    <span class="float-end badge bg-secondary pointer" @click="deleteTodo"
      >삭제</span
    >
  </li>
</template>
<script setup>
const props = defineProps({
  todoItem: {
    type: Object,
    required: true,
  },
});
const emit = defineEmits(['toggle-completed', 'delete-todo']);

const toggleCompleted = () => {
  emit('toggle-completed', props.todoItem.id);
};

const deleteTodo = () => {
  emit('delete-todo', props.todoItem.id);
};
</script>
