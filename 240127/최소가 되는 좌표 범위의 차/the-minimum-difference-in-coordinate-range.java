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
        if(this.y == p.y){
            return this.x - p.x;
        }
        else{
            return this.y - p.y;
        }
    }
}

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MAX_INT = 1000000;
    
    public static ArrayList<point>[] pointList = new ArrayList[MAX_INT + 1];
    public static TreeSet<point> pointSet = new TreeSet<>();

    public static TreeSet<Integer> xSet = new TreeSet<>();
    public static ArrayList<Integer> xList;

    public static void addPoint(int idx){
        for(int i = 0 ; i < pointList[idx].size() ; i++){
            pointSet.add(pointList[idx].get(i));
        }
    }

    public static void removePoint(int idx){
        for(int i = 0 ; i < pointList[idx].size() ; i++){
            pointSet.remove(pointList[idx].get(i));
        }
    }

    public static boolean satisfied(int D){
        if(pointSet.isEmpty()){
            return false;
        }

        if(pointSet.last().y - pointSet.first().y >= D){
            return true;
        }
   
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(pointList[x] == null){
                pointList[x] = new ArrayList<point>();
            }

            pointList[x].add(new point(x, y));
            xSet.add(x);
        }

        xList = new ArrayList<Integer>(xSet);

        int j = -1;
        int minVal = MAX_INT + 1;
        for(int i = 0 ; i < xList.size() ; i++){
            while(j + 1 < xList.size()){
                if(satisfied(D)){
                    minVal = Math.min(minVal, xList.get(j) - xList.get(i));
                    break;
                }
                addPoint(xList.get(j + 1));
                j++;       
            }
            removePoint(xList.get(i));
        }

        bw.write( (minVal == MAX_INT + 1 ? -1 : minVal) + "");

        br.close();
        bw.close();
    }
}