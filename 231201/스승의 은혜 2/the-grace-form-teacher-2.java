import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), B = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        int[] arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length ; i++){
            int currentBudget = B;
            int cnt = 0;
            for(int j = 0 ; j < arr.length ; j++){
                if(i == j){
                    currentBudget -= arr[j] / 2;
                }
                else{
                    currentBudget -= arr[j];
                }

                if(currentBudget < 0){
                    break;
                }
                else{
                    cnt++;
                }
            }
            maxVal = Math.max(maxVal,cnt);
        }
        System.out.println(maxVal);
    }
}