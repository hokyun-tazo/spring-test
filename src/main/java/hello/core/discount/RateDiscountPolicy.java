package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // 오타가 나면 컴파일 오류를 생기게 해준다
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
