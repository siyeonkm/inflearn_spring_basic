package section2.shopBasic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
