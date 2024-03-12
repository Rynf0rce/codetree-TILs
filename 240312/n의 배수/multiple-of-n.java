import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= 10 ; i++){
            int num = n * i;
            if(num < 200){
                System.out.print(num + " ");
            }
            else{
                break;
            }

            if(num % 10 == 0){
                break;
            }
        }
    }
}