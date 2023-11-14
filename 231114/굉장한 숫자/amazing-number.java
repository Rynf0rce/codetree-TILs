import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String output = "false";

        if( (n % 2 == 1 && n % 3 == 0) || (n % 2 == 0 && n % 5 == 0)){
            output = "true";
        }
        else{
            output = "false";
        }
        System.out.print(output);
    }
}