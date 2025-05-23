// GreetingResourceTest 클래스: GreetingResource의 REST API 엔드포인트를 테스트하는 클래스
package org.acme.getting.started;

// RestAssured의 given() 메서드 static import - HTTP 요청 테스트용
import static io.restassured.RestAssured.given;
// Hamcrest의 is() 메서드 static import - 응답 값 검증용
import static org.hamcrest.CoreMatchers.is;

// UUID 생성을 위한 import
import java.util.UUID;

// JUnit5 테스트 어노테이션
import org.junit.jupiter.api.Test;

// Quarkus 테스트 어노테이션
import io.quarkus.test.junit.QuarkusTest;

// @QuarkusTest: Quarkus 애플리케이션 컨텍스트에서 테스트를 실행
@QuarkusTest
public class GreetingResourceTest {

    // /hello 엔드포인트의 기본 응답을 테스트하는 메서드
    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")  // GET 요청을 /hello 경로로 전송
                .then()
                .statusCode(200)       // HTTP 상태 코드가 200인지 확인
                .body(is("hello"));    // 응답 본문이 "hello"인지 확인
    }

    // /hello/greeting/{name} 엔드포인트의 동적 응답을 테스트하는 메서드
    @Test
    public void testGreetingEndpoint() {
        // 고유한 UUID 문자열 생성 (테스트 데이터로 사용)
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)                    // 경로 파라미터 설정
                .when().get("/hello/greeting/{name}")       // GET 요청을 동적 경로로 전송
                .then()
                .statusCode(200)                            // HTTP 상태 코드가 200인지 확인
                .body(is("hello " + uuid));                 // 응답이 "hello " + UUID인지 확인
    }

}
