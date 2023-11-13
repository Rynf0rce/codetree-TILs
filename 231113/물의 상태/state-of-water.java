import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temperture = sc.nextInt();
        String output = "water";
        if(temperture < 0){
            output = "ice";
        }
        else if(temperture >=100){
            output = "vapor";
        }
        System.out.print(output);
    }
}