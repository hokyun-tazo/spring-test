package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // 자동으로 메소드를 만들어준다
public class LombokTest {

    private  String name;
    private int age;

    public static void main(String[] args) {
        LombokTest lombokTest = new LombokTest();
        lombokTest.setAge(23);
        lombokTest.setName("apple");

        System.out.println(lombokTest.age+lombokTest.name);
        System.out.println("lombokTest = " + lombokTest);
    }
}
