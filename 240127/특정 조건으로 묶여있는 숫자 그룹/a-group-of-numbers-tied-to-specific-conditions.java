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
    public static int MAX_RANGE = 50000;
    public static tuple[] arr = new tuple[MAX_RANGE];
    public static TreeSet<tuple> containSet = new TreeSet<>();
    public static int[] answerArr = new int[2];

    public static long abs(long num){
        if(num < 0){
            return num * -1;
        }

        return num;
    }

    public static boolean inRange(long num, long K){
        if(containSet.isEmpty()){
            return true;
        }

        return abs(num - containSet.first().num) <= K && abs(num - containSet.last().num) <= K;
    }

    public static void updateAnswer(int num){
        if(answerArr[0] <= num){
            answerArr[0] = num;
        }
        else{
            return;
        }

        if(answerArr[1] <= answerArr[0]){
            int temp = answerArr[0];
            answerArr[0] = answerArr[1];
            answerArr[1] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(br.readLine());
            arr[i] = new tuple(num, i);
        }

        Arrays.sort(arr, 0, N);

        int j = -1;
        int curMaxVal = 0;
        for(int i = 0 ; i < N ; i++){
            while(j + 1 < N && inRange(arr[j + 1].num, K)){
                containSet.add(arr[j + 1]);
                j++;
            }

            curMaxVal = Math.max(curMaxVal, containSet.size());

            containSet.remove(arr[i]);

            if(containSet.isEmpty()){
                updateAnswer(curMaxVal);
            }

            // System.out.println(i + " " + j + " " + containSet.size());
            // for(tuple t : containSet){
            //     System.out.print(t.num + " ");
            // }
            // System.out.println();
            // System.out.println();  
        }

        bw.write( answerArr[0] + answerArr[1] + "");

        br.close();
        bw.close();
    }
}