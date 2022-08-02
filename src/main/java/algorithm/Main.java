package algorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Main {
    public ArrayList<Integer> solution(int[]a , int n ,int k) {
      ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer>hash = new HashMap<>();
        int lt = 0;
        for(int i =0;i<k-1;++i)
        {
             hash.put(a[i], hash.getOrDefault(a[i],0)+1);
        }
        for(int rt =k-1;rt<n;++rt) {
            hash.put(a[rt], hash.getOrDefault(a[rt],0)+1);
            answer.add(hash.size());
            hash.put(a[lt],hash.get(a[lt])-1);
            if(hash.get(a[lt])==0)
                hash.remove(a[lt]);
            ++lt;
        }
           return answer;
        }

    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a =  new int [n];
        for(int i =0;i<n;++i)
        {
            a[i] = sc.nextInt();
        }

        for(int x : main.solution(a,n,k))
        {
            System.out.printf("%d ", x);
        }
    }
}





