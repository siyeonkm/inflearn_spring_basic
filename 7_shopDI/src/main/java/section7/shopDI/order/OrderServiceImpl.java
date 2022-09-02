package section7.shopDI.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import section7.shopDI.discount.DiscountPolicy;
import section7.shopDI.member.Member;
import section7.shopDI.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
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
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
