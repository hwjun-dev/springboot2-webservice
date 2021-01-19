package springboot2.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Posts 클래스로 Database를 접근하게 해줄 클래스
// JpaRepository<Entity 클래스, PK 타입> 상속하면
// 기본적인 CRUD 메소드가 자동으로 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
	
}
