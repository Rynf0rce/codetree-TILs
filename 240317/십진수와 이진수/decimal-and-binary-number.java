import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int num = 0;
        for(int i = 0 ; i < arr.length ; i++){
            num += (arr[i] - '0') * Math.pow(2, arr.length - 1 - i);
        }

        num *= 17;

        Stack<Integer> s = new Stack<>();
        while(num > 0){
            s.add(num % 2);
            num /= 2;
        }

        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}