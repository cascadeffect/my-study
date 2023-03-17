/*
Truthy: JS에서 true가 아니어도 true로 취급되는 값
  e.g., [], {}, Infinity, ' ', " " 등을 포함하여 Falsy를 제외한 모든 값
Falsy: JS에서 false가 아니어도 false로 취급되는 값
  e.g., null, undefined, 0, -0, NaN, '', ""
*/

if (0) {
  console.log('TRUE');
} else {
  console.log('FALSE');
}

const getName = (person) => {
  if (!person) {
    // NOT false = true
    return '객체가 아닙니다.';
  }
  return person.name;
};

let person = { name: '최현지' };
const name = getName(person);
console.log(name);
