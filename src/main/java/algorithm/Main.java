package algorithm;
import java.util.*;
class person
{
    private int id;
    private int priority;

    public person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
class Main {
    public int solution(int[]a,int n, int m) {
        int answer = 0;
        Queue<person>queue = new LinkedList<>();
        person temp = new person(0,0);
        for(int i=0;i<n;++i)
        {
            queue.add(new person(i,a[i]));
            if(i==m) {
                temp.setId(i);
                temp.setPriority(a[i]);
            }
        }
        int count = Integer.MIN_VALUE;
        while (count!=temp.getId())
        {
            int k = queue.peek().getPriority();
            boolean check  = true;
           for(person x: queue)
           {
               if(k<x.getPriority())
               {
                   queue.offer(queue.poll());
                   check = false;
                   break;
               }
           }
           if(check)
           {
               count = queue.peek().getId();
               queue.poll();
               ++answer;
           }
        }


         return answer;
        }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []a = new int[n];
        for(int i =0;i<n;++i)
        {
            a[i]=sc.nextInt();
        }
        System.out.println( main.solution(a,n,m));
    }
}






