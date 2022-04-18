package section3.shopPro;

import section3.shopPro.member.Grade;
import section3.shopPro.member.Member;
import section3.shopPro.member.MemberService;
import section3.shopPro.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
