package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복오류 발생한다")
    void findByParentTypeDupilcate()
    {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                ()->ac.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있을때 빈이름을 지정하면 된다")
    void findByParentTypeName()
    {
        DiscountPolicy discountPolicy = ac.getBean("rateDisCountPolicy",DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(discountPolicy).isInstanceOf(DiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBySubType()
    {
       DiscountPolicy discountPolicy = ac.getBean(RateDiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("부모타입으로 모두 조회")
    void findAllBeanByParentType()
    {
       Map<String,DiscountPolicy> AllBean = ac.getBeansOfType(DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(AllBean.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회 - Object")
    void findAllBeanByParentObject()
    {
        Map<String, Object> AllBean = ac.getBeansOfType(Object.class);
        for (String s : AllBean.keySet()) {
            System.out.println("key = " + s+"\t Object = "+ AllBean.get(s));
        }
    }





    @Configuration
    static class TestConfig
    {
        @Bean
        public DiscountPolicy rateDisCountPolicy()
        {
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy()
        {
            return new FixDiscountPolicy();
        }
    }
}
