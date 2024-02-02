import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_BOOKS = 100000;
    public static int[] arr = new int[MAX_BOOKS];
    public static int N, K, L; // 공책의 수, 추가로 만들 포스트 잇의 수, 하나의 포스트 잇에 적을 수 있는 공책의 번호 개수

    public static boolean satisfied(int h_idx){
        PriorityQueue<Integer> scopeEndQ = new PriorityQueue<>(Collections.reverseOrder());
        
        int cnt = 0;
        int post_it = K;
        for(int i = N - 1 ; i >= 0 ; i--){
            if(arr[i] >= h_idx){
                cnt++;
                continue;
            }

            if(L <= 0 || post_it < 0){
                break;
            }

            while(!scopeEndQ.isEmpty() && scopeEndQ.peek() > i){
                scopeEndQ.poll();
            }

            int desire = h_idx - arr[i];

            while(desire > scopeEndQ.size()){
                scopeEndQ.add(arr[i] - L + 1);
                post_it--;
            }

            if(post_it >= 0){
                cnt++;
            }
        }

        

        return cnt >= h_idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 공책의 수.
        K = Integer.parseInt(st.nextToken()); // 추가로 만들 포스트 잇의 수.
        L = Integer.parseInt(st.nextToken()); // 하나의 포스트 잇에 적을 수 있는 서로 다른 공책의 번호 개수.
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, N);

        // System.out.println(satisfied(4));

        int start = 0;
        int end = MAX_BOOKS;
        int ans = 0;
        while(start <= end){
            int mid = (end + start) / 2;
            if(satisfied(mid)){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                end = mid - 1;
            }
            // System.out.println(start + " " + end);
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }
}