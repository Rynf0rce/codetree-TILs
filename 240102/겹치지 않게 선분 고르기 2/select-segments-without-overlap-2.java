import java.util.*;

class point implements Comparable<point>{
    int start;
    int end;

    public point(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(point p){
        if(this.start == p.start){
            return this.end - p.end;
        }
        else{
            return this.start - p.start;
        }
    }
}

public class Main {
    public static final int MAX_RANGE = 1000;
    public static int[] DP = new int[MAX_RANGE];

    public static ArrayList<point> lineList = new ArrayList<>();

    public static int n;

    public static void initialize(){
        for(int i = 0 ; i < n ; i++){
            DP[i] = 1;
        }
    }

    public static boolean notFold(point p1, point p2){
        return (p1.end < p2.start || p1.start > p2.end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            lineList.add(new point(row, col));
        }

        initialize();
        
        Collections.sort(lineList);

        for(int i = 1 ; i < lineList.size() ; i++){
            point curPoint = lineList.get(i);
            for(int j = 0 ; j < i ; j++){
                point comparePoint = lineList.get(j);
                if(!notFold(curPoint, comparePoint)){
                    continue;
                }

                DP[i] = Math.max(DP[i], DP[j] + 1);
            }
        }

        int output = 0;
        for(int i = 0 ; i < n ; i++){
            output = Math.max(output, DP[i]);
        }

        System.out.print(output);
    }
}