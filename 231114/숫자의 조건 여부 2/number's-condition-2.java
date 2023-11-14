import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char output = ' ';
        if (a == 5){
            output = 'A';
        }
        else if(a%2 == 0){
            output = 'B';
        }
        System.out.print(output);
    }
}