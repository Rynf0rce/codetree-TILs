import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String output = "no";

        if(a >= 10 && a <= 20){
            output = "yes";
        }
        else{
            output = "no";
        }
        System.out.print(output);
    }
}