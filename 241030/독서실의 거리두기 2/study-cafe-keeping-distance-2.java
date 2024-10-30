import java.util.*;
public class Main {
    public static int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(str.charAt(i) + "");
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr[i] == 1){
                continue;
            }

            arr[i] = 1;
            int val = MAX_LENGTH;
            int j = 0;
            int k = -1;
            while(j < N){
                if(arr[j] == 1 && k != -1){
                    val = Math.min(val, j - k);
                    k = j;
                }
                else if(arr[j] == 1 && k == -1){
                    k = j;
                }
                j++;
            }
            ans = Math.max(ans, val);
            arr[i] = 0;
        }
        System.out.print(ans);
    }
}