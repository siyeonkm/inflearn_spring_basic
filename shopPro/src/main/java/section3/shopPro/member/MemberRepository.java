package section3.shopPro.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
