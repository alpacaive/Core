package alpacaive.core.discount;

import alpacaive.core.member.Member;

public interface DiscountPolicy {

    // return 할인 대상 금
    int discount(Member member, int price);
}
