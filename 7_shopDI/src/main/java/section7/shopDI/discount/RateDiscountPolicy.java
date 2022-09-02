package section7.shopDI.discount;

import org.springframework.stereotype.Component;
import section7.shopDI.member.Grade;
import section7.shopDI.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
