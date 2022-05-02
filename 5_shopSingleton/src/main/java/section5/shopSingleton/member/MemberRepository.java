package section5.shopSingleton.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
