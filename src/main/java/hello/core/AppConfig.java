package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {


//    public MemberService memberService()
//    {
//        return new MemberServiceimpl(new MemoryMemberRepository());
//    }
//    public OrderService orderService()
//    {
//        return new OrderServiceImpl(new MemoryMemberRepository(),new RateDiscountPolicy());
//    }
// --> 아래 코드로 변경하면 역할과 어떤 구현부를 사용하는지 한눈에 들어옴
    @Bean
    public MemberService memberService()
    {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceimpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy()
    {
        System.out.println("call AppConfig.discountPolicy");
        return new FixDiscountPolicy();
    }
    @Bean
    public OrderService orderService()
    {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    //@Bean을 하면 spring컨테이너에 등록되서 사용이 된다

}
