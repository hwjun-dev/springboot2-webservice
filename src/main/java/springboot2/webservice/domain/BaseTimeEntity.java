package springboot2.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
//JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDateTime)도 칼럼으로 인식
@MappedSuperclass
// 클래스에 Auditing 기능 포함
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
	// Entity가 생성되어 저장될 때 시간이 자동 저장
	@CreatedDate
	private LocalDateTime createdDate;
	
	// 조회한 Entity의 값을 변경할 때 시간이 자동 저장
	@LastModifiedDate
	private LocalDateTime modifiedDate;
}
