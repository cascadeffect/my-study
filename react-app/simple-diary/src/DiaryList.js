import DiaryItem from './DiaryItem';

const DiaryList = ({ onEdit, onRemove, diaryList }) => {
  // console.log(diaryList);
  return (
    <div className='DiaryList'>
      <h2>일기 리스트</h2>
      <h4>{diaryList.length}개의 일기가 있습니다.</h4>
      <div>
        {/*
        <div>일기아이템</div>
        <div>일기아이템</div>
        <div>일기아이템</div>
        */}
        {diaryList.map((it, idx) => (
          // it 객체(일기 하나)에 포함된 모든 데이터를 spread 연산자를 통해 DiaryItem에게 prop으로 전달
          <DiaryItem key={it.id} {...it} onEdit={onEdit} onRemove={onRemove} />
          /*
          NOTE: Warning: Each child in a list should have a unique "key" prop.
            - <div>... 작성자 ... 내용 ... 감정 ... 작성일시 ...</div> 컴포넌트가 고유한 key prop을 가져야 함
            1. it.id를 통해 데이터의 고유한 id 사용 -> 권장
            2. 내장 함수 map의 콜백 함수의 두 번째 파라미터인 idx 사용 -> 데이터를 수정/삭제/추가해서 인덱스들의 순서가 바뀔 때 문제 발생 여지 O
          */
          // <div key={idx}>
          //   <div>작성자: {it.author}</div>
          //   <div>내용: {it.content}</div>
          //   <div>감정: {it.emotion}</div>
          //   <div>작성일시(ms): {it.created_date}</div>
          // </div>
        ))}
      </div>
    </div>
  );
};

// 컴포넌트.defaultProps: 컴포넌트에 undefined로 전달될 가능성이 있는 props의 기본값 설정
DiaryList.defaultProps = {
  diaryList: [],
};

export default DiaryList;
