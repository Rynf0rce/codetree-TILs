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
        int lineMax = 0;

        for(int i = 0 ; i < N ; i++){
            if(selectedList.get(i)){
                sum += lineMax;
                lineMax = 0;
                continue;
            }
            
            if(arr[i] < 0){
                lineMax = Math.max(lineMax, temp);
                temp = 0;
            }
            else{
                temp += arr[i];
            }
        }

        if(temp > 0){
            sum += temp;
        }

        maxVal = Math.max(maxVal, sum);

        if(sum == 23){
            for(int i = 0 ; i < selectedList.size() ; i++){
                System.out.print(selectedList.get(i) + " ");
            } 
        }
    }

    // public static int greedy(int start, int end){
    //     int output = 0;
    //     int temp = 0;
    //     for(int i = start ; i < end ; i++){
    //         if(arr[i] < 0){
    //             output = Math.max(output, temp);
    //             temp = 0;
    //         }
    //         else{
    //             temp += arr[i];
    //         }
    //     }

    //     return output;
    // }

    // public static void findMax(){
    //     int start = 0;
    //     int end = 0;
    //     int output = 0;

    //     for(int i = 0 ; i < selectedList.size() ; i++){
    //         System.out.print(selectedList.get(i)+ " ");
    //         if(!selectedList.get(i)){
    //             end++;
    //         }
    //         else{
    //             maxVal = Math.max(maxVal, greedy(start, end));
    //             start = end + 1;
    //             end = start;
    //         }
    //     }
    // }

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
            arr[i] = sc.nextInt() + 1000;
        }

        backtracking(0, 0, false);

        System.out.print(maxVal - 1000 * (N - M + 1));
    }
}