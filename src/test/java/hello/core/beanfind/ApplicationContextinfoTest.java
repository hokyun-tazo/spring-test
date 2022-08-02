package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class ApplicationContextinfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean()
    {
       String[] beanDefinitionName = ac.getBeanDefinitionNames();
       for(String x:beanDefinitionName)
       {
           Object bean = ac.getBean(x);
           System.out.println("name="+x+ "Object="+bean);
       }
    }

    //내가 등록하거나 외부에서 가져운 bean만 출력하는 코드
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findAllApplicationBean()
    {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for(String x : beanDefinitionName)
        {
            BeanDefinition definition = ac.getBeanDefinition(x);
            if(definition.getRole() ==BeanDefinition.ROLE_APPLICATION)
            {
                Object bean = ac.getBean(x);
                System.out.println("name="+x+ "Object="+bean);
            }
        }

    }
}
