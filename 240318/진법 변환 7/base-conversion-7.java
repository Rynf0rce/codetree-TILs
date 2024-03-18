import java.util.*;
public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        int left = (int)num;
        double right = num % 1;

        while(left > 0){
            s.add(left % 2);
            left /= 2;
        }

        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
        System.out.print(".");

        for(int i = 0 ; i < 4 ; i++){
            right *= 2;
            if(right > 1){
                System.out.print(1);
                right--;
            }
            else{
                System.out.print(0);
            }
        }
    }
}