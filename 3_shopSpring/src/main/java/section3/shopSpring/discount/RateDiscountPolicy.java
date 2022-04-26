package section3.shopSpring.discount;

import section3.shopSpring.member.Grade;
import section3.shopSpring.member.Member;

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
