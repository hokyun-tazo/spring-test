package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingleTonTest {
    @Test
    void configurationTest()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceimpl memberService = ac.getBean("memberService", MemberServiceimpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);

         Assertions.assertThat(memberService.getMemberRepository()).isEqualTo(memberRepository);
        Assertions.assertThat(memberService.getMemberRepository()).isEqualTo(orderService.getMemberRepository());
    }
    @Test
    void configurationDeep()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());

    }
}
