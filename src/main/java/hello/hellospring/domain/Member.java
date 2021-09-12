package hello.hellospring.domain;


import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //db가 아이디를 자동으로 생성해주는것을 identity전략이라고 한다.
    private Long id;
    private String name;

    @Column(name = "username")


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
