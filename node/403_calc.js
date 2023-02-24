// 계산기 파일 == 계산 기능 모듈

const add = (a, b) => a + b;
const sub = (a, b) => a - b;

// module.exports => 객체 단위로 모듈 내보내기
module.exports = {
  moduleName: 'calc module', // moduleName: '모듈 이름'
  add: add, // 함수별칭: 함수명
  sub: sub, // 함수별칭: 함수명
};
