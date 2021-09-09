package hello.hellospring.controller;

public class MemberForm {

    //MemberForm.html 의 name과 맵핑이되서 가져온다.
    //VO
    private String name; //이곳에 멤버폼.html에서 입력했던 값이 이 name으로 넘어온다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
