import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean satisfied = false; // 본 과목이 boolean 를 다루기 때문에 사용

        for(int i = 2; i <= n; i++){
            if(n % i == 0 && n / i == 1){
                satisfied = true;
                break;
            }
        }
        System.out.print(satisfied ? "P" : "C");
    }
}