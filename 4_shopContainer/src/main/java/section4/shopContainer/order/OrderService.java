package section4.shopContainer.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
