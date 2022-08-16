package algorithm;
import java.util.*;

class Main {
    public int[] solution(int s ,int[]a,int n) {
       int[]answer = new int[s];

        for (int x : a) {
            int pos = -1;
            for(int i =0;i<s;++i)
            {
                if(answer[i]==x)
                {
                    pos = i;
                }
            }
            if(pos==-1)
            {
                for(int i=s-1;i>=1;--i)
                {
                    answer[i]=answer[i-1];
                }
            }
            else
            {
                for(int i = pos;i>=1;--i)
                {
                    answer[i]=answer[i-1];
                }
            }
            answer[0]=x;
        }


        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i =0;i<n;++i)
        {
            a[i]=sc.nextInt();
        }
        main.solution(s,a,n);

    }
}






