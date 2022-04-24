package section3.shopSpring;

import section3.shopSpring.member.Grade;
import section3.shopSpring.member.Member;
import section3.shopSpring.member.MemberService;
import section3.shopSpring.order.Order;
import section3.shopSpring.order.OrderService;

public class ShopApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        //MemberService memberService = new MemberServiceImpl(null);
        //OrderService orderService = new OrderServiceImpl(null, null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
