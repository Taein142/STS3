개요
  문자열, 정수, 날짜 데이터를 관리하는 프로젝트

메뉴 >
1. 데이터 입력
2. 데이터 출력(전체출력)
3. 데이터 검색
4. 데이터 수정 : 검색 + 수정
5. 데이터 삭제 : 검색 + 삭제
0. 종료

MVC 패턴을 활용하여 프로젝트를 진행.

DTO class 작성 시 유의 사항
연관된 테이블의 구조를 고려하여 작성.
- 컬럼의 이름(똑같은 철자 소문자로 작성), 
  데이터타입 중 날짜형은 String으로.


작업의 흐름
 1. main 메소드부터 시작
 2. DataController의 controll 메소드 실행
 3. DataView의 showFirst 메소드 실행
 4. InOutClass의 newLinePrint 메소드 실행(타이틀, 메뉴 등 호출 수 만큼)
 5. InOutClass의 inputNum 메소드 실행(메뉴번호 입력)
 6. DataController의 controll 메소드로 복귀
 7. 메뉴번호 0번일 경우 controll 메소드 종료 후 
    MainClass의 main 메소드로 복귀 및 프로그램 종료
 8. 메뉴번호 1번일 경우 DataController의 inputData 메소드 실행
 9. DataController의 inputData 메소드에서 DataDto 인스턴스(그릇) 생성
10. DataView의 inputData 메소드 실행(그릇을 넘김)
11. DataView의 inputData에서 각 데이터 입력 처리 및 그릇에 저장 후
    DataController의 inputData 메소드로 복귀
12. DataController의 inputData에서 DataService의 insertData 메소드 실행
13. DataService의 insertData에서 DataDaoImpl의 insertData 메소드 실행
14. DataDaoImpl의 insertData 메소드에서 DB에 데이터 저장 및 
    DataService의 insertData 복귀(결과값 전달 1:성공, 0:실패)
15. DataService의 insertData에서 결과값에 따라 메시지 선택 후 
    DataController의 inputData로 복귀
16. DataController의 inputData에서 DataView의 printMsg 메소드를 
    실행하여 결과 메시지를 전닭
17. DataView의 printMsg 메소드에서 결과 메시지 출력 및 
    DataController의 inputData로 복귀
18. DataController의 control 메소드로 복귀 후 break문 실행하여
    switch 종료 및 while로 다음 반복 시작

 
List/ArrayList를 사용할 때 저장할 데이터에 대한 DTO 클래스를
지정하게 된다. '<'와 '>' 사이에 해당 클래스를 지정하게 되는 데,
이것을 제네릭스(Generics)라고 한다. 자세한 사항은 
Collection Framework에서 다루도록 하겠습니다....


수정용 쿼리 작성요령
  한 테이블에 대해서 데이터의 수정을 컬럼별로 따로 처리할 경우
  기본키를 제외한 컬럼 수 만큼 수정 메소드를 작성(쿼리를 따로따로 작성)
  
  하나의 메소드로 수정을 모두 처리할 경우
  쿼리를 통합하여 하나로 작성

Database 활용 프로젝트
  ● MVC 패턴과 DB를 활용하여 제품 관리 프로그램을 작성하여 제출하시오. 
  ● 다음의 항목에 대한 DB 테이블을 구현하시오.(추가 구성 가능)
     - 제품코드(기본키)
     - 제품명
     - 가격
     - 수량
     - 카테고리(전자제품, 생활필수품, 식품에 대항하는 코드 저장)
  ● 출력하는 메뉴는 아래와 같다.
     - 제품 등록 : 정보를 입력받아 DB에 저장한다.
     - 제품 출력 : 저장된 정보를 출력한다.
     - 제품 검색 : 입력받은 제품코드로 검색하여 해당 정보를 출력한다.
     - 제품 수정 : 입력받은 제품코드로 검색하여 수량을 수정한다.
     - 종료 : 프로그램을 종료한다.
  ● 기본 메뉴의 하위 메뉴는 아래와 같다.
     - 1. 제품 등록 > 1.가전제품, 2.생활필수품, 3.식품
     - 2. 제품 출력 > 1.전체출력, 2.카테고리별 출력
     - 2>2.카테고리별 출력 > 1. 가전제품, 2.생활필수품, 3.식품



