import java.util.*;

class point{
    int row;
    int col;

    public point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static ArrayList<point> input = new ArrayList<>();
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static int n;
    public static int m;
    public static int minVal = Integer.MAX_VALUE;

    public static int euclidean(point p1, point p2){
        return (int)(Math.pow(p1.row - p2.row, 2) + Math.pow(p1.col - p2.col, 2));
    }

    public static int calDistance(int distance){
        int output = distance;

        if(vector.size() == 1){
            return 0;
        }

        point p2 = input.get(vector.get(vector.size() - 1));

        for(int i = 0 ; i < vector.size() - 1 ; i++){
            point p1 = input.get(vector.get(i));
            output = Math.max(output, euclidean(p1, p2));
        }

        return output;
    }

    public static void longDistance(int n, int distance){
        if(vector.size() == m){
            minVal = Math.min(minVal, distance);
            return;
        }

        for(int i = n ; i < input.size() ; i++){
            vector.add(i);
            longDistance(i + 1, calDistance(distance));
            vector.remove(vector.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            input.add(new point(r,c));
        }

        longDistance(0, 0);

        System.out.print(minVal);
    }
}