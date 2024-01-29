import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 200000;
    public static final long MAX_LONG = 1000000000L;
    public static long[] arr = new long[MAX_LENGTH];
    public static TreeSet<Long> selectedPointSet = new TreeSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr, 0, n);

        selectedPointSet.add(arr[0]);
        m--;
        selectedPointSet.add(arr[n - 1]);
        m--;

        for(int i = 0 ; i < m ; i++){
            int start = 0;
            int end = n - 1;
            int candidate = -1;
            long maxOfMin = 0;
            while(start <= end){
                int mid = (end + start) / 2;

                long left = arr[mid] - selectedPointSet.floor(arr[mid]);
                long right = selectedPointSet.ceiling(arr[mid]) - arr[mid];
                long curMin = Math.min(left, right);

                if(maxOfMin < curMin && !selectedPointSet.contains(arr[mid])){
                    maxOfMin = curMin;
                    candidate = mid;
                }

                if(left > right){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }

            selectedPointSet.add(arr[candidate]);
        }

        long ans = MAX_LONG + 1;
        long prePoint = -1;
        for(long point : selectedPointSet){
            if(prePoint == -1){
                prePoint = point;
            }
            else{
                ans = Math.min(ans, point - prePoint);
                prePoint = point;
            }
        }

        System.out.println(ans);
    }
}