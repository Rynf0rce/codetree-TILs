import java.util.*;

public class Main {
    public static final int MAX_HOUSE = 100;
    public static int[] preArr = new int[MAX_HOUSE + 1];
    public static int[] postArr = new int[MAX_HOUSE + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), cnt = 0;
        for(int i = 1 ; i <= 2 * N ; i++){
            if(i <= N){
                preArr[i] = sc.nextInt();
            }
            else{
                postArr[i-N] = sc.nextInt();
            }
        }

        for(int i = 1 ; i <= N ; i++){
            cnt += preArr[i] - postArr[i];
            preArr[i+1] += preArr[i] - postArr[i];
        }
        System.out.println(cnt);
    }
}