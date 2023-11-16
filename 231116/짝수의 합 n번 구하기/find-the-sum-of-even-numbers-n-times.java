import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 0, sum = 1;
        for(int i = 0 ; i < n ; i++){
            a = sc.nextInt(); b= sc.nextInt();
            sum = 0;
            for(int j = a ; j <= b ; j++){
                if(j % 2 ==0){
                    sum += j;
                }
            }
            System.out.println(sum);
        }
    }
}