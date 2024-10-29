import java.util.*;
public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num == 0){
            System.out.print(0);
            System.exit(0);
        }
        
        while(num > 0){
            s.add(num % 2);
            num /= 2;
        }
        
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}