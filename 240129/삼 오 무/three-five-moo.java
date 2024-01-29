import java.util.*;

public class Main {
    public static final long MAX_LONG = 10000000000L;

    public static long findNum(long num){
        long mutipleOfThree = num / 3;
        long mutipleOfFive = num / 5;
        long commonMutiple = num / 15;

        return num - (mutipleOfThree + mutipleOfFive - commonMutiple);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long start = 1;
        long end = MAX_LONG;
        long mid = 0;

        while(start <= end){
            mid = (end + start) / 2;
            if(findNum(mid) == N){
                break;
            }
            else if(findNum(mid) > N){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        System.out.print(mid);
    }
}