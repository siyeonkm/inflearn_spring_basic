package section3.shopSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import section3.shopSpring.discount.DiscountPolicy;
import section3.shopSpring.discount.FixDiscountPolicy;
import section3.shopSpring.member.MemberService;
import section3.shopSpring.member.MemberServiceImpl;
import section3.shopSpring.member.MemoryMemberRepository;
import section3.shopSpring.order.OrderService;
import section3.shopSpring.order.OrderServiceImpl;

//설정정보를 표시하는 클래스라는걸 configuration으로 표시가능
@Configuration
public class AppConfig {

    //spring container라는 증거
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
