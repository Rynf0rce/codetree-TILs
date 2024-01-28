import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    long num;
    int idx;

    public tuple(long num, int idx){
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(tuple t){
        if(this.num == t.num){
            return this.idx - t.idx;
        }
        else if(this.num > t.num){
            return 1;
        }
        else{
            return -1;
        }
    }

}

public class Main {
    public static final int MAX_LENGTH = 50000;
    public static tuple[] inputArr = new tuple[MAX_LENGTH];
    public static int[] leftArr = new int[MAX_LENGTH];
    public static int[] rightArr = new int[MAX_LENGTH];

    public static TreeSet<tuple> containSet = new TreeSet<>();

    public static long abs(long num){
        if(num < 0){
            return num * -1;
        }

        return num;
    }

    public static boolean satisfied(long num, long K){
        if(containSet.isEmpty()){
            return true;
        }

        if(abs(num - containSet.first().num) <= K && abs(containSet.last().num - num) <= K){
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(br.readLine());
            inputArr[i] = new tuple(num, i);
        }

        Arrays.sort(inputArr, 0, N);

        int j = -1;
        for(int i = 0 ; i < N ; i++){
            while(j + 1 < N && satisfied(inputArr[j + 1].num, K)){
                containSet.add(inputArr[j + 1]);
                j++;
                if(j == 0){
                    leftArr[j] = j - i + 1;
                }
                else{
                    leftArr[j] = Math.max(leftArr[j - 1], j - i + 1);
                }
            }
            containSet.remove(inputArr[i]);
        }

        // for(int i = 0 ; i < N ; i++){
        //     System.out.print(leftArr[i] + " ");
        // }

        // System.out.println();

        containSet.clear();
        j = N;
        for(int i = N - 1 ; i >= 0 ; i--){
            while(j - 1 >= 0 && satisfied(inputArr[j - 1].num, K)){
                containSet.add(inputArr[j - 1]);
                j--;
                if(j == N - 1){
                    rightArr[j] = i - j + 1;
                }
                else{
                    rightArr[j] = Math.max(rightArr[j + 1], i - j + 1);
                }
            }
            containSet.remove(inputArr[i]);
        }

        // for(int i = 0 ; i < N ; i++){
        //     System.out.print(rightArr[i] + " ");
        // }

        int ans = 1;
        for(int i = 0 ; i < N - 1; i++){
            ans = Math.max(ans, leftArr[i] + rightArr[i + 1]);
        }
        
        bw.write(ans + "");

        br.close();
        bw.close();
    }
}