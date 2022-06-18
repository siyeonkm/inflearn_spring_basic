package section6.shopBeanAuto.singleton;

//제대로 된 싱글톤 구성
public class SingletonService {
    //static으로 가지는경우 class 레벨에 올라가므로 딱 1개만 존재하게됨.
    //다양한 방법으로 싱글톤구성이 있지만, 이렇게 로딩때 미리 객체를 생성해두는게 가장 안전한 방법
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //만약 밑에처럼 private 생성자를 사용하지 않는다면
    //아무리 저렇게 static으로 선언해놨어도 외부에서 새로 생성해버릴 수 있음
    private SingletonService(){
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
