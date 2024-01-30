import java.util.*;

public class Main {
    public static final int MAX_PEOPLE = 10000;
    public static final int MAX_TIME = 1000000;
    public static int[] arr = new int[MAX_PEOPLE];

    public static boolean isPossible(int target, int peopleNum, int limitedTime){
        int time = 0;
        PriorityQueue<Integer> timeQueue = new PriorityQueue<>();
        for(int i = 0 ; i < peopleNum ; i++){
            timeQueue.add(arr[i] + time);
            if(timeQueue.size() == target){
                time = timeQueue.poll();
            }
        }

        while(!timeQueue.isEmpty()){
            time = timeQueue.poll();
        }

        // System.out.println(target + " " + time);

        return time <= limitedTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T_max = sc.nextInt();
        for(int i = 0 ; i < N ; i ++){
            arr[i] = sc.nextInt();
        }

        int start = 1;
        int end = N;
        int ans = N;
        while(start <= end){
            int mid = (end + start) / 2;
            // System.out.println(mid);
            if(isPossible(mid, N, T_max)){
                // System.out.println("Yes");
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                // System.out.println("No");
                start = mid + 1;
            }
        }
        System.out.print(ans);
    }
}