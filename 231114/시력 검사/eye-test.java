import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double leftEye = sc.nextDouble();
        double rightEye = sc.nextDouble();
        String output = "Low";

        if(leftEye >= 1.0 && rightEye >= 1.0){
            output = "High";
        }
        else if(leftEye >= 0.5 && leftEye >= 0.5){
            output ="Middle";
        }
        else{
            output = "Low";
        }
        System.out.print(output);
    }
}