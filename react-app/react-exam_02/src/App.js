import React from 'react';
// import './App.css'; // CSS styling

import MyHeader from './MyHeader';

function App() {
  /*
  JSX (JavaScript XML)
  - HTML과 JS와 합쳐서 사용할 수 있는 문법
  - JS의 변수나 함수 같은 값을 HTML에 쉽게 포함해서 사용 가능
  1. 닫힘 규칙: JSX element has no corresponding closing tag.
  2. 최상위 태그 규칙: JSX expressions must have on parent element.
    - import React from 'react'; 를 통해 <React.Fragment></React.Fragment> 또는 <></>로 최상위 태그 대체 가능
  - class 대신 className 사용
  */

  let name = 'Cade';

  // Inline styling
  const style = {
    App: {
      backgroundColor: 'skyblue',
    },
    h2: {
      color: 'red',
    },
    bold_text: {
      color: 'green',
    },
  };

  const number = 5;

  return (
    <div style={style.App} className='App'>
      <MyHeader />
      <h2 style={style.h2}>Hello React with {name}</h2>
      <b style={style.bold_text} id='bold_text'>
        {number}는 {number % 2 === 0 ? '짝수' : '홀수'} {/* 조건부 렌더링 */}
      </b>
    </div>
  );
}

export default App; // ES Modules

/*
CommonJS
  - module.exports={...};
  - 다른 패키지를 불러오거나 Create React App 같은 Boiler Plate를 사용하지 않고 직접 구축할 때 사용

ES Modules
  - exports default ...;
  - React가 주로 사용하는 Module System
  - 다른 파일에서 import (원하는)이름 from "경로"; 를 통해 사용 가능
  - exports default로는 1개만 내보내기 가능
*/
