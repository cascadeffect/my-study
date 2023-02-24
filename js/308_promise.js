/* 
Promise 객체
  -> JS의 콜백 지옥을 해결 가능

비동기 작업이 가질 수 있는 3가지 상태
  1. Pending(대기): 현재 비동기 작업이 진행 중이거나 작업이 시작할 수 없는 문제가 발생한 상태
  2. Fulfilled(이행/성공): 비동기 작업이 의도한 대로 정상적으로 완료된 상태
  3. Rejected(거부/실패): 비동기 작업이 실패한 상태 e.g., 서버 미응답, 시간이 오래 걸려 자동 취소 등

  - resolve(해결): Pending -> Fulfilled
  - reject(거부): Pending -> Rejected
*/

// 1. 콜백 함수를 사용하여 비동기 처리
function isPositiveByCallback(number, resolve, reject) {
  setTimeout(() => {
    if (typeof number === 'number') {
      // 성공 => resolve
      resolve(number >= 0 ? '양수' : '음수');
    } else {
      // 실패 => reject
      reject('주어진 값이 숫자가 아닙니다.');
    }
  }, 2000);
}

// isPositiveByCallback(
//   -10,
//   (res) => {
//     console.log('Fulfilled:', res);
//   },
//   (err) => {
//     console.log('Rejected:', err);
//   }
// );

// 2. Promise 객체를 사용하여 비동기 처리
// 리턴 타입이 Promise인 함수 => 해당 함수는 비동기 작업을 하고, 작업의 결과를 Promise 객체로 반환받아 사용할 수 있는 함수
function isPositiveByPromise(number) {
  // 실행자(executor): 비동기 작업을 실질적으로 수행하는 함수 저장
  const executor = (resolve, reject) => {
    setTimeout(() => {
      if (typeof number === 'number') {
        // 성공 => resolve
        resolve(number >= 0 ? '양수' : '음수');
      } else {
        // 실패 => reject
        reject('주어진 값이 숫자가 아닙니다.');
      }
    }, 2000);
  };

  // 비동기 작업 자체인 Promise를 저장할 상수(asyncTask)를 생성하고, new 키워드를 사용하여 Promise 객체를 생성하며 생성자의 인자로 비동기 작업의 실질적인 실행자 함수(executor)를 전달
  // => 자동으로 실행자 함수(executor) 바로 실행
  const asyncTask = new Promise(executor);
  // Promise 객체 타입 상수(asyncTask) 리턴
  // => 어떤 함수가 Promise 객체를 리턴한다는 것은 이 함수는 비동기 작업을 하고, 해당 작업의 결과를 Promise 객체로 반환받아서 사용할 수 있는 함수
  return asyncTask;
}

// 상수(res)에 반환된 Promise 객체 저장
const res = isPositiveByPromise([]);
// Promise 객체 내장 메서드
// 1. then: 비동기 작업이 Fulfilled 됐을 때, 즉 리턴된 Promise 객체의 resolve 함수 실행
// 2. catch: 비동기 작업이 Rejected 됐을 때, 즉 리턴된 Promise 객체의 reject 함수 실행
res
  .then((res) => {
    console.log('Fulfilled:', res);
  })
  .catch((err) => {
    console.log('Rejected:', err);
  });

// 3. Promise 객체로 콜백 지옥 탈출하기

// 모든 함수의 인자에서 콜백 함수 제거하고, 리턴문에서 Promise 객체 생성할 때 resolve와 reject를 인자로 한 실행자 함수를 생성자의 인자로 전달
function taskA(a, b) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const res = a + b;
      resolve(res);
    }, 3000);
  });
}

function taskB(a) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const res = a * 2;
      resolve(res);
    }, 1000);
  });
}

function taskC(a) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const res = a * -1;
      resolve(res);
    }, 2000);
  });
}

// 콜백 지옥 탈출
// 1. taskA 함수 실행
// 2. Promise 객체 리턴
// 3. 비동기 작업이 성공하면 Promise 객체의 then 메서드를 사용하여 resolve 함수 실행
// 4. taskB 함수의 리턴 값을 리턴
// 5. (반복)
// => then chaining
taskA(5, 1)
  .then((a_res) => {
    console.log('task A result:', a_res);
    return taskB(a_res);
  }) // 여기까지 taskB(arg)와 같음 (위/아래 분리 가능)
  .then((b_res) => {
    console.log('task B result:', b_res);
    return taskC(b_res);
  }) // 여기까지 taskC(arg)와 같음 (위/아래 분리 가능)
  .then((c_res) => {
    console.log('task C result:', c_res);
  });

// 위/아래 분리
const bPromiseResult = taskA(10, 3)
  .then((a_res) => {
    console.log('task A result:', a_res);
    return taskB(a_res);
  })
  .then((b_res) => {
    console.log('task B result:', b_res);
    return taskC(b_res);
  });

console.log('lorem'); // 위/아래 분리

bPromiseResult.then((c_res) => {
  console.log('task C result:', c_res);
});

// 콜백 지옥
// taskA(4, 5, (a_res) => {
//   console.log('task A result:', a_res); // # 1
//   taskB(a_res, (b_res) => {
//     console.log('task B result:', b_res); // # 2
//     taskC(b_res, (c_res) => {
//       console.log('task C resul:', c_res); // # 3
//     });
//   });
// });
