import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int output = 0;

        if(a > b && a > c){
            if(b > c){
                output = b;
            }
            else{
                output = c;
            }
        }
        else if(b>c){
            if(a > c){
                output = a;
            }
            else{
                output = c;
            }
        }
        else{
            if(a > b){
                output = a;
            }
            else{
                output = b;
            }
        }
        System.out.print(output);
    }
}