import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = (1<<20);
    public static boolean[] visited = new boolean[MAX_NODE];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < q ; i++){
            int num = Integer.parseInt(br.readLine());
            int point = num;
            boolean canGo = true;
            while(point > 0){
                if(visited[point]){
                    canGo = false;
                    break;
                }
                point /= 2;
            }

            if(canGo){
                System.out.println(0);
                visited[num] = true;
            }
            else{
                System.out.println(point);
            }
        }
    }
}