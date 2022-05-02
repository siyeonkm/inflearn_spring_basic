package section5.shopSingleton.discount;

import section5.shopSingleton.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
