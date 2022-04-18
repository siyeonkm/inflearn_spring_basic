package section3.shopPro.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
