package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { //비즈니스 메소드

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //같은 이름이 있는 중복회원X
        //optional 안에 여러 메소드가 존재, 즉 Null일 가능성이 있으면 optional을 한번 감싼다.
        memberRepository.findByName(member.getName()).ifPresent(m->{ //값이 있으면 멤버가 들어온다.
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
    * 전체회원 조회
    * */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findone(Long memberId){
        return memberRepository.findById(memberId);
    }
}
