package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컨트롤러를 통해 외부에서 의존관계 주입
@Controller
public class MemberController {

    private final MemberService memberService;

    //스프링이 스프링 컨테이너에있는 멤버서비스를 가져다가 연결 시킴,autowired를 사용하면 컨트롤러랑 서비스랑 연결(의존관계 주입)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }





}
