package section3.shopPro.discount;

import section3.shopPro.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
