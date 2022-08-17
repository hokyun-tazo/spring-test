package hello.core.lifecycle;

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


    public void init() {
        System.out.println("init");
        connect();
        call("초기화 연결 메시지");
    }


    public void close()  {
        System.out.println("close");
        disconnect();
    }
}