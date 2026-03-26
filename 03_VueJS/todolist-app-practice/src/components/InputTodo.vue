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
  emits: ['add-todo'],
  methods: {
    addTodo() {
      if (this.newTodo.length >= 3) {
        this.$emit('add-todo', this.newTodo);
        this.newTodo = '';
      }
    },
  },
};
</script>
