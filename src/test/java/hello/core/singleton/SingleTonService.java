package hello.core.singleton;

public class SingleTonService {

    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance()
    {
        return instance;
    }

    private SingleTonService() {} // 외부 클래스에서 무분별한 new생성을 막기위해 private생성자로 생성을 막아둔다

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출출");
    }
}