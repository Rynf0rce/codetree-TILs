import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String output = "NO";
        if (a % 3 == 0){
            output = "YES";
        }
        System.out.println(output);

        if(a % 5 == 0){
            output = "YES";
        }
        else{
            output = "NO";
        }
        System.out.print(output);
    }
}