package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFullServiceTest {

    @Test
    void StatefullServiceSingleton()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService stateFullService_1 = ac.getBean(StateFullService.class);
        StateFullService stateFullService_2 = ac.getBean(StateFullService.class);


        stateFullService_1.order("userA",10000);
        int userAPrice = stateFullService_1.order("userA",10000);
        int userBPrice = stateFullService_2.order("userB",20000);
        // userA가 주문하고 가격을 조회할려고 하는대대
        // serB가 주문하고 2만원을 주문했다
//        int price = stateFullService_1.getPrice();
//
       Assertions.assertThat(userAPrice).isEqualTo(10000);
        Assertions.assertThat(userBPrice).isEqualTo(20000);

    }

    static class TestConfig{
        @Bean
        public StateFullService stateFullService()
        {
            return new StateFullService();
        }
    }

}