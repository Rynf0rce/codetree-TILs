import java.util.*;
import java.io.*;

public class Main {
    public static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = String.valueOf(st.nextToken());
            long order = -1;
            switch(str){
                case "add" :
                    order = Integer.parseInt(st.nextToken());
                    ans = ans | (1 << (order - 1));
                    break;
                case "delete" :
                    order = Integer.parseInt(st.nextToken());
                    if( (ans & (1 << (order - 1))) == (1 << (order - 1))){
                        ans = ans - (1 << order - 1);
                    }
                    break;
                case "print" :
                    order = Integer.parseInt(st.nextToken());
                    System.out.println((int)(ans >> (order - 1) & 1));
                    break;
                case "toggle" :
                    order = Integer.parseInt(st.nextToken());
                    ans = ans ^ (1 << (order - 1));
                    break;
                case "clear" :
                    ans = ans & 0;
                    break;
            }
            
        }
    }
}