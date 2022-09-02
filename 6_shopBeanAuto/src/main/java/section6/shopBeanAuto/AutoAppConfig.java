package section6.shopBeanAuto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import section6.shopBeanAuto.member.MemberRepository;
import section6.shopBeanAuto.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        basePackages = "section6.shopBeanAuto.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    //지금 구현체들에 @component 붙여서 빈등록을 시켜줬는데
    //그러면 의존관계는 어떻게 만들어주느냐하면, 여기다가 적는게 아니고
    //구현체들쪽에서 @autowired를 통해서!

    //수동빈 vs 자동빈 충돌
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
