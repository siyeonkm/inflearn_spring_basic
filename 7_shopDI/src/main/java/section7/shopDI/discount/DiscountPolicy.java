package section7.shopDI.discount;

import section7.shopDI.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
