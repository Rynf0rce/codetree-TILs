import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0, cnt = 0;
        while(true){
            input = sc.nextInt();
            if(input % 2 == 0){
                 System.out.println(input / 2);
                 cnt++;
            }
            if(cnt > 2){
                break;
            }
        }
    }
}