package section2.shopBasic.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
