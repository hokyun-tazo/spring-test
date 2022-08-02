package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip()
    {
        Member member = new Member("Spinrg",1L, Grade.VIP);

        int discount = rateDiscountPolicy.discount(member,12000);

        assertThat(discount).isEqualTo(1200);

    }

    @Test
    void basic()
    {
        Member member = new Member("Spinrg",1L, Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(0);
    }
}
