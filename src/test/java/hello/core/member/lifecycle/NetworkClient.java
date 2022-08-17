package hello.core.member.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
// javax는 자바에서 공식으로 지원하는 패키지이다

public class NetworkClient {

    private String url;

    public NetworkClient()
    {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url)
    {
        this.url  = url;
    }

    //서비스 시작히 호출
    public void connect()
    {
        System.out.println("connect: "+ url);
    }

    public void call (String massage)
    {
        System.out.println("call "+url + "massage = "+ massage);
    }

    //서비스 종료시 호출
    public void disconnect()
    {
        System.out.println("close "+ url);
    }
    @PostConstruct
    public void init() {
        System.out.println("init");
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void close()  {
        System.out.println("close");
        disconnect();
    }
}
