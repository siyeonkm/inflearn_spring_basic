package section7.shopDI.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    //생성자에 붙여주면 파라미터에 있는 그 타입에 맞는 애를(memoryMemberRepository) 가져와서 의존성 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
