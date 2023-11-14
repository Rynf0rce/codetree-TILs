import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalDay = 0;

        if( (n%2 == 1 && n <= 7) || (n%2 == 0 && n> 7)){
            totalDay = 31;
        }
        else if(n != 2){
            totalDay = 28;
        }
        else{
            totalDay = 30;
        }
        System.out.print(totalDay);
    }
}