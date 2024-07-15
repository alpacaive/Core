package alpacaive.core;

import alpacaive.core.discount.DiscountPolicy;
import alpacaive.core.discount.FixDiscountFolicy;
import alpacaive.core.discount.RateDiscountPolicy;
import alpacaive.core.member.MemberRepository;
import alpacaive.core.member.MemberService;
import alpacaive.core.member.MemberServiceImpl;
import alpacaive.core.member.MemoryMemberRepository;
import alpacaive.core.order.OrderService;
import alpacaive.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
    // 생성한 객체 인스턴의 참조(래퍼런스)를 생성자를 통해 주입(연결)해준다
    // 객체의 생성과 연결은 AppConfig 가 담당

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountFolicy();
        return new RateDiscountPolicy(); // 할인 정책 변경
        // -> AppConfig의 등장으로 구성영역과 사용영역이 완전히 분리되었기 때문에 구성영역에서 할인 정책을 변경하면 끝
    }

    // 생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    } // MemberServiceImpl 에는 MemoryMemberRepository 주입

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    } // OrderSErviceImpl 에는 MemoryMemberRepository, FixDiscountFolicy 주입

}
