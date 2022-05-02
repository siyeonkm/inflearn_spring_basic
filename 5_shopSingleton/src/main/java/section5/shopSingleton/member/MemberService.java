package section5.shopSingleton.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
