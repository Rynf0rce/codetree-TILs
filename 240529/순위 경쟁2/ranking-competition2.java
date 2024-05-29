import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static char[] targetArr = new char[MAX_LENGTH];
    public static int[] valArr = new int[MAX_LENGTH];
    public static int[] countArr = new int[2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            targetArr[i] = String.valueOf(st.nextToken()).charAt(0);
            valArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int flag = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(targetArr[i] == 'A'){
                countArr[0] += valArr[i];
            }
            else{
                countArr[1] += valArr[i];
            }
            
            int curflag = 0;
            if(countArr[0] > countArr[1]){
                curflag = -1;
            }
            else if(countArr[0] < countArr[1]){
                curflag = 1;
            }

            if(flag != curflag){
                ans++;
            }
            flag = curflag;
        }
        System.out.print(ans);
    }
}