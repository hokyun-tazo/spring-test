package algorithm;
import java.util.*;
class Main {
    public ArrayList<Integer> solution(int[]a,int n) {
        ArrayList<Integer>answer = new ArrayList<>();
        for(int i =0;i<a.length;++i)
        {
            int temp = a[i];
            int index = i;
            for(int x =i;x<a.length;++x)
            {
                if(temp>a[x])
                {
                    temp = a[x];
                    index = x;
                }
            }
            int k = a[i];
            a[i] = a[index];
            a[index] = k;
            answer.add(a[i]);
        }
        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i =0;i<n;++i)
        {
            a[i]=sc.nextInt();
        }
        for (Integer x : main.solution(a,n)) {
            System.out.printf("%d ",x);
        }
    }
}






