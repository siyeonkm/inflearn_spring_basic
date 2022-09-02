package section6.shopBeanAuto.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
