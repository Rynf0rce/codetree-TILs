import java.util.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final int MAX_INPUT = 10000;
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static int[][] DP = new int[MAX_RANGE + 1][MAX_INPUT + 1];

    // DP는 초기화를 잘해주는 것이 중요.
    public static void initialize(){
        for(int i = 0 ; i < MAX_RANGE ; i++){
            for(int j = 0 ; j < MAX_INPUT ; j++){
                DP[i][j] = INT_MIN;
            }
        }
        DP[0][MAX_INPUT] = 0; // 긴 감소 부분 순열을 구하기 위해 길이가 0이고 최대값인 부분에 값 "0" 을 추가.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max_element = INT_MIN; // 입력 값 중 최대 값을 찾는다
        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
            max_element = Math.max(max_element, arr[i]);
        }

        initialize(); // 최대 값을 구해야 되기 때문에 길이가 0 이고 정수 값이 최대 인것을 제외하고는
                        // 나머지는 제일 작은 정수 값을 넣는다.

        for(int i = 1 ; i <= N ; i++){
            for(int j = max_element ; j >= 1 ; j--){
                if(arr[i] != j){ // i번째의 길이의 해당하는 값이 j가 아니면 길이는 그대로.
                    DP[i][j] = DP[i - 1][j];
                }
                else{
                    DP[i][j] = DP[i - 1][j];

                    for(int k = arr[i] + 1 ; k <= MAX_INPUT ; k++){
                        if(DP[i - 1][k] != INT_MIN){
                            // i 번째의 길이에 해당 되는 값이 있다면 길이가 나보다 한개 작고 값이 큰 수열의 길이 + 1과 이전의 길이랑 비교.
                            DP[i][j] = Math.max(DP[i][j], DP[i - 1][k] + 1); 
                        }
                    }
                }
            }
        }

        int output = INT_MIN;
        // 길이가 N인 지점에서 끝나기 때문에 N부분에서 최대값을 찾는다.
        for(int i = 0; i <= max_element ; i++){
            output = Math.max(output, DP[N][i]);
        }

        System.out.print(output);
    }
}