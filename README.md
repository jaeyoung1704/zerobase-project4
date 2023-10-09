# zerobase-project4
4차 실습 프로젝트-학습관리 프로젝트

## 회원 로그인시 히스토리 기록
history. entity, dto, repository, service 생성.
웹페이지와 컨트롤러는 새로 추가하지않고 기존의 member controller, AdmilnMember controller와 admin/member/list, detail .html 사용.

#### 히스토리 저장 방식
1. 로그인시 successhandler를 통해 유저아이디와 각종정보를 historyDto에 담아 historyService.save로 넘겨줌.
2. entity로 변환해 repsository에 저장.

#### 관리자 회원관리 페이지에서 아이디별 마지막 로그인 일자 노출
1. member entity는 수정 없이 member dto에만 lastLogin 속성 추가.
2. db에 member_view 추가.

(SELECT member.user_id, user_name, phone, email_auth_yn, reg_dt, admin_yn, (SELECT log_dt FROM login_history WHERE user_id= member.user_id ORDER BY log_dt DESC LIMIT 1 )AS last_login
FROM MEMBER)

3. memberMapper.selectList에서 member table 대신 member_view에서 조회하도록 변경.
4. html에서 td 한칸을 늘려 last_login 속성 삽입

※ 페이지 기능 미구현

#### 관리자 회원관리 - 회원 상세정보에서 해당 회원 모든 로그인 일자 노출
1. history service.list 구현 (history repository에서 findAllByUserIdOrderByIdDesc로 history list를 불러온뒤 dto list로 변환해 반환)
2. admin member controller 에서 해당 메소드 호출후 model로 넘겨줌.
3. 정보 아래칸에 부트스트랩이용한 table을 생성해 th:each로 리스트 크기만큼 tr 생성, 각 td에 정보 삽입.

## 배너 등록 기능
미구현
