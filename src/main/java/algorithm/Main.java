package algorithm;
import java.util.*;
class Point implements Comparable<Point>
{
    public int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if(this.x==o.x)
        {
            return this.y-o.y;
        }
        else
        {
            return this.x-o.x;
        }
    }
}
class Main {
    public ArrayList<Integer> solution(int[][]a,int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a,Comparator.comparing(st->st[0]));

        return answer;
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point>arr=new ArrayList<>();
        for(int i=0;i<n;++i)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x,y));
        }
        Collections.sort(arr);
        for (Point x : arr) {
            System.out.println(x.x+" "+x.y);
        }
    }
}






