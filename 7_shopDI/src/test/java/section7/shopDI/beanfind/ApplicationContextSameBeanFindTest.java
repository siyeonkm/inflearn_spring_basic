package section7.shopDI.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import section7.shopDI.member.MemberRepository;
import section7.shopDI.member.MemoryMemberRepository;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상이면, 중복 오류가 발생한다")
    void findBeanByTypeDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for(String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }


    @Configuration
    static class SameBeanConfig {
        //간이로 만든 class니까 지금 이 text class안에서만 이 class를 쓰겠다는 의미로 static으로 선언한거임
        //그리고, appconfig에는 중복타입이 없으니까 test가 안돼서, 지금 새로 만드는거임
        //이런식으로 중복으로 만드는경우 있음. 예를들어 반환 파라미터가 다르다든가 ㅇㅇ
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

}
