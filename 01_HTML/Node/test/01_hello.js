function hello() {
  console.log('Node program');
}

// backend의 경우 함수를 따로 호출하지 않으면 확인 불가
// 밖에서 따로 함수를 호출하는 부분이 존재하지 않는다
hello();

// npm(node package manager)은 자바스크립트 패키지 매니저이다.
// Node.js에서 사용할 수 있는 모듈들을 패키지화하여 모아둔 저장소 역할과
// 패키지 설치 및 관리를 위한 CLI(Command line interface)를 제공한다.
// 자신이 작성한 패키지를 공개할 수도 있고 필요한 패키지를 검색하여 재사용할 수도 있다.
// init : 첫 파일을 만들어주는 개념
