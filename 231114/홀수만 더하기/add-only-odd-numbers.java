import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), input = 0;
        int sumval = 0;

        for(int i = 0 ; i < num ; i++){
            input = sc.nextInt();
            if(input % 3 ==0){
                sumval += input;
            }
        }
        System.out.print(sumval);
    }
}