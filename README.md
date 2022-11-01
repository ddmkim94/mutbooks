# :sparkles: 멋사 파이널 프로젝트

> 유효성, 프론트 부분은 최소한으로 구현하고 기능 우선 구현 ㄱㄱ

## 1주차

> **✅ 필수 기능**

- [ ] 회원가입
- [ ] 로그인, 로그아웃
- [ ] 회원정보수정 `(*축하메일발송)`
- [ ] 글 CRUD
- [ ] 아이디 찾기
- [ ] 비밀번호 찾기 `(*메일로 임시비번 발송)`

> **✨ 추가 기능**

- [ ] 상품 CRUD

---

## 2주차

> **✅ 필수 기능**

- [ ] 주문 기능
- [ ] 결제 기능
- [ ] 장바구니 기능
- [ ] PG 연동 `(*토스 Pay)`

> **✨ 추가 기능**

- [ ] 환불 기능

---

## 3주차

> **✅ 필수 기능**

- [ ] 관리자 회원
- [ ] 관리자페이지
- [ ] 정산데이터 생성
- [ ] 건별정산처리
- [ ] 전체정산처리

> **✨ 추가 기능**

- 정산데이터를 배치로 생성
  - 스프링 내장 스케쥴러를 이용해서 배치가 매달 15일 새벽 4시에 실행되도록
  - `@EnableScheduling` 사용
  - Quartz 사용금지, 스프링의 기본적인 스케쥴링 기능을 이용해주세요.
- 출금신청기능(사용자기능)
- 출금처리기능(관리자기능)