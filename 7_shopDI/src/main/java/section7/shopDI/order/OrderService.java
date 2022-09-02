package section7.shopDI.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
