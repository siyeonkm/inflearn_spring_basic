package section7.shopDI.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //사용자 A가 주문하고 금액 조회하는 사이에 다른 사용자가 주문을 한 상태
        //ThreadA: A사용자 1000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB: B사용자 2000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //서로 다른 service객체 썼음에도 불구하고 조회시에 B로 나옴
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);


    }

    //테스트 전용 test config
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}