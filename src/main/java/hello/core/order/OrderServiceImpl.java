package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    // 외부에서 생성자를 통해 이 멤버의 필드의 값을 넣는다
    // Appconfig에서 구현체를 정해서 여기에 주입해줄것이다
    // 따라서 여기있는 클래스는 구현체를 의존하는게 아니라 인터페이스(DIP를 지킨다)만 의존하도록 한다

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); // 아이디를 조회해 아이디와 같은 멤버 리턴
        int discountPrice = discountPolicy.discount(member,itemPrice); // member의 GRADE를 조회해 itemprice에서 할인율을 빼서 리턴

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }

    public MemberRepository getMemberRepository()
    {
        return memberRepository;
    }
}
