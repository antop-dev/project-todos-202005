# Todo list

Spring + ＠로 구현해 보는 Todo list 프로젝트 

## Client

기존에 작업 했던 [프로젝트](https://github.com/antop-dev/project-todos) 에서 클라이언트 부분<sup>`Vue.js`</sup>을 재활용

## Server

아래와 같은 언어&기술(?)을 사용한다.

* Kotlin 1.3.72
* Spring Boot 2.3.0.RELEASE
    * Rest Repositories
    * Rest Repositories HAL Browser
    * Spring HATEOAS
    * Spring Data ~~Reactive~~ MongoDB
* Gradle
* MongoDB

### History

* [gitignore.io](http://gitignore.io/) 사이트에서 `.gitignore` 생성
* Gradle 멀티 프로젝트 구성
* Spring Data MongoDB + REST 개발

### References

Y2020.M05.W4

* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Gradle 버전 변경](https://tube-life.tistory.com/25)
* [Spring Boot Integration Testing with Embedded MongoDB](https://www.baeldung.com/spring-boot-embedded-mongodb)
* [Spring Data REST Reference Guide](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#reference)
* [MockMvc Kotlin DSL](https://www.baeldung.com/mockmvc-kotlin-dsl)

Y2020.M06.W1

* [Tutorial | Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [IntelliJ Kotlin Code Style 설정법](https://velog.io/@lsb156/IntelliJ-Kotlin-Code-Style-%EC%84%A4%EC%A0%95%EB%B2%95)
* [Spring HATEOAS & HAL: Change array name in _embedded](https://stackoverflow.com/questions/28834796/spring-hateoas-hal-change-array-name-in-embedded)

Y2020.M06.W2

* [[Querydsl] Kotlin Gradle프로젝트에 Querydsl 설정 (feat. kapt)](https://blog.leocat.kr/notes/2020/01/30/querydsl-querydsl-with-kotlin-on-gradle)
