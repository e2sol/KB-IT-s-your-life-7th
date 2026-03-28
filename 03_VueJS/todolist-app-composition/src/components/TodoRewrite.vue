<template>
  <div class="row mt-3" @click.stop="" v-if="isRewrite === 1">
    <div class="col-md-9">
      <input
        type="text"
        class="form-control form-control-sm"
        placeholder="할 일을 여기에 입력!"
        v-model="newTodo"
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
    <div class="col-md-1">
      <span class="badge bg-secondary pointer" @click.stop="rewriteTodo"
        >수정완료</span
      >
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue';

const props = defineProps(['isRewrite', 'todoId', 'importance']);

let newTodo = ref('');
let importance = ref('');

const rewriteTodo = () => {
  // 중요도 미 선택 시 기존 중요도로 선택
  if (importance.value == '') {
    importance.value = props.importance;
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
  alert('할 일은 3글자 이상 입력해주세요!');
};

const emit = defineEmits(['complete-rewrite']);
</script>
