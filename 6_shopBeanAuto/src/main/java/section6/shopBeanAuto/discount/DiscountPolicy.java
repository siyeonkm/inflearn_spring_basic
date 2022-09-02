package section6.shopBeanAuto.discount;

import section6.shopBeanAuto.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
