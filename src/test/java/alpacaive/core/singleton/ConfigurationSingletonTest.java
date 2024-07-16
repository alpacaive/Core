package alpacaive.core.singleton;

import alpacaive.core.AppConfig;
import alpacaive.core.member.MemberRepository;
import alpacaive.core.member.MemberServiceImpl;
import alpacaive.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> orderRepository = " + memberRepository2);
        // 똑같다...?
        System.out.println("memberRepository = " + memberRepository);
        // = 3개 다 같은 인스턴스가 생성됨 왜지? 객체를 최소 3번 생성했는데?

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // 순수한 클래스라면 bean = class alpacaive.core.AppConfig 이렇게 출력되어야 함
        // bean = class alpacaive.core.AppConfig$$SpringCGLIB$$0
        // = 내가 만든 클래스가 아니고 스프링 CGLIB라는 바이트 코드 조작 라이브러를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고
        //  그 클래를 스프링 빈으로 등록한 것이다
    }

}
