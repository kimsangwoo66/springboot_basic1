package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//컨트롤러를 통해 외부에서 의존관계 주입
@Controller
public class MemberController {

    private  MemberService memberService;


    //스프링이 스프링 컨테이너에있는 멤버서비스를 가져다가 연결 시킴,autowired를 사용하면 컨트롤러랑 서비스랑 연결(의존관계 주입)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") ////리소스를 호출
    public String createForm(){
        return "members/createMemberForm"; //리소스에 맵칭된 템플릿을 찾음
    }


    @PostMapping("/members/new") //데이터를 바디에 포함 가능
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        //모델에다 전부 담아서 화면을 넘긴다.
        //key는 members
        model.addAttribute("members", members);
        return "members/memberList";
    }



}
