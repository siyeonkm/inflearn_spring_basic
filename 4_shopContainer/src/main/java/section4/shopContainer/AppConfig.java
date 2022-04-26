package section4.shopContainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import section4.shopContainer.discount.DiscountPolicy;
import section4.shopContainer.discount.FixDiscountPolicy;
import section4.shopContainer.member.MemberService;
import section4.shopContainer.member.MemberServiceImpl;
import section4.shopContainer.member.MemoryMemberRepository;
import section4.shopContainer.order.OrderService;
import section4.shopContainer.order.OrderServiceImpl;

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
