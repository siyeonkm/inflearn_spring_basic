package section5.shopSingleton.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
