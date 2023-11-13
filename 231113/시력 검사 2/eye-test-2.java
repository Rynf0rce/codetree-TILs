import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        String output = "Low";
        if(n >= 1.0){
            output = "High";
        }
        else if(n >= 0.5){
            output = "Middle";
        }
        System.out.print(output);
    }
}