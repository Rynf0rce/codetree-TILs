import java.util.*;

public class Main {
    public static boolean[] ans = new boolean[1005];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(int i = 0 ; i < arr.length ; i++){
            s1.add(arr[i]);
            s2.add(arr[i]);
        }

        for(int i = 0 ; i < 4 ; i++){
            s1.add('0');
        }

        Stack<Integer> sumS = new Stack<>();
        int upBit = 0;
        while(!s2.isEmpty()){
            char a = s1.pop();
            char b = s2.pop();
            
            int val = (a - '0') + (b - '0') + upBit;
            sumS.add(val % 2);
            upBit = val / 2;
        }

        while(!s1.isEmpty()){
            sumS.add( (s1.peek() - '0' + upBit) % 2);
            upBit = (s1.pop() - '0' + upBit) / 2;
        }

        while(!sumS.isEmpty()){
            System.out.print(sumS.pop());
        }
    }
}