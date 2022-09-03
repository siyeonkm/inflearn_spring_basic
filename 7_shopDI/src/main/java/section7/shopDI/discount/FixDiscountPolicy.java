package section7.shopDI.discount;

import org.springframework.stereotype.Component;
import section7.shopDI.member.Grade;
import section7.shopDI.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
