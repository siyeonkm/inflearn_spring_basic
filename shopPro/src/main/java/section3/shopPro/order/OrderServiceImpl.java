package section3.shopPro.order;

import section3.shopPro.discount.DiscountPolicy;
import section3.shopPro.discount.FixDiscountPolicy;
import section3.shopPro.member.Member;
import section3.shopPro.member.MemberRepository;
import section3.shopPro.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
