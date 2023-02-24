/*
async
  -> Promise처럼 비동기 작업을 다루는 기능이자 Promise를 더 쉽게 이용할 수 있도록 도움
await
  -> 비동기 함수를 동기 함수처럼 작동할 수 있도록 도움
*/

function hello() {
  return 'hello';
}

// delay: ms를 파라미터로 받아 ms만큼 대기했다가 끝나는 비동기 함수
function delay(ms) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}

// async 키워드 => Promise 객체를 리턴하는 비동기 처리 함수 생성
async function helloAsync() {
  // helloAsync 함수의 리턴값 == delay 함수의 결과값
  return delay(3000).then(() => {
    return 'hello async';
  });
}

console.log(hello()); // 출력: hello
console.log(helloAsync()); // 출력: Promise {<pending>}

// helloAsync가 Promise를 반환하고 있다는 것은 호출할 필요 없이 then을 사용할 수 있다는 뜻
helloAsync().then((res) => {
  // async 키워드가 붙은 함수의 리턴값 == 비동기 작업 객체 Promise의 resolve의 결과값
  console.log(res); // 출력: hello async
});

async function helloAsyncWithAwait() {
  // await 키워드 => 비동기 함수가 동기 함수처럼 작동
  // - await 키워드가 붙은 함수 호출이 끝나기 전까지 아래 코드 실행 X
  // - async 키워드가 붙은 함수 내에서만 사용 가능
  await delay(3000);
  return 'hello async';
}

// 예제) async & await => 비동기 함수 호출
async function main() {
  const res = await helloAsync();
  console.log(res);
}
main();
