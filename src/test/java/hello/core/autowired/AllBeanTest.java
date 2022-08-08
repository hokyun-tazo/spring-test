package hello.core.autowired;

import hello.core.AutoAppconfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findALlBean()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppconfig.class,DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member("userA",1L, Grade.VIP);
        int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);
    }
    static class DiscountService //모든 discountpolicy를 주입받는다
    {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> list;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> list) {
            this.policyMap = policyMap;
            this.list = list;
            System.out.println("policyMap = " + policyMap);
            System.out.println("list = " + list);
        }

        public int discount(Member member, int i, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode); // discountCode의 이름과 일치하는 spring bean을 리턴해 담는다
            return discountPolicy.discount(member,i); // 담겨진 구현체의 메소드를 호출한다
        }
    }
}
