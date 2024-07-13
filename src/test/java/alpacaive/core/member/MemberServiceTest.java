package alpacaive.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService mservice = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        mservice.join(member);
        Member findMember = mservice.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}