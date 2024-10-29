import java.util.*;

public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String str = sc.next();

        for(int i = str.length() - 1 ; i >= 0 ; i--){
            s.push(Integer.parseInt(str.charAt(i) + ""));
        }

        int val = 0;
        while(!s.isEmpty()){
            int pow = s.size() - 1;
            val += s.pop() * Math.pow(a, pow);
        }

        while(val > 0){
            int num = val % b;
            s.push(num);
            val /= b;
        }

        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}