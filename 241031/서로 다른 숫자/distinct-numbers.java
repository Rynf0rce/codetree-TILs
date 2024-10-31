import java.util.*;
import java.io.*;

public class Main {
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            hs.add(Integer.parseInt(st.nextToken()));
        }

        System.out.print(hs.size());

    }
}