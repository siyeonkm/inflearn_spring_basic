package section2.shopBasic.order;

import section2.shopBasic.discount.DiscountPolicy;
import section2.shopBasic.discount.FixDiscountPolicy;
import section2.shopBasic.member.Member;
import section2.shopBasic.member.MemberRepository;
import section2.shopBasic.member.MemoryMemberRepository;

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
