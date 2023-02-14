/* 배열 내장 함수
1. forEach
  -> 배열의 요소에 순차적으로 접근
2. map, return
  -> 배열의 각 요소에 대해 콜백 함수 실행, 콜백 함수에서 return 사용 가능, 리턴한 값을 요소로 생성된 새로운 배열을 리턴
3. includes
  -> === 연산을 통해 배열에 특정 값이 있는지 확인하여 boolean 타입 리턴
4. indexOf
  -> 배열에 특정 값이 있으면 인덱스 리턴, 없으면 -1 리턴
5. findIndex
  -> 특정 속성을 갖는 요소의 인덱스 리턴, 중복된 값이 있으면 가장 앞에 있는 요소의 인덱스 리턴
6. find
  -> 특정 속성을 갖는 요소 자체를 리턴
7. filter
  -> 배열에서 특정한 조건을 만족하는, 즉 콜백 함수가 true를 리턴하는 모든 요소를 배열로 리턴
8. slice(start, end)
  -> 배열의 인덱스를 통해 자른 배열을 리턴
9. sort
  -> 원본 배열을 문자열 기준으로 사전순 정렬하여 리턴
10. join
  -> 배열의 각 요소를 합쳐서 문자열로 리턴, 구분자 사용 가능
*/

const numList = [0, 1, 3, 2, 10, 30, 20];
const newList = numList.map((elem) => {
  return elem * 2;
});

let num = 3;

const objList = [
  { num: 1, color: 'red' },
  { num: 2, color: 'black' },
  { num: 3, color: 'blue' },
  { num: 4, color: 'green' },
  { num: 5, color: 'blue' },
];

const objList1 = objList.slice(0, 2);
const objList2 = objList.slice(2);

let charList = ['나', '다', '가'];

const strList = ['최현지님', '안녕하세요', '또오셨군요'];

numList.forEach((elem) => console.log(elem * 2));

// const newList = [];
// numList.forEach((elem) => newList.push(elem * 2));

console.log(newList);

numList.forEach((elem) => {
  if (elem == num) {
    console.log(true);
  }
});

console.log(numList.includes(num));

console.log(numList.indexOf(num));

console.log(
  objList.findIndex((elem) => {
    return elem.color === 'green';
  })
);

// console.log(objList.findIndex((elem) => elem.color === 'green')); // 상동

const idx = objList.findIndex((elem) => elem.color === 'blue');
console.log(objList[idx]);

const elm = objList.find((elem) => elem.color === 'blue');
console.log(elm);

console.log(objList.filter((elem) => elem.color === 'blue'));

console.log(objList.slice(0, 2));

console.log(objList1.concat(objList2));

console.log(charList.sort());

console.log(numList.sort());

// 비교 함수 작성
const compare = (a, b) => {
  if (a > b) {
    return 1; // 오름차순
    // return -1; // 내림차순
  }
  if (a < b) {
    return -1; // 오름차순
    // return 1; // 내림차순
  }
  return 0;
};
numList.sort(compare);
console.log(numList);

console.log(strList.join(', '));
