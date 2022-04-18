package section2.shopBasic.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
