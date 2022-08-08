package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
@Primary //같은 타입의 빈이 2개이상 저장되면 primary가 붙은 클래스가 우선순위를 가지게 되어 주입되게 된다
public class RateDiscountPolicy implements DiscountPolicy{

   private int disCountPercent = 10;
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP)
        {
            return price/ disCountPercent;
        }
        else {
            return 0;
        }
    }
}
