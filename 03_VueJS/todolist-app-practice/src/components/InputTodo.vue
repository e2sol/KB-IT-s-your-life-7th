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
<script>
export default {
  name: 'InputTodo',
  data() {
    return {
      newTodo: '',
    };
  },
  // 이벤트 방출 검사
  // 부모 컴로넌트로 전달되는 이벤트가 addTodo가 맞는지 검사
  emits: ['add-todo'],
  methods: {
    addTodo() {
      if (this.newTodo.length >= 3) {
        this.$emit('add-todo', this.newTodo);
        this.newTodo = ''; // 입력창 초기화
        return; // 메서드 종료
      }
      alert('할 일은 3글자 이상 입력해주세요!');
    },
  },
};
</script>
