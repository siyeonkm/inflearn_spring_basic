package section7.shopDI.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
