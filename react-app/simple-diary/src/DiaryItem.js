import { useState, useRef } from 'react';

const DiaryItem = ({ onEdit, onRemove, id, author, content, emotion, created_date }) => {
  // 수정 중(true)인지 아닌지(false) State
  const [isEdit, setIsEdit] = useState(false);

  // 호출되는 순간 isEdit State의 값을 반전시키는 함수 (true <-> false)
  const toggleIsEdit = () => setIsEdit(!isEdit);

  // textarea 값 State
  const [localContent, setLocalContent] = useState(content);
  // textarea를 선택할 DOM 요소
  const localContentInput = useRef();

  // 수정 취소 이벤트 핸들러 함수
  const handleQuitEdit = () => {
    toggleIsEdit(); // 수정 중 상태 false로 변경
    setLocalContent(content); // textarea 값을 기존 값으로 초기화
  };

  // 수정 이벤트 핸들러 함수
  const handelEdit = () => {
    if (localContent.length < 5) {
      localContentInput.current.focus();
      return;
    }
    if (window.confirm(`${id}번 일기를 수정하시겠습니까?`)) {
      onEdit(id, localContent);
      toggleIsEdit();
    }
  };

  // 삭제 이벤트 핸들러 함수
  const handleRemove = () => {
    // console.log(id); // 해당 일기의 고유한 id 출력
    if (window.confirm(`${id}번 일기를 정말 삭제하시겠습니까?`)) {
      onRemove(id);
    }
  };

  return (
    <div className='DiaryItem'>
      <div className='info'>
        <span>
          작성자: {author} | 감정점수: {emotion}
        </span>
        <br />
        <span className='date'>{new Date(created_date).toLocaleDateString()}</span>
      </div>
      <div className='content'>
        {isEdit ? (
          <>
            <textarea ref={localContentInput} value={localContent} onChange={(e) => setLocalContent(e.target.value)} />
          </>
        ) : (
          <>{content}</>
        )}
      </div>
      {isEdit ? (
        <>
          <button onClick={handleQuitEdit}>취소</button>
          <button onClick={handelEdit}>완료</button>
        </>
      ) : (
        <>
          <button onClick={toggleIsEdit}>수정하기</button>
          <button onClick={handleRemove}>삭제하기</button>
        </>
      )}
    </div>
  );
};

export default DiaryItem;
