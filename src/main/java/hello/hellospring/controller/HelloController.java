package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("hello-string")
    @ResponseBody //http body부분에 데이터를 직접 넣어주는 어노테이션
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring" 즉 브라우저 소스 검사를 해보면 html 코드가 하나도 없다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    //클라이언트의 HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서
    //httpmessageConverter가 동작
    //객체는 json 으로 반환
    public Hello helloApi(@RequestParam("name") String name){ //json 형식으로 파라미터 값을 전달
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name; //private이기 때문에 매서드를 통해서만 접근 가능
        //자바 빈 규약
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
