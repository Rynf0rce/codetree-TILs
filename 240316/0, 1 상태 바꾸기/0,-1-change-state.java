import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 4000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = 0;
            switch(order){
                case 1 :
                    int idx = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    arr[idx] = num;
                    break;
                case 2 :
                    start = Integer.parseInt(st.nextToken());
                    end = Integer.parseInt(st.nextToken());
                    for(int j = start ; j <= end ; j++){
                        if(arr[j] == 1){
                            arr[j] = 0;
                        }
                        else{
                            arr[j] = 1;
                        }
                    }
                    break;
                case 3 :
                    start = Integer.parseInt(st.nextToken());
                    end = Integer.parseInt(st.nextToken());
                    for(int j = start ; j <= end ; j++){
                        arr[j] = 0;
                    }
                    break;
                case 4 :
                    start = Integer.parseInt(st.nextToken());
                    end = Integer.parseInt(st.nextToken());
                    for(int j = start ; j <= end ; j++){
                        arr[j] = 1;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            sb.append(arr[i] + " ");
        }
        System.out.print(sb.toString());
    }
}