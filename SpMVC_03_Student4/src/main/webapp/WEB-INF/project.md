# 프로젝트 : 학생정보
## base package: com.biz.student
* pom.xml의 dependency 수정
spring version 5.1.11 변경
lombok 추가
log를 변경 logback 으로 설정

*pom.xml java-version 수정
1.6dmf 1.8로 변경

* web.xml 에 한글 encoding filter 설정
* servelet-context.xml 수정
component-scan의 base-package com.biz.student.controller로ㅓ 변경

*HomeController.java 클래스 파일을 com.biz.student.controller로 이동

*home.jsp 상단 부분에 page 설정