package section7.shopDI.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
