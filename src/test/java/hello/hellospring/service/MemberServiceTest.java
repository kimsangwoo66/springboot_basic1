package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach()
    {
        memberRepository.clearStore(); //테스트하는 동안 다음 메소드를 검사하기전에 전에 검사했던 메모리를 비워줌
    }

    @Test
    void 회원가입() { //테스트 함수는 한글로 적어도 된다. 빌드될떄 실제 코드에 포함되지 않는다.
        //given
        Member member = new Member();
        member.setName("hello");


        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when

        //멤버1 가입
        memberService.join(member1);

        //assertThrows: 테스트 라이브러리
        //멤버2가 가입할떄 멤버1이랑 중복되면 테스트 성공
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e){
//         assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }



        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findone() {
    }
}