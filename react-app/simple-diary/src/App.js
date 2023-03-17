import { useRef, useState } from 'react';
import './App.css';
import DiaryEditor from './DiaryEditor';
import DiaryList from './DiaryList';
// import 컴포넌트 from '경로';

// const dummyList = [
//   {
//     id: 1,
//     author: 'Cade',
//     content: '리액트 1',
//     emotion: 4,
//     created_date: new Date().getTime(), // new Date(): 현재 시각, getTime(): 시각을 ms로 변환
//   },
//   {
//     id: 2,
//     author: 'Gone',
//     content: '스프링부트 1',
//     emotion: 5,
//     created_date: new Date().getTime(),
//   },
//   {
//     id: 3,
//     author: 'Cade',
//     content: '리액트 2',
//     emotion: 3,
//     created_date: new Date().getTime(),
//   },
// ];

function App() {
  // 일기 리스트를 저장하는 State
  const [data, setData] = useState([]);

  // 리액트에서 DOM을 직접 선택해야 하는 경우, ref 사용
  // 함수형 컴포넌트에서 ref를 사용하는 경우, useRef라는 Hook 함수 사용
  const dataId = useRef(0);

  // 일기 생성 함수
  const onCreate = (author, content, emotion) => {
    const created_date = new Date().getTime();
    const newItem = {
      author,
      content,
      emotion,
      created_date,
      id: dataId.current, // 어떤 DOM도 선택하지 않고 0이라는 값을 가리킴
    };
    dataId.current += 1;
    setData([newItem, ...data]); // 새로운 일기(맨 앞) + 원래 일기
  };

  // 일기 수정 함수
  const onEdit = (targetId, newContent) => {
    setData(data.map((it) => (it.id === targetId ? { ...it, content: newContent } : it)));
  };

  // 일기 삭제 함수
  const onRemove = (targetId) => {
    // console.log(`${targetId}가 삭제되었습니다.`); // value check
    const newDiaryList = data.filter((it) => it.id !== targetId); // data 배열의 각 요소의 id가 targetId와 다른 경우, 해당 요소를 리턴 (=> 삭제하려는 일기를 뺀 나머지 일기 리스트 리턴)
    console.log(newDiaryList);
    setData(newDiaryList);
  };

  return (
    <div className='App'>
      {/* DiaryEditor 컴포넌트에 onCreate 함수를 Prop으로 내려주기 */}
      <DiaryEditor onCreate={onCreate} />
      {/* DiaryItem onDelete 함수를 Prop으로 내려주기 위해 DiaryList 컴포넌트에 먼저 onDelete 함수를 Prop으로 내려주기 (Props Drilling) */}
      <DiaryList onEdit={onEdit} onRemove={onRemove} diaryList={data} />
      {/* <DiaryList diaryList={undefined} /> dummyList 대신 undefined를 전달하면 에러 발생 */}
    </div>
  );
}

export default App;
