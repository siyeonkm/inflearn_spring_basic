package section4.shopContainer.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
