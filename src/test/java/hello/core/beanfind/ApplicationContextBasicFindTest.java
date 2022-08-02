package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName()
    {
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType()
    {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        // MemberService의 타입으로되있는 Bean을 컨테이너에서 꺼내 memberService에 집어 넣는다
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2()
    {
        MemberService memberService = ac.getBean(MemberServiceimpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
        // bean에 등록할때는 return받은 타입 즉 구체화된 타입으로 등록하기 떄문에 구체 타입으로 컨테이너에서 조회해도 가능하다
        // 하지만 단접이 있는대 구현에 의존하기 때문에 좋은 코드는 아니다
    }
    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findNameFalse()
    {
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->
                ac.getBean("xxxx",MemberService.class));
        // assertThrows는 두번쨰 매게 변수를 수행했을때 첫번쨰 매게변수의 예외와 같다면 통과인것이다
    }



}
