import java.util.*;
import java.io.*;

public class Main {
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch(str){
                case "add" :
                    hs.add(num);
                break;
                case "remove" :
                    hs.remove(num);
                break;
                case "find" :
                    System.out.println(hs.contains(num) ? "true" : "false");
                break;
            }
        }
    }
}