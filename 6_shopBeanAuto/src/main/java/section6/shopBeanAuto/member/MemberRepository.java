package section6.shopBeanAuto.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
