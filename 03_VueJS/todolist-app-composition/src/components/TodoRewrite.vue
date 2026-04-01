<template>
  <div class="row mt-3" @click.stop="" v-if="isRewrite === true">
    <div class="col-md-8">
      <input
        type="text"
        class="form-control form-control-sm"
        placeholder="수정할 할 일을 여기에 입력!"
        v-model.trim="newTodo"
        @keyup.enter="rewriteTodo"
      />
    </div>
    <div class="col-md-2">
      <select class="form-select form-select-sm" v-model="importance">
        <option value="">중요도</option>
        <option value="high">긴급</option>
        <option value="middle">중요</option>
        <option value="low">보통</option>
      </select>
    </div>
    <div class="col-md-2">
      <span class="float-end"
        ><span
          class="badge bg-success-subtle pointer me-2"
          @click.stop="rewriteTodo"
          >완료</span
        >
        <span
          class="badge bg-secondary pointer"
          @click.stop="emit('rewrite-todo')"
          >취소</span
        ></span
      >
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue';

const props = defineProps(['isRewrite', 'todoId', 'importance', 'todo']);

let newTodo = ref('');
let importance = ref('');

const rewriteTodo = () => {
  // 중요도 미 선택 시 기존 중요도로 선택
  if (importance.value == '') {
    importance.value = props.importance;
  }

  // 할일 수정사항 미 입력 시 기존 할일 내용 저장
  if (newTodo.value.length == 0) {
    newTodo.value = props.todo;
  }

  // 할일 3 글자 이상 입력 시에만 수정 기능 수행
  if (newTodo.value.length >= 3) {
    const todoId = props.todoId;
    emit('complete-rewrite', { newTodo, importance, todoId });

    // 입력받았던 모든 값들 초기화
    newTodo.value = '';
    importance.value = '';
    return;
  }
  alert('수정할 할일은 3글자 이상 입력해주세요!');
};

const emit = defineEmits(['complete-rewrite', 'rewrite-todo']);
</script>
