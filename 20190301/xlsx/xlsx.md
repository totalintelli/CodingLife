# XLSX (엑셀 파일 다루기)

- excel 파일 읽기
- excel 파일 다운로드 하기
- excel 파일 업로드 하기
- DB에 insert, update 하기

## 라이브러리

- SheetJS
  - https://github.com/SheetJS/js-xlsx

## 설치

```
npm i xlsx
```

## Simple Example

```js
var XLSX = require("xlsx");
var workbook = XLSX.readFile("test.xlsx");
/* DO SOMETHING WITH workbook HERE */
```

## API, Documents

- https://docs.sheetjs.com/
