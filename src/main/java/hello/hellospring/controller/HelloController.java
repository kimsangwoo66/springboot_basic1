package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //mvc 에서 c 즉 컨트롤러에 해당
public class HelloController{
    @GetMapping("hello") // /hello URL에 접근할수있게 맵핑해준다 , get post랑 같은 의미
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    // http://localhost:8080/hello-mvc?name=spring , 즉 name변수 , 요청파라미터 값에 들어가는 변수에 따라 그 name값을 html에 전달
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
