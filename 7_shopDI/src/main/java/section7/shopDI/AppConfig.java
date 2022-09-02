package section7.shopDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import section7.shopDI.discount.DiscountPolicy;
import section7.shopDI.discount.FixDiscountPolicy;
import section7.shopDI.member.MemberRepository;
import section7.shopDI.member.MemberService;
import section7.shopDI.member.MemberServiceImpl;
import section7.shopDI.member.MemoryMemberRepository;
import section7.shopDI.order.OrderService;
import section7.shopDI.order.OrderServiceImpl;

//설정정보를 표시하는 클래스라는걸 configuration으로 표시가능
@Configuration
public class AppConfig {

    //spring container라는 증거
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
