<template>
  <div class="row">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할 일을 여기에 입력!"
          v-model="newTodo"
          @keyup.enter="addTodo"
        />
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

const addTodo = () => {
  if (newTodo.value.length >= 3) {
    emit('add-todo', newTodo.value);

    newTodo.value = '';
    return;
  }
  alert('할 일은 3글자 이상 입력해주세요!');
};

const emit = defineEmits(['add-todo']);
</script>
