package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private  static Map<Long,Member> store = new HashMap<>(); //실무에서는 동시성 문제 떄문에 ConcurrentHashMap 을 써야 한다

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long MemberId) {
        return store.get(MemberId); // map의 키값인(첫번쨰 매개변수)를 받아서 키값과 일치하는 Member을(두번쨰 매개변수)리턴해줌
    }
}
