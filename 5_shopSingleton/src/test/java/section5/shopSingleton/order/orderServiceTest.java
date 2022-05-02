package section5.shopSingleton.order;

import org.junit.jupiter.api.BeforeEach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import section5.shopSingleton.AppConfig;
import section5.shopSingleton.member.Grade;
import section5.shopSingleton.member.Member;
import section5.shopSingleton.member.MemberService;

public class orderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
