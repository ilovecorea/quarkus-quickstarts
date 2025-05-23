// GreetingService 클래스: 인사 메시지를 생성하는 서비스 클래스
package org.acme.getting.started;

import jakarta.enterprise.context.ApplicationScoped;

// @ApplicationScoped: 이 클래스의 인스턴스가 애플리케이션 전체에서 하나만 생성됨을 의미
@ApplicationScoped
public class GreetingService {

    // greeting 메서드: 입력받은 이름을 이용해 인사 메시지를 반환
    public String greeting(String name) {
        return "hello " + name;
    }

}
