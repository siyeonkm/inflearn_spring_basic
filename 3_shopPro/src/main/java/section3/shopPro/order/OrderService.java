package section3.shopPro.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
