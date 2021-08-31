package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test; //junit 으로 테스트

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//실무에서는 TDD  = 테스트 주도 개발
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //콜백 메소드
    public void afterEach(){ //테스트가 끝날때마다 리포지토리를 깔금하게 지워주는 코드 필요, ex) 메모리 검사후 비우고 , 메모리 검사후 비우고
        repository.clearStore(); //한 메소드 검사가 끝날때마다 메모리 초기화 반복
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("String");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);



    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findByAll() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2); //값을 넣어 비교 테스트
    }


}
