import React, { useRef, useState } from 'react';

const DiaryEditor = ({ onCreate }) => {
  // 데이터 타입부터 동작 방식까지 완전히 같은 두 State의 경우 하나의 State 객체로 만들 수 있음
  // const [author, setAuthor] = useState(''); // 아래 코드로 대체
  // const [content, setContent] = useState(''); // 아래 코드로 대체
  const [state, setState] = useState({
    author: '',
    content: '',
    emotion: 5,
  });

  /*
  React.MutableRefObject
  - HTML의 DOM 요소에 접근하는 기능
  - useRef() 함수 호출 시 리턴값
  - Reference 객체
  */
  // useRef() 함수를 호출해서 리턴값을 상수에 저장 => Reference 객체
  const authorInput = useRef();
  const contentInput = useRef();

  const handleChangeState = (e) => {
    // console.log(e.target.name);
    // console.log(e.target.value);
    setState({
      ...state,
      // 괄호 표기법: 객체의 속성에 접근하는 방법 중 하나 (c.f. 점 표기법)
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = () => {
    // console.log(state);
    if (state.author.length < 1) {
      // alert('작성자는 최소 1글자 이상 입력해주세요.'); // 트렌디한 웹사이트는 alert 사용 X
      // (DOM 요소를 선택하는 useRef() 함수로 생성한) Reference 객체는 현재 가리키는 값을 current라는 property로 불러와서 사용 가능
      // authorInput.current: input 태그
      // authorInput.current.focus(): input 태그에 포커스 하는 기능
      authorInput.current.focus();
      return;
    }

    if (state.content.length < 5) {
      contentInput.current.focus();
      return;
    }

    onCreate(state.author, state.content, state.emotion);
    alert('저장되었습니다.');
    setState({
      author: '',
      content: '',
      emotion: 5,
    }); // 일기 생성 후 작성 폼 초기화
  };

  return (
    <div className='DiaryEditor'>
      <h2>오늘의 일기</h2>
      <div>
        {/* value를 State 값(author)으로 고정해놨기 때문에 상태 변화 함수(setAuthor)를 사용하지 않는 한 input에 어떤 입력을 해도 초기값이 바뀌지 않음 (로그인이 필요한 서비스의 경우 작성자 아이디 고정해놓기 좋을 듯?)
        => Props로 onChange 이벤트(값이 바뀌었을 때 수행) 사용
          - onChange 이벤트에 등록되는 콜백 함수는 이벤트 객체 e를 매개변수로 전달받게 됨
         */}
        <input
          /*
          ref
            - DOM 요소에 이름을 달아 접근하는 방법을 제공
            - id 속성을 대체
            - 특정 DOM에 작업을 해야 할 때, 즉 직접적으로 건드려야 할 때 사용

          왜 리액트 컴포넌트 안에서 id를 사용하면 안 될까?
            - HTML에서 DOM의 id는 유일해야 하는데 같은 컴포넌트를 여러 번 사용하는 상황에서는 중복 id를 가진 DOM이 여러 개 생김
            - ref는 전역적으로 작동하지 않고 컴포넌트 내부에서만 작동
            => 사용할 수는 있으나 권장하지 않음
            - 다른 라이브러리나 프레임워크와 함께 id를 사용해야 하는 상황이 발생하는 경우, 컴포넌트를 만들 때마다 id 뒷부분에 추가 텍스트를 붙여서(예: button01, button02, button03 ...) 중복 id가 발생하는 것을 방지
          */
          ref={authorInput}
          name='author'
          // value={author} // 아래 코드로 대체
          value={state.author}
          onChange={handleChangeState}
          /*
          onChange={(e) => {
            // e.target: 이벤트 대상 (이벤트가 발생한 target element)
            // console.log(e.target.value); // 이벤트 대상에 입력된 값 출력
            // console.log(e.target.name); // 이벤트 대상의 name 출력
            // setAuthor(e.target.value); // 상태 변화 함수를 통해 이벤트 대상에 입력된 값을 State 값으로 변경
            setState({
              // State 값을 변경할 때 상태 변화 함수로 변경할 값을 전달했던 것처럼, State 객체를 변경할 때는 새로운 객체를 전달해줘야 함
              author: e.target.value, // 변경한 값 전달
              content: state.content, // 본래 값 전달
            });
          }}
          */
          placeholder='작성자'
        />
      </div>
      <div>
        <textarea
          ref={contentInput}
          name='content'
          // value={content} // 아래 코드로 대체
          value={state.content}
          onChange={handleChangeState}
          /*
          onChange={(e) => {
            // setContent(e.target.value); // 아래 코드로 대체
            setState({
              // ...(spread 연산자): 객체가 가진 property를 펼쳐줌
              // - 본래 값을 유지해야 하는 값이 많을 경우 spread 연산자를 통해 간단하게 처리 가능
              // - 순서 중요
              ...state,
              content: e.target.value,
            });
          }}
          */
          placeholder='내용'
        />
      </div>
      <div>
        감정 점수:
        <select name='emotion' value={state.emotion} onChange={handleChangeState}>
          {/* 리액트에서 변수 또는 문자열 외의 값을 프로퍼티로 전달할 때는 따옴표 대신 중괄호를 사용 */}
          <option value={1}>1</option>
          <option value={2}>2</option>
          <option value={3}>3</option>
          <option value={4}>4</option>
          <option value={5}>5</option>
        </select>
      </div>
      <div>
        <button onClick={handleSubmit}>저장하기</button>
      </div>
    </div>
  );
};

export default DiaryEditor;
