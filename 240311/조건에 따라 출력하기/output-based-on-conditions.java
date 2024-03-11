import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num == 0){
                break;
            }
            else if(num % 3 == 0){
                System.out.println(num / 3);
            }
            else{
                System.out.println(num + 2);
            }
        }
    }
}