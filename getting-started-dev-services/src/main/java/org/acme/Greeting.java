package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

// Greeting 엔티티 클래스 - PanacheEntity를 상속하여 기본적인 CRUD 기능 제공
@Entity
public class Greeting extends PanacheEntity {
    // 이름을 저장하는 필드
    public String name;
}
