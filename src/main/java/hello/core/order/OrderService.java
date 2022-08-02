package hello.core.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
    // 주문 생성시 id , 상품명, 상품가격을 보내면 주문 결과를 반환한다
    // 변수 타입이 order가 아니라 리턴 타입이 order기 떄문에 order의 생성자 타입을 지켜줄 필요가 없다
}
