import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 1000;
    public static final int MAX_IDX = 1000000;
    public static int[] arr = new int[MAX_NODE + 1];
    public static int[] parentArr = new int[MAX_IDX + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int parents = 0;
        int child = 1;
        while(child != n){
            if(arr[child + 1] > arr[child] + 1){
                parents++;
            }
            child++;
            parentArr[arr[child]] = arr[parents];
        }

        int ans = 0;
        for(int i = 1 ; i <= MAX_IDX ; i++){
            if(parentArr[parentArr[i]] == 0 || parentArr[i] == 0){
                continue;
            }
            
            if(parentArr[parentArr[m]] == parentArr[parentArr[i]] && parentArr[m] != parentArr[i]){
                ans++;
            }
        }
        System.out.print(ans);
    }
}

/*
import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 1000;
    public static final int MAX_IDX = 1000000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_IDX + 1];
    public static int[] arr = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_IDX + 1];
    public static int[] depthArr = new int[MAX_IDX + 1];
    public static int[] parentArr = new int[MAX_IDX + 1];
    
    public static void traversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int curIdx = nodeList[idx].get(i);
            if(!visited[curIdx]){
                visited[curIdx] = true;
                depthArr[curIdx] = depthArr[idx] + 1;
                traversal(curIdx);
                parentArr[curIdx] = idx;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            nodeList[arr[i]] = new ArrayList<>();
        }

        int parents = 0;
        int child = 1;
        while(child != n){
            if(arr[child + 1] > arr[child] + 1){
                parents++;
            }
            child++;
            // System.out.println(arr[parents] + " " + arr[child]);
            nodeList[arr[parents]].add(arr[child]);
            nodeList[arr[child]].add(arr[parents]);
        }

        visited[arr[1]] = true;
        traversal(arr[1]);

        int ans = 0;
        for(int i = 1 ; i <= MAX_IDX ; i++){
            if(m != i && parentArr[parentArr[m]] == parentArr[parentArr[i]] && parentArr[m] != parentArr[i] && depthArr[m] == depthArr[i]){
                ans++;
            }
        }
        System.out.print(ans);
    }
}
*/