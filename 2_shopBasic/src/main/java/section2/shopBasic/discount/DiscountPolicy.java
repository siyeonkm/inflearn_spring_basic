package section2.shopBasic.discount;

import section2.shopBasic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
