// GreetingResourceIT 클래스: 통합 테스트(Integration Test)를 위한 클래스
package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusIntegrationTest;

// @QuarkusIntegrationTest: Quarkus 통합 테스트 어노테이션
// 실제 애플리케이션이 실행된 상태에서 테스트를 수행함
@QuarkusIntegrationTest
public class GreetingResourceIT extends GreetingResourceTest {

    // GreetingResourceTest와 동일한 테스트를 네이티브 모드에서 실행
    // 네이티브 이미지로 빌드된 애플리케이션의 동작을 검증
}