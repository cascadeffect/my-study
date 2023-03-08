import React from 'react';
// import './App.css';

import MyHeader from './MyHeader';
import Counter from './Counter';
import Container from './Container';

function App() {
  /*
  Props
  - 부모 컴포넌트인 App 컴포넌트에서 자식 컴포넌트인 Counter 컴포넌트에게 어떤 값을 이름을 붙여 전달하는 방식 또는 그 데이터
  */

  const counterProps = {
    a: 1,
    b: 2,
    c: 3,
    d: 4,
    e: 5,
    // initialValue: 5,
  };

  return (
    // Container 컴포넌트(부모) 사이에 배치된 JSX 요소들(자식)은 Container 컴포넌트의 children이라는 Props로 전달됨
    <Container>
      <div>
        <MyHeader />
        {/* Counter 컴포넌트에게 initialValue라는 이름으로 5라는 값 전달 */}
        {/* <Counter a={1} b={2} c={3} d={4} e={5} initialValue={5} /> */}
        <Counter {...counterProps} />
      </div>
    </Container>
  );
}

export default App;
