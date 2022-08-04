package algorithm;
import java.util.*;

// 덧샘할수 있는 모든 결과에서 k번째로 큰 수를 출력
// 배열을 오름차순 정렬해서 hash에 저장
// 012 013 014 015 016 017 018 019
// 023 024 025 026 027 028 029
// 034 035 036 037 038 039
// 045 046 047 등등등
class Main {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character>stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if(x=='(') {
                stack.push(x);
            }
            else
            {
                if(stack.empty())
                {
                    return "NO";
                }
                else {
                    stack.pop();
                }
            }
        }
        if(!stack.empty())
        {
            return "NO";
        }
        return answer;
        }
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }
}





