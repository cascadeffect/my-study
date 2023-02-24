import './App.css';
// useState is a kind of Hook
// Hook: 리액트에서 제공하는 기본적인 함수
import { useState } from 'react';

// 파라미터명은 일반적으로 props라고 사용하며, 데이터 타입은 객체
function Header(props) {
  console.log('props', props, props.title);
  return (
    <header>
      <h1>
        {/* 중괄호 사이 내용은 문자열 아닌 표현식으로 취급 */}
        <a
          href='/'
          onClick={(event) => {
            event.preventDefault();
            // The "props" argument has a "onChangeMode" function inside.
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Nav(props) {
  const li = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    li.push(
      // Tags automatically generated, such as the <li> tag, must have a "key" prop with a unique value.
      // If they does not have it, the warning below will appear.
      // WARNING: Each child in a list should have a unique "key" prop.
      // WHY? 자동 생성 태그의 경우, 리액트가 추적하기 위한 근거("key" prop)가 필요
      <li key={t.id}>
        <a
          // 숫자를 태그의 속성값으로 입력하면 문자열이 됨
          id={t.id}
          href={'/read/' + t.id}
          onClick={(event) => {
            event.preventDefault();
            // event.target: 이벤트를 발생시키는 태그
            props.onChangeMode(Number(event.target.id));
          }}
        >
          {t.title}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ol>{li}</ol>
    </nav>
  );
}

function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}

function Create(props) {
  return (
    <article>
      <h2>Create</h2>
      <form
        action=''
        onSubmit={(event) => {
          event.preventDefault();
          const title = event.target.title.value; // 이벤트가 발생한 form 태그 안의 name 속성값이 'title'인 태그의 value 속성값
          const body = event.target.body.value;
          props.onCreate(title, body);
        }}
      >
        <p>
          <input type='text' name='title' placeholder='title' />
        </p>
        <p>
          <textarea name='body' placeholder='body'></textarea>
        </p>
        <p>
          <button>Create</button>
        </p>
      </form>
    </article>
  );
}

function Update(props) {
  // "props"를 state로 (Update시 필수)
  const [title, setTitle] = useState(props.title);
  const [body, setBody] = useState(props.body);
  return (
    <article>
      <h2>Update</h2>
      <form
        action=''
        onSubmit={(event) => {
          event.preventDefault();
          const title = event.target.title.value;
          const body = event.target.body.value;
          props.onUpdate(title, body);
        }}
      >
        {/* 컴포넌트의 파라미터값은 컴포넌트를 호출할 때 유저가 내린 어명이나 다름없기 때문에 value 속성의 속성값으로 쓰이면 입력창에 입력/수정/삭제를 할 수 없게 됨 => "props"(외부자가 전달하는 데이터)를 state(내부자가 사용하는 데이터)로 변환*/}
        <p>
          {/* onChange 동작 시점
              HTML - 값이 변경되고 마우스 포인터가 입력창 밖으로 빠져나갈 때
              REACT - 값이 변경될 때마다 */}
          <input
            type='text'
            name='title'
            placeholder='title'
            value={title}
            onChange={(event) => {
              console.log(event.target.value);
              setTitle(event.target.value); // 값이 변경될 때마다 입력창의 값을 "title" state의 값으로 변경
            }}
          />
        </p>
        <p>
          <textarea
            name='body'
            placeholder='body'
            value={body}
            onChange={(event) => {
              setBody(event.target.value); // 값이 변경될 때마다 입력창의 값을 "body" state의 값으로 변경
            }}
          ></textarea>
        </p>
        <p>
          <button>Update</button>
        </p>
      </form>
    </article>
  );
}

function App() {
  /* const mode = 'WELCOME'; */ // Variable, 변수
  // useState(): 배열을 리턴, 그 배열의 0번째 원소는 상태의 값을 읽을 때 쓰는 데이터, 1번째 원소는 상태의 값을 변경할 때 쓰는 함수
  /*
  const _mode = useState('WELCOME'); // State, 상태
  const mode = _mode[0]; // 변수 mode의 값을 통해 상태 _mode의 값을 읽을 수 있음
  const setMode = _mode[1]; // 함수 setMode를 통해 상태 _mode의 값을 변경할 수 있음
  */
  const [mode, setMode] = useState('WELCOME'); // 위 코드 3줄 축약형
  const [id, setId] = useState(null);
  const [nextId, setNextId] = useState(4);
  const [topics, setTopics] = useState([
    { id: 1, title: 'html', body: 'html is ...' },
    { id: 2, title: 'css', body: 'css is ...' },
    { id: 3, title: 'js', body: 'js is ...' },
  ]);

  let content = null;
  let contextControl = null;
  if (mode === 'WELCOME') {
    content = <Article title='Welcome' body='Hello, Web!'></Article>;
  } else if (mode === 'READ') {
    let title,
      body = null;
    // "topics" list의 원소 개수만큼 반복
    for (let i = 0; i < topics.length; i++) {
      // "topics" list의 i번째 원소의 id값과 "id" state의 값 일치 여부 확인
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
    contextControl = (
      // 리액트에서 태그를 다룰 때는 하나의 태그 안에 들어 있어야 함
      // <>: 복수의 태그를 그룹핑할 때 사용하는 빈 태그
      <>
        <li>
          <a
            href={'/update' + id}
            onClick={(event) => {
              event.preventDefault();
              setMode('UPDATE');
            }}
          >
            Update
          </a>
        </li>
        <li>
          <button
            type='button'
            onClick={() => {
              const newTopics = [];
              for (let i = 0; i < topics.length; i++) {
                // 현재 위치한 상세 페이지가 아닌 페이지들의 id들을 빈 배열 newTopics에 삽입
                if (topics[i].id !== id) {
                  newTopics.push(topics[i]);
                }
              }
              setTopics(newTopics);
              setMode('WELCOME'); // 삭제 후, 상세 페이지 -> 웰컴 페이지
            }}
          >
            Delete
          </button>
        </li>
      </>
    );
  } else if (mode === 'CREATE') {
    content = (
      <Create
        onCreate={(_title, _body) => {
          const newTopic = { id: nextId, title: _title, body: _body };
          /* setTopics(newTopics); */ // It does not work as the data type of "topics" is a array, not primitive.
          const newTopics = [...topics]; // 1. 원본 복제 - [...Array] {...Object}
          newTopics.push(newTopic); // 2. 복제본 수정
          setTopics(newTopics); // 3. 복제본으로 변경 - 리액트가 원본과 복제본을 비교하여 다르면 컴포넌트를 다시 렌더링함 (참조 타입의 경우, 같은 데이터면 다시 렌더링 하지 않기 때문에 복제본 생성 필수)
          // 방금 생성한 "newTopic"의 상세 페이지를 나타내기 위해
          setMode('READ'); // 1. "mode" state 값을 'READ'로 변경 - 컴포넌트가 다시 렌더링 되지만, "id" state 값이 null이라 UI가 변경되지 않음
          setId(nextId); // 2. "id" state 값을 "nextId" state 값으로 변경 - "id" state 값이 "newTopic"의 "id" 값으로 업데이트 되어 이때 UI가 변경됨
          setNextId(nextId + 1); // 3. 다음 생성을 대비해 "nextId" state 값 업데이트
        }}
      ></Create>
    );
  } else if (mode === 'UPDATE') {
    let title,
      body = null;
    for (let i = 0; i < topics.length; i++) {
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = (
      <Update
        title={title}
        body={body}
        onUpdate={(_title, _body) => {
          console.log(_title, _body);
          const newTopics = [...topics]; // "topics" state가 배열이므로 그냥 수정 안 되니까 복제본 생성
          const updatedTopic = { id: id, title: _title, body: _body };
          for (let i = 0; i < newTopics.length; i++) {
            if (newTopics[i].id === id) {
              newTopics[i] = updatedTopic;
              break;
            }
          }
          setTopics(newTopics);
          setMode('READ');
        }}
      ></Update>
    ); // 컴포넌트를 호출할 때 넘겨준 prop 값들은 어명이나 다름없음
  }

  return (
    <div>
      <Header
        title='Web'
        onChangeMode={() => {
          setMode('WELCOME');
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(_id) => {
          setMode('READ'); // After this code, the "App" component restarts. "useState" resets the value of "mode" to 'READ'. The value of "content" will be changed to the content related to 'READ'.
          setId(_id);
        }}
      ></Nav>
      {content}
      <ul>
        <li>
          <a
            href='/create'
            onClick={(event) => {
              event.preventDefault();
              setMode('CREATE');
            }}
          >
            Create
          </a>
        </li>
        {contextControl}
      </ul>
    </div>
  );
}

export default App;
