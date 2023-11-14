import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String output = "odd";
        if (a % 2 == 0){
            output = "even";
        }
        System.out.println(output);

        if(b % 2 == 0){
            output = "even";
        }
        else{
            output = "odd";
        }
        System.out.print(output);
    }
}