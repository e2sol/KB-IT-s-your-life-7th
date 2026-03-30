<template>
  <li
    class="list-group-item bg-subtle"
    :class="{ 'list-group-item-success': todoItem.completed }"
    @click="toggleCompleted"
  >
    <!-- checkbox 클릭 시 부모 태그(li)의 클릭 이벤트가 발생(이벤트 버블링)
         이를 막아주어야 원하는대로 input 태그의 이벤트만 발생함  -->
    <input
      type="checkbox"
      class="pointer me-3"
      :checked="todoItem.completed"
      @click.stop="toggleCompleted"
    />
    <!-- 긴급 선택 시 아이콘 노출 -->
    <span class="me-2" v-if="todoItem.importance === 'high'"
      ><i class="fa-solid fa-triangle-exclamation" style="color: orange"></i>
    </span>

    <!-- 중요 선택 시 아이콘 노출 -->
    <span class="me-2" v-if="todoItem.importance === 'middle'"
      ><i class="fa-solid fa-circle-exclamation" style="color: yellowgreen"></i>
    </span>

    <span
      class="pointer"
      :class="{
        'todo-done': todoItem.completed,
        'fw-bold':
          todoItem.importance === 'high' && todoItem.completed === false,
      }"
    >
      {{ todoItem.todo }} {{ todoItem.completed ? '(완료)' : '' }}
    </span>

    <!-- 긴급, 주의 중요도 선택 시 각 중요도 표시 -->
    <!-- 긴급 선택 시 아이콘 노출 -->
    <span
      class="me-2 text-danger fw-bold"
      v-if="todoItem.importance === 'high' && todoItem.completed === false"
      >(긴급)
    </span>

    <!-- 중요 선택 시 아이콘 노출 -->
    <span
      class="me-2 text-warning"
      v-if="todoItem.importance === 'middle' && todoItem.completed === false"
      >(중요)
    </span>

    <span class="float-end"
      ><span class="badge bg-info pointer me-2" @click.stop="rewriteTodo"
        >수정</span
      >
      <span class="badge bg-secondary pointer" @click="deleteTodo"
        >삭제</span
      ></span
    >
    <div>
      <TodoRewrite
        :isRewrite="isRewrite"
        :todoId="todoItem.id"
        :todo="todoItem.todo"
        :importance="todoItem.importance"
        @complete-rewrite="completeRewrite"
        @rewrite-todo="rewriteTodo"
      />
    </div>
  </li>
</template>
<script setup>
import { ref } from 'vue';
import TodoRewrite from './TodoRewrite.vue';

const props = defineProps({
  todoItem: {
    type: Object,
    required: true,
  },
});
const emit = defineEmits([
  'toggle-completed',
  'delete-todo',
  'complete-rewrite',
]);

const toggleCompleted = () => {
  emit('toggle-completed', props.todoItem.id);
};

let isRewrite = ref(false);
const rewriteTodo = () => {
  isRewrite.value = !isRewrite.value;
  // console.log(`수정버튼 클릭 ${props.todoItem.id}`);
};

const completeRewrite = ($event) => {
  isRewrite.value = false;
  emit('complete-rewrite', $event);
  // console.log(`수정완료 전달 중 ${$event}`);
};

const deleteTodo = () => {
  emit('delete-todo', props.todoItem.id);
};
</script>
