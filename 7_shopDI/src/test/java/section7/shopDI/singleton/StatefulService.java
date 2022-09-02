package section7.shopDI.singleton;

//alt+enter 하면 테스트 생성 있음
public class StatefulService {

    private int price; // 상태유지 필드
    public void order(String name, int price) {
        System.out.println("name = " + name + " price= " + price);
        this.price = price; //여기서 문제가 발생할거임.
    }

    public int getPrice() {
        return price;
    }
}
