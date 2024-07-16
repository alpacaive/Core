package alpacaive.core.singleton;

public class SingletoneService {

    // 자기 자신을 내부의 private 로 하나 가지고 있다, static을 붙이면 클래스 레벨에 올라가기 때문에 딱 하나만 존재
    private static final SingletoneService instance = new SingletoneService();

    // 조회할 때
    public static SingletoneService getInstance() {
        return instance;
    }

    // 다른 곳의 생성을 막기위해 private
    private SingletoneService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
