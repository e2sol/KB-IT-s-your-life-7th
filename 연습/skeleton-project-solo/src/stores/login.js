import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useLoginStore = defineStore('login', () => {
  // states
  const user = ref({});

  // getters

  // actions
  const login = async (id, pw) => {
    let userList = [];

    const resp = await axios.get('/api/user');
    // console.log(resp.data);

    userList = resp.data;

    for (let i = 0; i < userList.length; i++) {
      if (id === userList[i].userID) {
        if (userList[i].userPW === pw) {
          user.value = userList[i];
        }
        // 비밀번호 불일치 경고 추가 필요
      }
      // 해당 아이디를 가진 유저 없다는 경고 추가 필요
      //   console.log('if문 바로 밖의 user', user.value);
    }
    // console.log('for문 바로 밖의 user', user.value);
  };

  return { user, login };
});
