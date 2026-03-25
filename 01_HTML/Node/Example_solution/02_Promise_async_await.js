// 현재 디렉토리 항목을 읽어서 출력 -> fs 모듈 이용
// promise 적용 모듈 이용 -> fs.promises.readdir(path)
// error 처리 코드 포함

const fs = require('fs');

function promDir() {
  return (fileList = fs.promises.readdir('./'));
}

promDir()
  .then(() => {
    //   console.log(promDir); // [function: promDir]
    console.log(fileList); // 배열로 출력
  })
  .catch((err) => {
    console.error(err);
  });

// async / await를 이용해 다시 작성
async function asyPromDir() {
  const asyFileList = await fs.promises.readdir('./');
  console.log('\nasynce/await함수 이용:\n', asyFileList);
}
asyPromDir();
