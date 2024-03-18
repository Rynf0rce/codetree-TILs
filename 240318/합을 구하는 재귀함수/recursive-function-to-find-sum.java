import java.util.*;

public class Main {
    public static int findAns(int sum, int num){
        if(num > 100){
            return sum;
        }

        return findAns(sum + num, num + 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(findAns(0, n));
    }
}