import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int sumVal = 0;
        for(int i = 1 ; i < 100 ; i++){
            sumVal += i;
            if(sumVal >= n){
                System.out.print(i);
                break;
            }
        }
        
    }
}