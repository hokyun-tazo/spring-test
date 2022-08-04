package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
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