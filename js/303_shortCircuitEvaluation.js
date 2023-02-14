/*
단락회로 평가(Short Circuit Evaluation)
  -> 왼쪽에서 오른쪽으로 연산하는 논리 연산자의 연산 순서를 이용하는 문법으로, 피연산자 중 뒤에 위치한 피연산자를 확인할 필요 없이 연산을 끝내는 것
 */
console.log(true && true); // 단락회로 평가 X
console.log(false && true); // 단락회로 평가 O

console.log(false || false); // 단락회로 평가 X
console.log(true || false); // 단락회로 평가 O

console.log(!true);

const getName = (person) => {
  // if (!person) {
  //   return '객체가 아닙니다.';
  // }
  // return person.name;

  // 단락회로 평가 사용
  const name = person && person.name;
  // ㄴ person이 falsy하면 person.name을 보지 않고 person 할당, truthy하면 person.name 할당
  return name || '객체가 아닙니다.';
  // ㄴ name이 truthy하면 '객체가 아닙니다.'를 보지 않고 name 리턴, falsy하면 '객체가 아닙니다.' 리턴
};
let person = { name: '최현지' };
const name = getName(person);
console.log(name);
