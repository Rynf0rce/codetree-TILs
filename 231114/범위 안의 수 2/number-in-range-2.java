import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0, sumVal = 0, counter = 0;
        double averageVal = 0;
        for(int i = 0 ; i < 10 ; i++){
            input = sc.nextInt();
            if(input >= 0 && input <= 200){
                sumVal += input;
                counter++;
            }
        }
        if(counter == 0){
            averageVal = 0;
        }
        else{
            averageVal = (double)sumVal / (counter);
        }
        System.out.printf("%d %.1f", sumVal, averageVal);

    }
}