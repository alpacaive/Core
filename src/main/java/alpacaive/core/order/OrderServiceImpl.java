package alpacaive.core.order;

import alpacaive.core.discount.DiscountPolicy;
import alpacaive.core.member.Member;
import alpacaive.core.member.MemberRepository;
import alpacaive.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // DIP 지킴: 구체화에 의존하지 않고 추상화에만 의존
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

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
