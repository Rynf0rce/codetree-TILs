import java.util.*;

public class Main {
    public static int findAns(int num){
        if(num == 10){
            return 10;
        }

        return findAns(num - 1) + num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(findAns(n));
    }
}