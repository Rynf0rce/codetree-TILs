import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x;
    int value;
    int idx;

    public point(int x, int value){
        this.x = x;
        this.value = value;
        this.idx = 0;
    }

    public point(int x, int value, int idx){
        this.x = x;
        this.value = value;
        this.idx = idx;
    }

    @Override
    public int compareTo(point l){
        return this.x - l.x;
    }
}

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static point[] pointArr = new point[MAX_LENGTH * 2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < 2 * n ; i = i + 2){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pointArr[i] = new point(a, 1, i / 2);
            pointArr[i + 1] = new point(b, -1, i / 2);
        }

        Arrays.sort(pointArr, 0, 2 * n);

        // for(int i = 0 ; i < 2 * n ; i++){
        //     System.out.print(pointArr[i].idx + " ");
        // }
        // System.out.println();

        HashSet<Integer> curPointSet = new HashSet<>();
        int numArea = 0;

        for(int i = 0 ; i < 2 * n ; i++){
            int x = pointArr[i].x;
            int value = pointArr[i].value;
            int idx = pointArr[i].idx;

            if(value == 1){
                if(curPointSet.isEmpty()){
                    numArea++;
                }
                curPointSet.add(idx);
            }
            else{
                curPointSet.remove(idx);
            }
        }

        bw.write(numArea + "");

        br.close();
        bw.close();
    }
}