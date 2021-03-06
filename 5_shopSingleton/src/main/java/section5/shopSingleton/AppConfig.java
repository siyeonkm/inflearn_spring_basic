package section5.shopSingleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import section5.shopSingleton.discount.DiscountPolicy;
import section5.shopSingleton.discount.FixDiscountPolicy;
import section5.shopSingleton.member.MemberRepository;
import section5.shopSingleton.member.MemberService;
import section5.shopSingleton.member.MemberServiceImpl;
import section5.shopSingleton.member.MemoryMemberRepository;
import section5.shopSingleton.order.OrderService;
import section5.shopSingleton.order.OrderServiceImpl;

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
