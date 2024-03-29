import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

// id값이 root인 태그로 렌더링 (root 태그는 public > index.html에 위치)
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // React.StrictMode: 앱 내의 잠재적인 문제를 알아내기 위한 도구로 Fragment와 같이 UI를 렌더링하지 않으며, 자손들에 대한 부가적인 검사와 경고를 활성화 (개발모드에만 영향)
  // I don't know why it make the component, App, works twice
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
