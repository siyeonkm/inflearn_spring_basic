package section2.shopBasic;

import section2.shopBasic.member.Grade;
import section2.shopBasic.member.Member;
import section2.shopBasic.member.MemberService;
import section2.shopBasic.member.MemberServiceImpl;
import section2.shopBasic.order.Order;
import section2.shopBasic.order.OrderService;
import section2.shopBasic.order.OrderServiceImpl;

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
