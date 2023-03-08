// 컴포넌트를 다른 컴포넌트의 Props로 전달하여 스타일 적용
const Container = ({ children }) => {
  console.log(children);
  return <div style={{ margin: 20, padding: 20, border: '1px solid black' }}>{children}</div>;
};

export default Container;
