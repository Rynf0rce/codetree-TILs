import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double l = sc.nextDouble();
        double r = sc.nextDouble();
        if(l >= 1.0 && r >= 1.0){
            System.out.print("H");
        }
        else if(l >= 0.5 && r >= 0.5){
            System.out.print("M");
        }
        else{
            System.out.print("L");
        }
    }
}