import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

// index.js를 고치면 새고 필요

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* App: 최상위 부모 */}
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
