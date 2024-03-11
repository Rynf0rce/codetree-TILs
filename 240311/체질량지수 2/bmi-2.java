import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height = sc.nextInt() * 0.01;
        double weight = sc.nextInt();
        double BMI = weight / (height * height);
        System.out.println((int)BMI);
        if(BMI >= 25){
            System.out.print("Obesity");
        }
    }
}