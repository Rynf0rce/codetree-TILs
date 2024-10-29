import java.util.*;

public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i = str.length() - 1 ; i >= 0 ; i--){
            s.push(Integer.parseInt(str.charAt(i) + ""));
        }
        
        int ans = 0;
        while(!s.isEmpty()){
            int pow = s.size() - 1;
            ans += s.pop() * Math.pow(2, pow);
        }
        System.out.print(ans);
    }
}