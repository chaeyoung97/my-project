package com.example.myproject.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//인터페이스 생성 후 JpaRepository<Entity클래스, PK타입>를 상속해주면 기존적인 CRUD 메소드가 자동 생성됨!!!!
//주의할 점은 Entity클래스와 기본 Entity Repository는 함꼐 위치해야함111!!!!!!!!!!
public interface PostsRepository extends JpaRepository<Posts, Long>{
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC ")
    List<Posts> findAllDesc();
}
