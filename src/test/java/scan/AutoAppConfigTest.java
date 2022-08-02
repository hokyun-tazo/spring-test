package scan;

import hello.core.AppConfig;
import hello.core.AutoAppconfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void NoAutoConfigScan()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    void AutoConfigScan()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppconfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    void AutoOrderConfig()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppconfig.class);
        OrderService orderService = ac.getBean(OrderService.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Member member = new Member("jung",101L,Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "apple", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);

    }

}
