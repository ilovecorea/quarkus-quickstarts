# Quarkus 시작하기

이 프로젝트는 REST 엔드포인트를 통해 몇 가지 기능을 제공하는 최소한의 CRUD 서비스입니다.

이 데모는 다음과 같은 기술을 사용합니다:

- REST 엔드포인트 제공을 위한 RESTEasy
- 엔드포인트 테스트를 위한 REST-assured 및 JUnit 5
- 영속성을 위한 Panache 및 Hibernate
- 개발 서비스를 위한 Dev services

## 요구 사항

이 데모를 컴파일하고 실행하려면 다음이 필요합니다:

- JDK 17 이상
- Docker 또는 Podman과 같은 컨테이너 런타임

### JDK 17+ 설정

`JAVA_HOME` 환경 변수가 설정되어 있고, JDK 17 이상의 `java` 명령어가 경로에 포함되어 있는지 확인하세요.

### Quarkus로 라이브 코딩하기

Maven Quarkus 플러그인은 라이브 코딩을 지원하는 개발 모드를 제공합니다. 이를 사용해보려면:

> ./mvnw quarkus:dev

이 명령어는 Quarkus를 포그라운드에서 실행하며 8080 포트를 리스닝합니다.

1. 기본 엔드포인트 방문: [http://127.0.0.1:8080](http://127.0.0.1:8080)
   - [src/main/resources/META-INF/resources/index.html](src/main/resources/META-INF/resources/index.html) 파일을 간단히 수정해보세요.
   - 브라우저를 새로고침하면 변경된 페이지를 볼 수 있습니다.
2. `/hello` 엔드포인트 방문: [http://127.0.0.1:8080/hello](http://127.0.0.1:8080/hello)
   - [src/main/java/org/acme/quickstart/GreetingResource.java](src/main/java/org/acme/quickstart/GreetingResource.java) 파일에서 `hello()` 메서드의 반환값을 `hello`에서 `hello there`로 변경하세요.
   - 브라우저를 새로고침하면 `hello there`가 표시됩니다.
   - 변경을 되돌려 메서드가 다시 `hello`를 반환하도록 하세요.
   - 브라우저를 새로고침하면 다시 `hello`가 표시됩니다.

### JVM 모드에서 Quarkus 실행하기

개발 모드에서 작업을 마쳤다면, 애플리케이션을 일반 jar 파일로 실행할 수 있습니다.

먼저 컴파일하세요:

> ./mvnw package

그런 다음 실행하세요:

> java -jar ./target/quarkus-app/quarkus-run.jar

부팅 속도나 전체 네이티브 메모리 사용량을 확인해보세요.

