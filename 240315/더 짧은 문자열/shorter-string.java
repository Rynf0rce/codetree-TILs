import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = String.valueOf(st.nextToken());
        String B = String.valueOf(st.nextToken());
        if(A.length() == B.length()){
            System.out.print("equal");
        }
        else if(A.length() > B.length()){
            System.out.print(B + " " + B.length());
        }
        else{
            System.out.print(A + " " + A.length());
        }
    }
}