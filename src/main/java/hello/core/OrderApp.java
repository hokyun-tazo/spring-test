package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {
    public static void main(String[] args) {
          /*기존에 자바 코드를 이용해 Appconfig하는 방법*/
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService()
//        OrderService orderService = appConfig.orderService();

          /*스프링 컨테이너에서 bean을 가져와 연결하는 방법 */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);


        Member member = new Member("Spring",1L,Grade.VIP);
        memberService.join(member);



       Order order = orderService.createOrder(member.getId(), "apple",20000);
        System.out.println(order);
    }
}
