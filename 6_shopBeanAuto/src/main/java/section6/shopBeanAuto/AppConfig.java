package section6.shopBeanAuto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import section6.shopBeanAuto.discount.DiscountPolicy;
import section6.shopBeanAuto.discount.FixDiscountPolicy;
import section6.shopBeanAuto.member.MemberRepository;
import section6.shopBeanAuto.member.MemberService;
import section6.shopBeanAuto.member.MemberServiceImpl;
import section6.shopBeanAuto.member.MemoryMemberRepository;
import section6.shopBeanAuto.order.OrderService;
import section6.shopBeanAuto.order.OrderServiceImpl;

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
