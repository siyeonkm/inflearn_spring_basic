package section3.shopPro;

import section3.shopPro.discount.FixDiscountPolicy;
import section3.shopPro.member.MemberService;
import section3.shopPro.member.MemberServiceImpl;
import section3.shopPro.member.MemoryMemberRepository;
import section3.shopPro.order.OrderService;
import section3.shopPro.order.OrderServiceImpl;

//모든 구현체 할당은 여기서
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
