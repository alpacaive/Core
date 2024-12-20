package alpacaive.core.order;

import alpacaive.core.discount.FixDiscountPolicy;
import alpacaive.core.member.Grade;
import alpacaive.core.member.Member;
import alpacaive.core.member.MemberRepository;
import alpacaive.core.member.MemoryMemberRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}