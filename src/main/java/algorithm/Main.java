package algorithm;
import java.util.*;
class Main {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer>bagu = new Stack<>();
        for(Character x : str.toCharArray())
        {
            int temp =0;
            if(Character.isDigit(x))
            {
                bagu.push(x-48);
            }
            else
            {
                int rt = bagu.pop();
                int lt = bagu.pop();
                switch (x){
                    case'+':
                        bagu.push(lt+rt);
                        break;
                        case'-':
                        bagu.push(lt-rt);
                        break;
                        case'*':
                        bagu.push(lt*rt);
                        break;
                        case'/':
                        bagu.push(lt/rt);
                        break;

                }
            }
        }
        answer = bagu.peek();
        return answer;
        }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }
}






