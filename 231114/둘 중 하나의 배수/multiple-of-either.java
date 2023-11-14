import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int output = 0;

        if(a % 3 == 0 || a % 5 == 0){
            output = 1;
        }
        else{
            output = 0;
        }
        System.out.print(output);
    }
}