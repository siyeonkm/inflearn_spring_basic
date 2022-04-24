package section3.shopSpring.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
