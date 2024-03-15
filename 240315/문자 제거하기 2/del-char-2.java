import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(st.nextToken()));

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(br.readLine()) - 1;
            if(sb.length() <= num){
                continue;
            }

            sb.deleteCharAt(num);
            System.out.println(sb.toString());
        }
    }
}