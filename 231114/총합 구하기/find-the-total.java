import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sumVal = 0;
        for(int i = a ; i <=b ; i++){
            if(i % 6 == 0 && i % 8 != 0){
                sumVal += i;
            }
        }
        System.out.print(sumVal);
    }
}