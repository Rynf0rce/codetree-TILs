import java.util.*;
import java.io.*;

class point implements Comparable<point>{
    int x;
    int y;

    public point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(point p){
        if(this.x == p.x){
            return this.y - p.y;
        }
        else{
            return this.x - p.x;
        }
    }
}

public class Main {
    public static final int MAX_POINT = 1000;
    public static final int MAX_QUESTION = 100000;
    public static point[] pointArr = new point[MAX_POINT];
    public static point[] StartQuestionArr = new point[MAX_QUESTION];
    public static point[] endQuestionArr = new point[MAX_QUESTION];

    public static boolean inRect(point p1, point p2, point target){
        return p1.x <= target.x && p1.y <= target.y && target.x <= p2.x && target.y <= p2.y;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();

        TreeSet<Integer> xSet = new TreeSet<>();
        TreeSet<Integer> ySet = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pointArr[i] = new point(x, y);
            xSet.add(x);
            ySet.add(y);
        }

        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            StartQuestionArr[i] = new point(x1, y1);
            endQuestionArr[i] = new point(x2, y2);

            xSet.add(x1);
            ySet.add(y1);
            xSet.add(x2);
            ySet.add(y2);
        }

        int idx = 0;
        for(Integer num : xSet){
            xMap.put(num, idx++);
        }

        idx = 0;
        for(Integer num : ySet){
            yMap.put(num, idx++);
        }

        for(int i = 0 ; i < n ; i++){
            pointArr[i] = new point(xMap.get(pointArr[i].x), yMap.get(pointArr[i].y));
        }

        Arrays.sort(pointArr, 0, n);
        

        for(int i = 0 ; i < q ; i++){
            StartQuestionArr[i] = new point(xMap.get(StartQuestionArr[i].x), yMap.get(StartQuestionArr[i].y));
            endQuestionArr[i] = new point(xMap.get(endQuestionArr[i].x), yMap.get(endQuestionArr[i].y));
            int output = 0;
            for(int j = 0 ; j < n ; j++){
                if(inRect(StartQuestionArr[i], endQuestionArr[i], pointArr[j])){
                    output++;
                }
            }
            bw.write(output + "\n");
        }

        br.close();
        bw.close();
    }
}