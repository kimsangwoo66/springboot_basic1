package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean //멤버서비스를 스프링빈에 등록한다.
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean //멤버리포지토리를 스프링빈에 등록한다.
    public MemberRepository memberRepository() { //이곳에서 조립한다.

        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new jdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}


