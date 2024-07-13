package alpacaive.core;

import alpacaive.core.member.Grade;
import alpacaive.core.member.Member;
import alpacaive.core.member.MemberService;
import alpacaive.core.member.MemberServiceImpl;
import alpacaive.core.order.Order;
import alpacaive.core.order.OrderService;
import alpacaive.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order.toString());
    }
}
