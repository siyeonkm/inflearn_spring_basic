package section4.shopContainer.discount;

import section4.shopContainer.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
