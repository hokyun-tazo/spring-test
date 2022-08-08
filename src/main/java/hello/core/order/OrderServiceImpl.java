package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    // 내가만든 annotation을 우선 사용하고자 하는 구현체에 선언해주고
    // @Qualifier처럼 직접 구현체를 지정해준다
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
