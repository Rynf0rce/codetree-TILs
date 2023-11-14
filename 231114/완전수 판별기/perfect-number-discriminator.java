import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumVal = 0;
        char output = ' ';
        for(int i = 1 ; i < n ; i++){
            if(n % i == 0){
                sumVal += i;
            }
        }
        if(sumVal == n){
            output = 'P';
        }
        else{
            output = 'N';
        }
        System.out.print(output);

    }
}