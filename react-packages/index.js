// terminal에 npm start 입력 시 실행
console.log('Hello Node.js Package');

/* 
npmjs.com
  - npm package 쇼핑몰
  - c.f., maven repository
  - 검색 후 Install 명령어 복사

npmjs.com에서 package 가져오기 (randomcolor)
  0. 현재 위치한 경로 확인 (react-packages)
  1. terminal에 npmjs.com에서 복사한 Install 명령어 입력 ?(npm i randomcolor)
  2. package.json 파일에 dependencies 필드 생성 확인 ("dependencies": { "randomcolor": "^0.6.2" })
    - 설치된 외부 패키지의 버전 범위 명시
  3. 현재 위치한 경로에 node_modules 폴더 생성 확인 (node_modules > randomcolor, .package-lock.json)
    - randomcolor 폴더: 설치한 외부 패키지 코드 보관소, 패키지이기 때문에 따로 package.json 파일 존재
  4. 현재 위치한 경로에 package-lock.json 파일 생성 확인
    - package-lock.json 파일: 설치된 외부 패키지들의 정확한 버전을 기록
*/

// npm i를 통해 다운받은 외부 패키지 모듈은 경로 명시 불필요 (알아서 node_modules에 있겠거니 하고 불러옴)
const randomcolor = require('randomcolor');

let color1 = randomcolor();
let color2 = randomcolor();
let color3 = randomcolor();

console.log(color1);
console.log(color2);
console.log(color3);
