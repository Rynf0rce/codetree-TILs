import java.util.*;
import java.io.*;

public class Main {
    public static TreeSet<Long> posSet = new TreeSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            long end = (long)T * speed + start;

            if(posSet.ceiling(end) == null){
                posSet.add(end);
            }
            else{
                while(posSet.ceiling(end) != null){
                    posSet.remove(posSet.ceiling(end));
                }
                posSet.add(end);
            }
        }
        System.out.print(posSet.size());
    }
}