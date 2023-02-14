/*
Spread(전개 구문)
  -> ... 연산자를 사용하여 객체의 프로퍼티들을 다른 객체에 펼쳐주는 역할
*/

// 1. 객체
const cookie = {
  base: 'cookie',
  madeIn: 'koread',
};
const chocochipCookie = {
  ...cookie,
  toping: 'chocochip',
};
const blueberryCookie = {
  ...cookie,
  toping: 'blueberry',
};
const strawberryCookie = {
  ...cookie,
  toping: 'strawberry',
};
console.log(chocochipCookie);
console.log(blueberryCookie);
console.log(strawberryCookie);

// 2. 배열
const noTopingCookies = ['촉촉한쿠키', '안촉촉한쿠키'];
const yesTopingCookies = ['바나나쿠키', '블루베리쿠키', '딸기쿠키', '초코칩쿠키'];
// concat 대신 사용 가능, 중간에 다른 값 삽입 가능
const allCookies = [...noTopingCookies, '함정쿠키', ...yesTopingCookies];
console.log(allCookies);
