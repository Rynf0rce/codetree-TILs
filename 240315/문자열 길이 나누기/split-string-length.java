import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(String.valueOf(br.readLine()));
        }

        System.out.println(sb.substring(0, sb.length() / 2).toString());
        System.out.println(sb.substring(sb.length() / 2).toString());
    }
}