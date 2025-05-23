# Quarkus 시작하기

이 프로젝트는 REST 엔드포인트를 노출하는 최소한의 CRUD 서비스 예제입니다.

이 데모는 다음 기술을 사용합니다:

- REST 엔드포인트 노출을 위한 RESTEasy
- 엔드포인트 테스트를 위한 REST-assured 및 JUnit 5

## 요구 사항

이 데모를 컴파일하고 실행하려면 다음이 필요합니다:

- JDK 17 이상
- GraalVM

### GraalVM 및 JDK 17+ 설정

`GRAALVM_HOME`과 `JAVA_HOME` 환경 변수가 모두 설정되어 있고,
JDK 17 이상의 `java` 명령어가 PATH에 포함되어 있는지 확인하세요.

환경 설정에 대한 자세한 내용은 [네이티브 실행 파일 빌드 가이드](https://quarkus.io/guides/building-native-image-guide)를 참고하세요.

## 애플리케이션 빌드하기

이 데모의 소스를 체크아웃한 후 Maven 빌드를 실행하세요:

> ./mvnw package

### Quarkus 라이브 코딩

Maven Quarkus 플러그인은 라이브 코딩을 지원하는 개발 모드를 제공합니다. 사용 방법:

> ./mvnw quarkus:dev

이 명령어를 실행하면 Quarkus가 포그라운드에서 8080 포트로 실행됩니다.

1. 기본 엔드포인트 방문: [http://127.0.0.1:8080](http://127.0.0.1:8080)
    - [src/main/resources/META-INF/resources/index.html](src/main/resources/META-INF/resources/index.html) 파일을 간단히 수정해보세요.
    - 브라우저를 새로고침하면 변경된 페이지를 볼 수 있습니다.
2. `/hello` 엔드포인트 방문: [http://127.0.0.1:8080/hello](http://127.0.0.1:8080/hello)
    - [src/main/java/org/acme/quickstart/GreetingResource.java](src/main/java/org/acme/quickstart/GreetingResource.java) 파일에서 `hello()` 메서드의 반환값을 `hello`에서 `hello there`로 변경하세요.
    - 브라우저를 새로고침하면 `hello there`가 표시됩니다.
    - 변경을 되돌려 다시 `hello`를 반환하도록 하세요.
    - 브라우저를 새로고침하면 다시 `hello`가 표시됩니다.

### Quarkus를 JVM 모드로 실행하기

개발 모드에서 작업을 마쳤다면, 애플리케이션을 일반 jar 파일로 실행할 수 있습니다.

먼저 컴파일하세요:

> ./mvnw package

그런 다음 실행하세요:

> java -jar ./target/quarkus-app/quarkus-run.jar

Quarkus의 빠른 부팅 속도나 네이티브 메모리 사용량을 확인해보세요.

### Quarkus를 네이티브 실행 파일로 실행하기

소스 코드를 변경하지 않고도 이 애플리케이션을 네이티브 실행 파일로 만들 수 있습니다. 네이티브 실행 파일은 JVM에 대한 의존성을 제거합니다:
실행에 필요한 모든 것이 실행 파일에 포함되어 있어, 최소한의 리소스로 애플리케이션을 실행할 수 있습니다.

네이티브 실행 파일 컴파일은 GraalVM이 불필요한 코드 경로를 제거하는 추가 작업을 수행하므로 시간이 더 걸릴 수 있습니다. `native` 프로파일을 사용해 네이티브 실행 파일을 빌드하세요:

> ./mvnw package -Dnative

잠시 기다리면, 다음과 같이 실행 파일을 직접 실행할 수 있습니다:

> ./target/getting-started-1.0.0-SNAPSHOT-runner
