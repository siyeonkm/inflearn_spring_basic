package section2.shopBasic;

import section2.shopBasic.member.Grade;
import section2.shopBasic.member.Member;
import section2.shopBasic.member.MemberService;
import section2.shopBasic.member.MemberServiceImpl;

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
