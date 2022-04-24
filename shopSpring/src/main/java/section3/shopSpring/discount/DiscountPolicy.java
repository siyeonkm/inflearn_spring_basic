package section3.shopSpring.discount;

import section3.shopSpring.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
