import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int units = 0, tens = 0; 
        for(int i = 1 ; i <= n ; i++){
            units = i % 10;
            tens = i / 10;
            if((units != 0 && units % 3 == 0) || (tens != 0 && tens % 3 == 0)){
                System.out.print("0 ");
            }
            else{
                System.out.print(i + " ");
            }
        }
    }
}