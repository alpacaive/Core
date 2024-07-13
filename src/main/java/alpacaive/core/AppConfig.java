package alpacaive.core;

import alpacaive.core.discount.DiscountPolicy;
import alpacaive.core.discount.FixDiscountFolicy;
import alpacaive.core.member.MemberRepository;
import alpacaive.core.member.MemberService;
import alpacaive.core.member.MemberServiceImpl;
import alpacaive.core.member.MemoryMemberRepository;
import alpacaive.core.order.OrderService;
import alpacaive.core.order.OrderServiceImpl;

public class AppConfig {
    // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
    // 생성한 객체 인스턴의 참조(래퍼런스)를 생성자를 통해 주입(연결)해준다
    // 객체의 생성과 연결은 AppConfig 가 담당

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountFolicy();
    }

    // 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    } // MemberServiceImpl 에는 MemoryMemberRepository 주입

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    } // OrderSErviceImpl 에는 MemoryMemberRepository, FixDiscountFolicy 주입

}
