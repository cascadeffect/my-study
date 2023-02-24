/*
API(Application Programming Interface)
  - 응용 프로그램에서 사용할 수 있도록 운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스
  - 주로 파일 제어, 창 제어, 화상 처리, 문자 제어 등을 위한 인터페이스를 제공
  - 두 소프트웨어 구성 요소가 서로 통신할 수 있게 하는 메커니즘

API 호출
  -> 클라이언트(Client)는 서버(Server)에게 데이터를 요청(Request)하고, 서버는 클라이언트에게 요청 데이터를 전달(Response)하는 과정

=> API란, 쉽게 말해서 클라이언트-서버처럼 프로그램 간 연결 다리이자 대화를 할 수 있는 방법
*/

/*
fetch
  - API 호출을 할 수 있도록 도와주는 JS 내장 함수
  - Promise 객체 리턴 => 비동기 처리 함수 => then을 통해 함수의 처리 결과 사용
  - API의 결과값을 바로 리턴하는 게 아니라 API의 성공 객체(e.g., 포장지)를 리턴
*/

let response = fetch('https://jsonplaceholder.typicode.com/posts').then((res) => {
  console.log(res);
});

// 객체 -> JSON (e.g., 포장지 뜯기)
async function getData() {
  let rawResponse = await fetch('https://jsonplaceholder.typicode.com/posts');
  let jsonResponse = await rawResponse.json();
  console.log(jsonResponse);
}
getData();
