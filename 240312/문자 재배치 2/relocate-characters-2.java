import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = String.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder(str);
        System.out.print(sb.reverse().toString());
    }
}