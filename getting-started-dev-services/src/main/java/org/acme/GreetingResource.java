package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;
import java.util.stream.Collectors;

// /hello 엔드포인트를 제공하는 리소스 클래스
@Path("/hello")
public class GreetingResource {

    // GET /hello?name=이름 요청 시 실행, 이름을 저장하고 인사 메시지 반환
    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@RestQuery String name) {
         Greeting greeting = new Greeting(); // 새로운 Greeting 엔티티 생성
         greeting.name = name;               // 이름 설정
         greeting.persist();                 // DB에 저장
        return "Hello " + name;             // 인사 메시지 반환
    }

    // GET /hello/names 요청 시 실행, 저장된 모든 이름을 콤마로 연결해 반환
    @GET
    @Path("names")
    @Produces(MediaType.TEXT_PLAIN)
    public String names() {
        List<Greeting> greetings = Greeting.listAll(); // 모든 Greeting 엔티티 조회
        String names = greetings.stream().map(g-> g.name)
                .collect(Collectors.joining (", "));
        return "I've seen " + names; // 저장된 이름 목록 반환
    }
}
