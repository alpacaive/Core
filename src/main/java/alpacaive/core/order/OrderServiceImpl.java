package alpacaive.core.order;

import alpacaive.core.discount.DiscountPolicy;
import alpacaive.core.discount.FixDiscountFolicy;
import alpacaive.core.member.Member;
import alpacaive.core.member.MemberRepository;
import alpacaive.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountFolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
