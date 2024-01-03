import java.util.*;

public class Main {
    public static final int MAX_COIN = 100;
    public static final int MAX_CHANGE = 10000;
    public static final int INVALUED = Integer.MAX_VALUE;
    public static int[] coinArr = new int[MAX_COIN + 1];
    public static int[] changeArr = new int[MAX_CHANGE + 1];
    public static int N, M;

    public static void initialize(){
        changeArr[0] = 0;
        for(int i = 1 ; i <= M ; i++){
            changeArr[i] = INVALUED;
        }
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            coinArr[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1 ; i <= M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(i < coinArr[j] || changeArr[i - coinArr[j]] == INVALUED){
                    continue;
                }
                changeArr[i] = Math.min(changeArr[i], changeArr[i - coinArr[j]] + 1);
            }
            // System.out.print(changeArr[i] + " ");
        }
        // System.out.println();

        System.out.println(changeArr[M]);

    }
}