import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        String output = "false";

        if( !(y % 100 == 0 && y % 400 != 0) && y % 4 == 0 ){
            output = "true";
        }
        else{
            output = "false";
        }
        System.out.print(output);
    }
}