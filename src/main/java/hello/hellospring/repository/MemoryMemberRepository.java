package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//컨트롤러, 서비스, 리포지토리 -> 되게 정용화된 패턴
// 컨트롤러를 통해서 외부요청 받음, 서비스에서 비즈니스 로직 구현, 리포지토리에서 데이터를 저장

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) { //구현체
        member.setId(++sequence); //아이디 세팅
        store.put(member.getId(), member); //map에 아이디 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();//한 메소드 검사가 끝날때마다 메모리 초기화 반복
    }
}
