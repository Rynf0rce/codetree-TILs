import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();
        double BMI = weight / Math.pow(height*0.01,2);
        System.out.println((int)BMI);
        if(BMI>25){
            System.out.print("Obesity");
        }

    }
}