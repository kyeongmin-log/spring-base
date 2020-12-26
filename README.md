# spring-base

(우선 따라하며 이해하기)

- 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

강의 주소 : [[스프링 입문]](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8)

## Spring을 사용하는 이유

- 스프링은 자바 및 JVM 환경의 대체언어들의 효율적이고 쉬운 엔터프라이즈 애플리케이션 개발 환경을 제공한다.
- 스프링은 만들고자하는 애플리케이션의 요구사항과 목적에 따라 유연하게 적용시킬수 있다.
- 스프링은 직관적인 API를 제공한다.
- 깔끔한 코드 구조를 만들기위한 높은 기준이 설정되어 있다.
- 이전버전들과의 호환성이 강력하게 유지된다.

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

## 정적 컨텐츠 동작

![static](./ReadmeImg/static_content.PNG)

- 웹 브라우저에서 내장 톰켓 서버로 요청을 하면 톰켓 서버는 먼저 스프링 컨테이너(현재 controller 폴더) 안을 먼저 찾아본다.
해당 파일이 없을 경우 resources/static 폴더 안에서 찾아서 그대로 보내주게 된다. (static 폴더 안에서는 확장명까지 정확하게 본다.)
  
## mvc, 템플릿 엔진 동작

![mvc](./ReadmeImg/mvc_template.PNG)

- 기본적으로 mvc의 동작을 보여주는 예시이다. 
  웹브라우저에서 서버에 요청한다. 요청 받은 서버는 controller에서 맵핑된 것이 있는지 찾고 있으면
  데이터베이스(model)에서 정보를 가져와 서버에서 가공하여 viewResolver(템플릿 엔진)로 보내준다.
  템플릿 엔진(현재 사용중인 템플릿 엔진은 thymeleaf)은 서버에서 넘어온 데이터를 맞는 자리에 넣어주고 
  HTML로 변환시켜서 웹 브라우저로 넘겨준다.
  
## API 동작

![api](./ReadmeImg/api_action.PNG)

- @ResponseBody : view로 보내는 것이 아니라 해당 데이터를 보낸다. 여러 타입으로 보낼 수 있으며
객체(오브젝트)는 현재 대부분 JSON 방식으로 넘겨준다.
  
- JSON : 키, 값으로 이루어진 오브젝트
```
{
"key":"value",
"key2":"value2"
}
```

## TestCase

- Java의 Main을 작성하는 것과 비슷한 것. 만든 기능들을 테스트해 보기위해 사용한다.

- test 폴더에서 클래스 안에 있는 테스트 할 메서드 위에 @Test를 붙여주면 메서스 실행이 가능하다.

## TDD(Test-Driven Development)

- 테스트 주도 개발. 먼저 테스크 케이스를 작성해놓고 main을 개발하는 방식
  
- 개발의 역순. 
  - 구현클래스 -> 테스트케이스(X)
  - 테스트케이스 -> 구현클래스(O)

## IntelliJ 단축키
- ctrl + shift + enter : 자동완성기능

```
Hello hello = new Hello(
//저 상태에서 누르면
Hello hello = new Hello();
```

- ctrl + p : 파라메타에 들어갈 수 있는 정보를 보여줌(api에 데이터를 넣을 때 유용함)

- alt + Insert : 클래스, 인터페이스, 패키지, getter or setter 등을 생성할 때 사용

- shift + F6 : rename (== vscode : ctrl + D)

- ctrl + alt + v : return 값 자동 완성

```
//사용 전
memberRepository.findByName(member.getName());
//사용 후
Optional<Member> byName = memberRepository.findByName(member.getName());

//자주 사용 됨.
```

- ctrl + alt + shift + T : 소스 리펙토링할 때 사용하는 단축키
