let arr = [];
let a; // undefined

const arrStatus = arr.length === 0 ? '빈 배열' : '안 빈 배열';
console.log(arrStatus);

const aResult = a ? true : false;
console.log(aResult);

const arrResult = arr ? true : false;
console.log(arrResult);

// TODO: 학점 계산 프로그램
// 90점 이상 100점 이하: A+
// 50점 이상 89점 이하: B+
// 49점 이하: F

const score = 89;
grade = score >= 90 ? 'A+' : score >= 50 ? 'B+' : 'F';
console.log(grade);
