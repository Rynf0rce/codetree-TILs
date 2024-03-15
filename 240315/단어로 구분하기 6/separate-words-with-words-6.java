import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 1;
        while(st.hasMoreTokens()){
            String str = String.valueOf(st.nextToken());
            if(cnt++ % 3 == 0){
                System.out.println(str);
            }
        }
    }
}