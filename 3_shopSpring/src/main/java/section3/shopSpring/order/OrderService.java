package section3.shopSpring.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
