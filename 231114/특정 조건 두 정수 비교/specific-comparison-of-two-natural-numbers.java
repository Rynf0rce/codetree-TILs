import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int output = 0;

        if (a < b){
            output = 1;
        }
        System.out.print(output + " ");

        if(a == b){
            output = 1;
        }
        else{
            output = 0;
        }
        System.out.print(output);
    }
}