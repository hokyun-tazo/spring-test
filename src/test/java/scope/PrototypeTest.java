package scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 프로토타입 스코프 테스트
public class PrototypeTest {
    @Test
    void prototypeBeanFind()
    {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
        prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);
        prototypeBean prototypeBean2 = ac.getBean(prototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }
    @Scope("prototype")
    static class prototypeBean {

        @PostConstruct
        public void init()
        {
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void close()
        {
            System.out.println("SingletonBean.close");
        }
    }
}
