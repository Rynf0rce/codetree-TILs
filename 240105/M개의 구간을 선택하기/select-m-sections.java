import java.util.*;

public class Main {
    public static final int MAX_INPUT = 500;
    public static int[] arr = new int[MAX_INPUT];
    public static ArrayList<Boolean> selectedList = new ArrayList<>();
    
    public static int maxVal = Integer.MIN_VALUE;
    public static int N, M;

    public static void greedy(){
        int sum = 0;
        int temp = 0;
        int lineMax = Integer.MIN_VALUE;

        for(int i = 0 ; i < N ; i++){
            if(selectedList.get(i)){
                lineMax = Math.max(lineMax, temp); // 이거.
                sum += lineMax;
                lineMax = Integer.MIN_VALUE;
                temp = 0;
                continue;
            }

            temp += arr[i];

            if(arr[i] < 0 || i == N - 1){
                lineMax = Math.max(lineMax, temp);
                temp = Math.max(temp, arr[i]);
            }
        }

        sum += lineMax;

        maxVal = Math.max(maxVal, sum);
    }

    public static void backtracking(int num, int stick, boolean triger){
        if(stick >= M){
            return;
        }

        if(num >= N){
            if(selectedList.size() == N && stick == M - 1){
                greedy();
                // findMax();
            }
            return;
        }

        if(triger && num != N - 1){
            selectedList.add(true);
            backtracking(num + 1, stick + 1, false);
            selectedList.remove(selectedList.size() - 1);
        }

        selectedList.add(false);
        backtracking(num + 1, stick, true);
        selectedList.remove(selectedList.size() - 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        backtracking(0, 0, false);

        System.out.print(maxVal);
    }
}