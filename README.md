# spring-base

(우선 따라하며 이해하기)

- 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

강의 주소 : [[스프링 입문]](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8)

## gradle

- 버전을 설정하고 라이브러리를 가져오는 것 -> package.json 같은 것

## 검색

- 스프링이 가지고 있는 기능은 어마어마하기에 전부를 배우기보다 필요할 때 찾아쓰는 검색 능력이 중요하다.
  
검색 방법 : spring.io를 들어간다 -> projects -> Spring Boot -> learn -> 해당 버전의 Reference Doc. -> 필요한 내용을 찾는다(다 영어라 영어 공부 열심히 하자.)

- 공식 사이트를 자주 보자. (spring.io)

## Welcome Page

- 스프링 부트가 제공하는 기능
> 서버를 열면 src/main/resources/static/index.html을 표시해준다.

## 이미 사용 중인 포트라고 뜰 시
>cmd -> netstat -ano | findstr 8080 -> taskkill /F /pid <PID>

## 빌드하고 실행하기

- 콘솔로 이동

>1. ./gradlew build
>2. cd build/libs
>3. java -jar hello-spring-0.0.1-SNAPSHOT.jar
>4. 실행 확인