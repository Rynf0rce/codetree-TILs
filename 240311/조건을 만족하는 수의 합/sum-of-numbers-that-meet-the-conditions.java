import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = n ; i <= 500 ; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        System.out.print(sum);
    }
}