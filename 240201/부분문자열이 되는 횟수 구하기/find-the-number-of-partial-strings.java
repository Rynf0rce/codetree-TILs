import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 200000;
    public static final int ALPHA_NUM = 26;
    public static char[] arr_A, arr_B;
    public static int[] orderArr = new int[MAX_LENGTH];
    public static TreeSet<Integer>[] alphaSet = new TreeSet[ALPHA_NUM];

    public static boolean canSubsequence(){
        if(alphaSet[arr_B[0] - 'a'].isEmpty()){
            return false;
        }

        int idx = alphaSet[arr_B[0] - 'a'].first();
        

        for(int i = 1 ; i < arr_B.length ; i++){
            // System.out.println(idx);
            int alpha = arr_B[i] - 'a';
            if(alphaSet[alpha].higher(idx) == null){
                return false;
            }

            idx = alphaSet[alpha].higher(idx);
        }
        // System.out.println("cc");
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr_A = br.readLine().toCharArray();
        arr_B = br.readLine().toCharArray();

        for(int i = 0 ; i < arr_A.length ; i++){
            int idx = arr_A[i] - 'a';
            if(alphaSet[idx] == null){
                alphaSet[idx] = new TreeSet<Integer>();
            }
            alphaSet[idx].add(i);
        }

        // for(int i = 0 ; i < 4 ; i++){
        //     for(Integer test : alphaSet[i]){
        //         System.out.print(test + " ");
        //     }
        //     System.out.println();
        // }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr_A.length ; i++){
            orderArr[i] = Integer.parseInt(st.nextToken());
            orderArr[i]--;
        }

        int cnt = 0;
        if(canSubsequence()){
            cnt++;
        }
        else{
            System.out.println(0);
            System.exit(0);
        }

        for(int i = 0 ; i < arr_A.length ; i++){
            alphaSet[arr_A[orderArr[i]] - 'a'].remove(orderArr[i]);

            if(canSubsequence()){
                cnt++;
            }
            else{
                break;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}