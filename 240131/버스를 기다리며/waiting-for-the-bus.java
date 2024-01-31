import java.util.*;

public class Main {
    public static int MAX_PEOPLE = 100000;
    public static int MAX_TINE = 1000000000;
    public static int[] arr = new int[MAX_PEOPLE];

    public static int N, M, C;

    public static boolean canAllRideInTime(int time){
        int cnt = 1;
        int seat = 1;
        int idx = 0;
        for(int i = 1 ; i < N ; i++){
            if(arr[i] - arr[idx] <= time && seat < C){
                seat++;
                continue;
            }
            else{
                idx = i;
                seat = 1;
                cnt++;
            }
        }
        // System.out.println(cnt + " " + M);
        return cnt <= M;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        C = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0 , N);

        canAllRideInTime(3);

        int start = 0;
        int end = MAX_TINE;
        int ans = MAX_TINE;
        while(start <= end){
            int mid = (end + start) / 2;
            if(canAllRideInTime(mid)){
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + 1;
            }
        }

        System.out.print(ans);
    }
}