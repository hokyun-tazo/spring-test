package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.NumberFormat;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
@BeforeEach
public void beforeEach()
{
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
}
    @Test
    void CreateOrder()
    {
        Member member = new Member("spring",1L, Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(), "apple",20000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);

    }
}
