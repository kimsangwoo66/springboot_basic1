package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean //멤버서비스를 스프링빈에 등록한다.
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean //멤버리포지토리를 스프링빈에 등록한다.
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
