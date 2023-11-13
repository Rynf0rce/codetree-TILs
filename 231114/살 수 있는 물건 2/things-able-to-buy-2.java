import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        String output = "no";
        if(money >= 3000){
            output = "book";
        }
        else if(money >= 1000){
            output = "mask";
        }
        else if(money >= 500){
            output = "pen";
        }
        System.out.print(output);
    }
}