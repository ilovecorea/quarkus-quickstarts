// GreetingResource 클래스: RESTful 엔드포인트를 제공하는 리소스 클래스
package org.acme.getting.started;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// @Path: 이 클래스가 /hello 경로에 매핑됨을 의미
@Path("/hello")
public class GreetingResource {

    // @Inject: GreetingService를 의존성 주입받음
    @Inject
    GreetingService service;

    // @GET: HTTP GET 요청 처리
    // @Produces: 반환 타입이 text/plain임을 명시
    // @Path: /hello/greeting/{name} 경로에 매핑
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(String name) {
        return service.greeting(name);
    }

    // @GET: HTTP GET 요청 처리
    // @Produces: 반환 타입이 text/plain임을 명시
    // /hello 경로에 매핑 (기본 경로)
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}