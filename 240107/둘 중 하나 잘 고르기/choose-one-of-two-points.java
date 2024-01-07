import java.util.*;

class card{
    int red;
    int blue;

    public card(int red, int blue){
        this.red = red;
        this.blue = blue;
    }
}

public class Main {
    public static final int MAX_SELECT = 100;
    public static final int INVALUED = Integer.MIN_VALUE;

    public static card[] cardArr = new card[MAX_SELECT + 1];

    public static int[] DP = new int[MAX_SELECT + 1];
    public static boolean[] visited = new boolean[MAX_SELECT + 1];

    public static int N;

    public static void initilize(){
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= N ; j++){
                DP[i]= INVALUED;
            }
        }
        DP[0] = 0;
    }

    public static int findMax(int idx, int red, int blue){
        if(red < 0 || blue < 0){
            return INVALUED;
        }

        if(idx == 0){
            return 0;
        }

        // if(visited[idx]){
        //     return DP[idx];
        // }

        // visited[idx] = true;

        DP[idx] = Math.max(findMax(idx - 1, red - 1, blue) + cardArr[idx].red, findMax(idx - 1, red, blue - 1) + cardArr[idx].blue);

        return DP[idx];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 1 ; i <= 2 * N ; i++){
            int red = sc.nextInt();
            int blue = sc.nextInt();
            cardArr[i] = new card(red, blue);
        }

        initilize();

        // int output = findMax(2 * N , N, N);

        System.out.print(findMax(2 * N, N, N));

        // for(int i = 0 ; i <= 2 * N ; i++){
        //     System.out.println(DP[i] + " ");
        // }
    }
}