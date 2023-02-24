/*
React.js
  - Node.js 기반의 JS UI 라이브러리
  - 다운로드 받는다고 바로 쓸 수 있는 것이 아니라 추가적인 라이브러리들이 필요

WebPack
  - 다수의 JS 파일을 하나의 파일로 합쳐주는 모듈 번들 라이브러리

Babel
  - JSX 등 쉽고 직관적인 JS 문법을 사용할 수 있도록 해주는 라이브러리

Create React App
  - 부수적인 패키지들을 설치하고 이해하고 세팅하는 것은 쉽지 않은 일이기 때문에 이미 세팅 완료된 패키지(Boiler Plate)를 사용
  - npm에 있는 패키지라 npm i를 통해 설치해야 하지만 한 번 쓰고 말 것이기 때문에 npx를 사용

  [설치 명령어]
  1. npm install -g npx
  2. npx create-react-app react-exam_02
  
  [동작 방식]
  index.js가 실행되면서 index.html에 있는 id가 root인 div 태그 안으로 App.js에 있는 App 함수 리턴값이 들어간다.

  [node_modules]
  - 외부 모듈을 저장하는 폴더
  - 리액트도 외부 모듈이기 때문에 node_modules 안에 있다.
  - Create React App으로 만든 패키지는 굉장히 많은 외부 모듈을 가지고 있기 때문에 용량이 매우 크다.
  - Node.js 패키지는 node_modules가 없어도 package-lock.json과 package.json이 필요한 외부 모듈을 기억하고 있기 때문에 협업을 위해 원격 저장소에 올리거나 이메일로 보내야 할 경우 보내지 않아도 된다.
  - node_modules가 없을 경우, npm i 명령어를 사용

  [public]
  - logo192.png, logo512.png, manifest.json: 모바일 환경에 적용되는 아이콘과 옵션
  - robots.txt: 구글이나 네이버가 웹 사이트를 수집하여 검색 엔진에 띄워줄 때, 수집할 것과 수집하지 말 것을 경로를 기준으로 알려주는 파일

  [src]
  - App.test.js: 테스트 용도

* Boiler Plate: 보일러를 찍어내듯 서비스를 개발할 수 있는 빵틀의 역할을 하는 패키지
* npx: 설치되어 있지 않은 패키지를 한 번만 쓰고 싶을 때 사용하는 도구
*/
