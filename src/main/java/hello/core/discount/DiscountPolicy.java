package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /*
    * return 값이 얼마가 할인 되었는지 리턴해준다
    */
    int discount(Member member,int price);

}
