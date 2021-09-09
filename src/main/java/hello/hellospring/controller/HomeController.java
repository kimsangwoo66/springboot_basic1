package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //localhost 8080 요청이 오면 먼저 이컨트롤러에서 먼저 맵핑된 부분을 찾아서 있으면 해당 컨트롤러가
    //호출하고 없으면 정적 리소스가 호출된다. ex) static 폴더에 있는 html
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
