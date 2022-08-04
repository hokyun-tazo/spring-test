package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void AutowiredOption()
    {
       ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{

        @Autowired(required = false)
        public void setNoBean_1(Member member){
            System.out.println("member_1 = " + member);
        }
        @Autowired
        public void setNoBean_2(@Nullable Member member){
            System.out.println("member_2 = " + member);
        }
        @Autowired
        public void setNoBean_3(Optional<Member>member){
            System.out.println("member_3 = " + member);
        }


    }
}
