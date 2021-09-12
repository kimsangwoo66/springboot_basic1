package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//스프링 JPA가 인터페이스에다가 구현체를 자기가 어떤 기술을 가지고 만든다. 그리고 스프링빈에 등록시켜준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ?
    //인터페이스 이름만으로도 개발을 끝낼 수 있다.
    @Override
    Optional<Member> findByName(String name);
}
