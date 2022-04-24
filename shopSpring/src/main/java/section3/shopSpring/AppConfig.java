package section3.shopSpring;

import section3.shopSpring.discount.DiscountPolicy;
import section3.shopSpring.discount.FixDiscountPolicy;
import section3.shopSpring.member.MemberService;
import section3.shopSpring.member.MemberServiceImpl;
import section3.shopSpring.member.MemoryMemberRepository;
import section3.shopSpring.order.OrderService;
import section3.shopSpring.order.OrderServiceImpl;

//모든 구현체 할당은 여기서
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
