import java.util.*;

public class Main {
    public static boolean conFuc(int M, int D){
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(M >= 1 && M <= 12){
            if(days[M-1] >= D){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), D = sc.nextInt();
        System.out.print(conFuc(M, D) ? "Yes" : "No");
    }
}