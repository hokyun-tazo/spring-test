package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer()
    {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할떄 마다 객체를 생성
        MemberService memberService_1 = appConfig.memberService();
        MemberService memberService_2 = appConfig.memberService();

        //참조 값이 다른것을 확인 = 같은 클래스 이지만 다른 객체가 생성됫음을 확인
        System.out.println("memberService_1 = " + memberService_1);
        System.out.println("memberService_2 = " + memberService_2);

        Assertions.assertThat(memberService_1).isNotSameAs(memberService_2);
    }

    @Test
    @DisplayName("싱슬톤 패턴을 적용한 객체 사용")
    void singleTonServiceTest()
    {
        SingleTonService singleTonService_1 = SingleTonService.getInstance();
        SingleTonService singleTonService_2 = SingleTonService.getInstance();

        Assertions.assertThat(singleTonService_1).isSameAs(singleTonService_2);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService_1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService_2 = ac.getBean("memberService",MemberService.class);

        Assertions.assertThat(memberService_1).isSameAs(memberService_2);

    }

}
