package section3.shopPro;

import section3.shopPro.member.Grade;
import section3.shopPro.member.Member;
import section3.shopPro.member.MemberService;
import section3.shopPro.member.MemberServiceImpl;
import section3.shopPro.order.Order;
import section3.shopPro.order.OrderService;
import section3.shopPro.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
