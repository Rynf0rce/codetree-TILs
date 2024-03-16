import java.util.*;

public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void printBinary(int num, boolean isHead){
        for(int i = 0 ; i < 3 ; i++){
            if(((num >> i) & 1) == 1){
                s.add(1);
            }
            else{
                s.add(0);
            }
        }

        if(isHead){
            while(!s.isEmpty() && !(s.peek() == 1)){
                s.pop();
            }
        }

        while(!s.isEmpty()){
            sb.append(s.pop());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        printBinary(arr[0] - '0', true);

        for(int i = 1 ; i < arr.length ; i++){
            printBinary(arr[i] - '0', false);
        }
        System.out.print(sb.toString());
    }
}