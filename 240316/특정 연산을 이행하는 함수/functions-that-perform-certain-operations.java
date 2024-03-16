import java.util.*;
public class Main {
    public static int calFuc(int num){
        if(num % 2 == 0){
            return num / 2;
        }
        
        return num * 3 - 20;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            int num = sc.nextInt();
            System.out.print(calFuc(num) + " ");
        }
    }
}