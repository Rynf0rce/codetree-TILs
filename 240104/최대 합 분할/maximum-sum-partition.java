import java.util.*;

public class Main {
    public static final int MAX_NUM = 100;
    public static final int MAX_INT = 1000;
    public static int[] arr = new int[MAX_NUM];
    public static boolean[] DP = new boolean[MAX_NUM * MAX_INT + 1];
    public static ArrayList<Boolean> selectedList = new ArrayList<>();
    public static int maxVal = Integer.MIN_VALUE;
    public static int n;

    public static void initialize(int total){
        DP[0] = true;
        for(int i = 1 ; i <= total / 2 ; i ++){
            DP[i] = false;
        }
    }

    public static int isSame(int total){
        int output = 0;
        for(int i = 0 ; i <= total / 2 ; i++){
            if(DP[i] && total - 2 * i == 0){
                output = i;
            }
        }

        return output;
    }

    public static void playDP(int total){
        initialize(total);

        for(int i = 0 ; i < n ; i++){
            if(!selectedList.get(i)){
                continue;
            }

            for(int j = total / 2 + 1 ; j >= 0 ; j--){
                if(j < arr[i] || !DP[j - arr[i]]){
                    continue;
                }

                DP[j] = true;
            }
        }

        // System.out.println("total : " + total);

        // for(int i = 0 ; i <= total ; i++){
        //     System.out.print( (DP[i] ? 1 : 0) + " ");
        // }
        // System.out.println();

        maxVal = Math.max(maxVal, isSame(total));
        // System.out.println("maxVal : " + maxVal);
        // System.out.println();
    }

    public static void select(int num, int sum){
        if(num >= n){
            if(selectedList.size() >= n){
                playDP(sum);
            }
            return;
        }
        
        selectedList.add(false);
        select(num + 1, sum);
        selectedList.remove(selectedList.size() - 1);

        selectedList.add(true);
        select(num + 1, sum + arr[num]);
        selectedList.remove(selectedList.size() - 1);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        select(0, 0);

        System.out.println(maxVal);
    }
}