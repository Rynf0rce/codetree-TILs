import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            sb.append(st.nextToken());
        }
        
        int cnt = 0;
        for(int i = 0 ; i < sb.length() ; i++){
            System.out.print(sb.charAt(i));
            cnt++;
            if(cnt >= 5){
                System.out.println();
                cnt = 0;
            }
        }
    }
}