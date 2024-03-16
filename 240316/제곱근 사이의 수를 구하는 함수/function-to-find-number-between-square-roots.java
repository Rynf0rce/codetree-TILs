import java.util.*;
public class Main {
    public static int findAns(double a, double b){
        if(a > b){
            return findAns(b, a);
        }

        int cnt = 0;
        a = Math.sqrt(a);
        b = Math.sqrt(b);

        for(int i = 0 ; i < 1000 ; i++){
            if(i < a){
                continue;
            }

            if(i > b){
                break;
            }

            cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.print(findAns(a, b));
    }
}