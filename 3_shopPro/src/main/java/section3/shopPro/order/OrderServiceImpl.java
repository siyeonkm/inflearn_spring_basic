package section3.shopPro.order;

import section3.shopPro.discount.DiscountPolicy;
import section3.shopPro.discount.FixDiscountPolicy;
import section3.shopPro.discount.RateDiscountPolicy;
import section3.shopPro.member.Member;
import section3.shopPro.member.MemberRepository;
import section3.shopPro.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
