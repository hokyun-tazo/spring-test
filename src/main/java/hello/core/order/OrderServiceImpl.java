package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor       //final붙은 것을 가지고 생성자를 만들어준다, 생성자가 하나면 autowirde를 생략해도 되기 떄문에 아래와같이 생성자가 없는 코드가 완성이 될수 있다
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

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
