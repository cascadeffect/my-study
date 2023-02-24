/* 
Node.js
  1. GUI(Graphic User Interface) 방식
    - 아이콘 등 그래픽을 기반으로 마우스 클릭만으로 명령을 내리는 방식
    - 어떤 프로그램을 실행할 떄 아이콘을 클릭하는 행위 == 운영체제에 프로그램을 실행하라고 명령하는 행위
  2. CLI(Command Line Interface) 방식
    - 명령어 입력을 기반으로 수행할 명령을 타이핑해서 명령을 내리는 방식
*/

// terminal
// > node 403_node.js

// require('파일경로') => 모듈 불러오기
// WARN: module.exports & require는 Node.js의 내장 함수, Vanilla JS에서는 제한
const calc = require('./403_calc.js');

console.log(calc);
console.log(calc.add(1, 2));
console.log(calc.sub(10, 2));

/*
Module
  -> 기능별로 파일을 분리하고, 각 기능을 다른 파일에서 구현한 뒤 불러와서 사용

Module System
  -> 모듈을 내보내고, 불러와서 사용할 수 있는 함수 같은 기능을 제공하는 시스템
  1. CommonJs
    - module.exports로 내보내고, require('파일경로')로 불러오는 모듈 시스템
    - Node.js가 기본적으로 제공하는 모듈 시스템
  2. ECMAScript Modules (ES Modules, ESM, CJS)
*/
