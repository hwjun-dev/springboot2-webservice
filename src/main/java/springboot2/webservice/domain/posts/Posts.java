package springboot2.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot2.webservice.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
// 테이블에 링크될 클래스
// 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
@Entity
public class Posts extends BaseTimeEntity {
	// PK 필드
	@Id
	// PK의 생성규칙, 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// 문자열은 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘림
	@Column(length = 500, nullable = false)
	private String title;
	
	// 타입을 TEXT로 변경
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	// 클래스의 빌더 패턴 클래스 생성
	// 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함
	@Builder
	public Posts (String title, String content,String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
