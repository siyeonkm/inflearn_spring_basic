package section6.shopBeanAuto.discount;

import section6.shopBeanAuto.member.Grade;
import section6.shopBeanAuto.member.Member;

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
