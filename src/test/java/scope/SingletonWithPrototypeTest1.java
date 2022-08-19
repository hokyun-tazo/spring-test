package scope;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {
    @Test
    void prototypeFind()
    {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isSameAs(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isSameAs(1);
    }
    @Test
    void singletonClientUsePrototype()
    {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        ClientBean clientBean1= ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isSameAs(1);

        ClientBean clientBean2= ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isSameAs(2);
    }
    @Scope("singleton")
    static class ClientBean
    {
        private final PrototypeBean prototypeBean;

        // 이떄 prototypeBean을 스프링 컨테이너에 요청한다 그러면 이때 스프링이 만들어서 던져주면 의존관계를 주입한다
        // 이때 생성받은 prototypeBean을 할당받고 있어서 값이 누적된다
       @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }
        public int logic()
        {
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }
    @Scope("prototype")
    static class PrototypeBean
    {
        private int count =0;

        public void addCount()
        {
           ++count;
        }

        public int getCount()
        {
            return count;
        }
        @PostConstruct
        public void init()
        {
            System.out.println("PrototypeBean.init"+this);
        }
        @PreDestroy
        public void close()
        {
            System.out.println("PrototypeBean.close");
        }
    }
}
