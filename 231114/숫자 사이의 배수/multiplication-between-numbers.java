import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sumVal = 0, counter = 0;
        double averageVal = 0;
        for(int i = a ; i <=b ; i++){
            if(i % 5 == 0 || i % 7 == 0){
                sumVal += i;
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