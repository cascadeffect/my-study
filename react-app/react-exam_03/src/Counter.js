import React, { useState } from 'react';
// ㄴ 상태를 쓰기 위해 import 필수

const Counter = () => {
  /*
  useState()
    - 리액트 메서드
    - 배열을 반환하고, 배열의 비구조화 할당을 통해 0번째 인덱스를 count, 1번째 index를 setCount로 받음
    - count는 상태의 값 => jsx에서 리턴하여 화면에 표시 가능
    - setCount는 count의 상태를 변화시키는 상태 변화 함수
    - useState 메서드를 호출하면서 넘겨준 인자 0은 count 상태의 초기값
    - count의 상태가 바뀔 때마다 Counter 함수가 리턴을 다시 함 => Re-render
    - 컴포넌트는 자신이 가진 상태가 바뀔 때마다 화면을 다시 그려 Re-render를 함, 즉 함수가 다시 호출됨
  */
  const [count, setCount] = useState(0);

  const onIncrease = () => {
    setCount(count + 1);
  };

  const onDecrease = () => {
    setCount(count - 1);
  };

  // 한 컴포넌트에 여러 상태를 만들 수 있음
  // 그러나 결국 상수이기 때문에 이름이 겹치면 안 됨
  const [count2, setCount2] = useState(0);

  const onIncrease2 = () => {
    setCount2(count2 + 1);
  };

  const onDecrease2 = () => {
    setCount2(count2 - 1);
  };

  // count: 동적으로 변하는 유일한 값
  // -> 0에서 출발하고, 1씩 증가하거나 감소하는 count 상태
  return (
    <div>
      <h2>{count}</h2>
      <button onClick={onIncrease}>+</button>
      <button onClick={onDecrease}>-</button>

      <h2>{count2}</h2>
      <button onClick={onIncrease2}>+</button>
      <button onClick={onDecrease2}>-</button>
    </div>
  );
};

export default Counter;
