/*
비 구조화 (구조 분해) 할당
  -> 배열이나 객체의 속성을 해체하여 그 값을 개별 변수에 담을 수 있게 하는 JS 표현식
*/

// 1. 배열의 비 구조화 할당
//  -> 인덱스를 기준으로 변수에 저장

let arr = ['one', 'two', 'three'];

let one0 = arr[0];
let two0 = arr[1];
let three0 = arr[2];

let [one1, two1, three1, four1] = arr;
let [one2, two2, three2, four2 = 'default'] = ['one', 'two', 'three'];

console.log(one0, two0, three0);
console.log(one1, two1, three1, four1);
console.log(one2, two2, three2, four2);

let a = 10;
let b = 20;
[a, b] = [b, a];
console.log(a, b);

// 2. 객체의 비 구조화 할당
// -> 키 값을 기준으로 변수에 저장
let obj = { name: '최현지', one: 'one', two: 'two', three: 'three', sex: '여' };

let one3 = obj['one'];
let two3 = obj.two;
let three3 = obj.three;

let { one4, two4, three4 } = obj; // FAIL
let { one, two, three, name, sex: gender, age = 25 } = obj;

console.log(one3, two3, three3);
console.log(one4, two4, three4); // undefined
console.log(one, two, three, name, gender, age);
