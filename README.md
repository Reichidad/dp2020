# dp2020
This repository is for the 2020 CAU Design Pattern term project.

# Design Patterns 2020 Term Project
HOLUB EMBEDDED SQL 기능 확장 및 설계 개선
20145822 김영현

## 완성한 Must 확장 기능
  - HTML Exporter
    변경 및 추가 사항
    - ```src.com.holub.database.HTMLExporter.java``` 클래스 추가
    - test.com.holub.database.HTMLExporterTest.java 테스트 코드로 HTML Exporter 테스트
    - 테스트 결과 생성된 "people.html" 파일은 "C:/dp2020/people.html" 경로로 저장됨

  - XML Exporter
    변경 및 추가사항
    - src.com.holub.database.XMLExporter.java 클래스 추가
    - test.com.holub.database.XMLExporterTest.java 테스트 코드 추가
    - 테스트 결과 생성된 "people.xml" 파일은 "C:/dp2020/people.xml" 경로로 저장됨

  - Console의 쿼리 수행 기능 확장
    변경 및 추가사항
    - src.com.holub.database.ConcreteTable.java 클래스
      select(Selector where, String[] requestedColumns, Table[] otherTables) 함수 내부의 구현 코드 수정
    - src.com.holub.database.Table.interface 인터페이스
      테이블의 모든 컬럼 명을 조회하기 위한 getColumnNames() 메소드 추가
    - 인터페이스 변경에 따른 Table.interface를 implements하는 모든 클래스에 getColumnNames() 메소드 구현
    - test.com.holub.database.DatabaseTest.java 테스트 코드 추가
    - 테스트 결과는 콘솔창에 바로 출력됨. 또한, Console.java를 실행하고
      select * from address, name where address.addrId = name.addrId SQL 쿼리를 입력하여도 테스트 가능

  - Exporter Visitor Pattern
    변경 및 추가사항
    - src.com.holub.database.ExporterVisitor.interface 인터페이스 추가
    - src.com.holub.database.StartExport.java 추가 ( ConcreteExporterVisitor 역할 )
    - src.com.holub.database.ExporterElement.interface 인터페이스 추가
    - CSVExporter, HTMLExporter, XMLExporter에 implements ExporterElement 추가
    - CSVExporter, HTMLExporter, XMLExporter의 Composite Pattern Class인 src.com.holub.database.Exporter.java 추가
    - test.com.holub.database.ExporterTest.java 테스트 코드 추가
    - 테스트 결과 생성되는 파일은 모두 "C:/dp2020" 디렉토리 내에 존재함
    - 위의 HTML Exporter, XML Exporter 테스트 결과와 독립적으로 확인하기 위해 앞서 진행한 테스트 결과들을 삭제한 뒤 테스트해야 함
