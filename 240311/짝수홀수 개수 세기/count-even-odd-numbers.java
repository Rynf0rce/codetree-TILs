import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int even = 0;
        int odd = 0;
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num == 0){
                break;
            }
            else if(num % 2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println(even);
        System.out.print(odd);
    }
}