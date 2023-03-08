// Props로 정적인 데이터뿐 아니라 동적인 데이터(ex. State)도 전달할 수 있음
const OddEvenResult = ({ count }) => {
  // 리액트의 컴포넌트는 부모가 전달해 준 Props가 변경되면 Re-render
  // 심지어 Props를 전달받지 않아도 부모의 State가 변경되면 Re-render
  console.log('Re-render');
  return <>{count % 2 === 0 ? '짝수' : '홀수'}</>;
};

export default OddEvenResult;

/*
Re-render
  1. 자신이 가진 State가 변경되는 경우
  2. 부모로부터 전달받은 Props가 변경되는 경우
  3. 부모가 Re-render가 되는 경우
*/
