package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
                /*순수 자바 코드를 사용하는 코드*/
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

         /*spring을 사용하는 해서 Configuration하는 것*/
       ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
       MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member("memberA",1L, Grade.VIP);

        memberService.join(member);

        Member result =  memberService.findMember(1L);
        System.out.println("MemberID ="+member.getId()+" MemberName="+member.getName()+" MemberGrade ="+member.getGrade());
        System.out.println("MemberID ="+result.getId()+" MemberName="+result.getName()+" MemberGrade ="+result.getGrade());

    }

}
