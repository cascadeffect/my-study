/* 
동기 (블로킹 방식)
  - JS는 코드가 작성된 순서대로 작업을 처리
  - 이전 작업이 진행 중일 때는 다음 작업을 수행하지 않고 대기
  - 먼저 작성된 코드가 다 실행되고 나서 뒤에 작성된 코드 실행
  - 하나의 작업이 너무 오래 걸리는 경우, 전반적인 작업 속도 저하
  - 멀티 쓰레드(MultiThread)로 작업 분할 가능하나, JS는 싱글 쓰레드 방식으로 동작
비동기 (논 블로킹 방식)
  - 먼저 작성된 코드의 결과를 기다리지 않고 다음 코드를 바로 실행
  - 여러 개의 작업 동시에 실행 가능
  - 싱글 쓰레드 방식을 이용하면서 동기 작업의 단점 극복 가능
  - 콜백 함수를 통해 작업이 끝났는지와 작업 결과 확인
  
  * 쓰레드
  * 멀티 쓰레드
  * 싱글 쓰레드
*/

/* 
JS 엔진은 어떻게 동기와 비동기를 구분하여 수행하는가?
  - JS 코드는 웹 브라우저에 탑재되어 있는 엔진을 통해 실행됨
  - JS 엔진은 Heap과 Call Stack으로 이루어져 있음
  - Heap은 변수와 상수 등에 사용되는 메모리를 저장하는 영역
  - Call Stack은 작성한 코드의 실행에 따라 호출 스택을 쌓는 영역
  - Call Stack에 가장 먼저 쌓이는 Main Context(JS 최상위 문맥)가 Call Stack에 들어오는 순간이 프로그램 실행 순간, 나가는 순간이 프로그램 종료 순간
  - JS는 비동기 함수를 Web APIs로 넘김
  - 비동기 함수가 Web APIs에서 대기하는 동안 Call Stack은 동기 작업을 계속 수행
  - Web APIs 내 비동기 함수는 대기가 끝나면 제거가 되고, 남은 콜백 함수는 Callback Queue에 옮겨짐
  - Event Loop를 통해 Callback Queue에 옮겨진 콜백 함수를 Call Stack으로 다시 옮김
  - Event Loop는 Call Stack에 Main Context 외 다른 함수가 남아 있지 않은지 계속 확인
*/

function taskA(a, b, callback) {
  // setTimeout(() => {}, ms): 비동기 함수, 콜백 함수와 ms를 파라미터로 가짐
  setTimeout(() => {
    // 지역 상수: 특정 scope 안에서만 유효한 상수
    const res = a + b;
    // 콜백 함수 실행
    callback(res);
  }, 3000);
}

function taskB(a, callback) {
  setTimeout(() => {
    const res = a * 2;
    callback(res);
  }, 1000);
}

function taskC(a, callback) {
  setTimeout(() => {
    const res = a * -1;
    callback(res);
  }, 2000);
}

// 콜백 함수를 함수의 인자로 전달
// taskA(3, 5, (res) => {
//   console.log('task A result:', res);
// }); // # 4

// taskB(7, (res) => {
//   console.log('task B result:', res);
// }); // # 2

// taskC(14, (res) => {
//   console.log('task C result:', res);
// }); // # 3

taskA(4, 5, (a_res) => {
  console.log('task A result:', a_res); // # 1
  taskB(a_res, (b_res) => {
    console.log('task B result:', b_res); // # 2
    taskC(b_res, (c_res) => {
      console.log('task C resul:', c_res); // # 3
    });
  });
});

// 콜백 함수에 콜백 함수를 넣어서 비동기 처리의 결과 값을 또 다른 비동기 처리의 인자 값으로 전달 가능

console.log('코드 끝'); // # 1
