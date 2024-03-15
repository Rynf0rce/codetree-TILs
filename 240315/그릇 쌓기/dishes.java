import java.util.*;

public class Main {
    public static Stack<Boolean> s = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = String.valueOf(sc.next());
        int ans = 0;
        boolean cur = false;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '('){
                s.add(true);
            }
            else{
                s.add(false);
            }

            if(s.size() == 1 || cur != s.peek()){
                ans += 10;
            }
            else{
                ans += 5;
            }
            cur = s.peek();
        }
        System.out.print(ans);
    }
}