<template>
  <div class="input-form card card-body mt-3">
    <div class="row">
      <div class="col-md-9">
        <input
          type="text"
          class="form-control"
          placeholder="할 일을 여기에 입력!"
          v-model="newTodo"
          @keyup.enter="addTodo"
        />
      </div>
      <div class="col-md-2">
        <select class="form-select" v-model="importance">
          <option value="">중요도</option>
          <option value="high">긴급</option>
          <option value="middle">중요</option>
          <option value="low">보통</option>
        </select>
      </div>
      <div class="col-md-1">
        <button class="btn btn-primary" type="button" @click="addTodo">
          추가
        </button>
      </div>
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue';

let newTodo = ref('');
let importance = ref('');

const addTodo = () => {
  // 중요도 미 선택 시 보통 중요도로 선택
  if (importance.value == '') {
    importance.value = 'low';
  }

  // 할일 3 글자 이상 입력 시에만 input 기능 수행
  if (newTodo.value.length >= 3) {
    emit('add-todo', newTodo.value, importance.value);

    // 입력받았던 모든 값들 초기화
    newTodo.value = '';
    importance.value = '';
    return;
  }
  alert('할 일은 3글자 이상 입력해주세요!');
};

const emit = defineEmits(['add-todo']);
</script>
