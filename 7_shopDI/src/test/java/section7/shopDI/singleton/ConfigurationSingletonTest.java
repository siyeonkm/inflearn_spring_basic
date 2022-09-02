package section7.shopDI.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import section7.shopDI.AppConfig;
import section7.shopDI.member.MemberRepository;
import section7.shopDI.member.MemberServiceImpl;
import section7.shopDI.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
    }

    //@configuratoin을 달지않으면 내가 만들었던 순수한 appconfig가 호출됨. CGLIB안붙고
    //이러면 싱글톤 깨짐
    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        //출력해봤는데 클래스이름이 교묘하게 이상함. CGLIB라는게 붙어있음.
        System.out.println("bean = " + bean.getClass());
    }

}
