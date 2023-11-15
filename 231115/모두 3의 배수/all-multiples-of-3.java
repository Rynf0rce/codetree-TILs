import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean satisfied = true; // 본 과목이 boolean 를 다루기 때문에 사용

        for(int i = 0; i < 5; i++){
            input = sc.nextInt();
            if(input % 3 > 0){
                satisfied = false;
                break;
            }
        }
        System.out.print(satisfied ? "1" : "0");
    }
}