import java.util.*;

class point implements Comparable<point>{
    int x;
    int y;

    public point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(point p){
        return this.x - p.x;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<point> containSet = new HashSet<>();
        TreeSet<point> pointSet_X = new TreeSet<>();
        TreeSet<point> pointSet_Y = new TreeSet<>(new Comparator<point>() {
        @Override
        public int compare(point p1, point p2) {
            return p1.y - p2.y;
        }
    });
        int n = sc.nextInt();
        int q = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            point inPoint = new point(x, y);
            
            pointSet_X.add(inPoint);
            pointSet_Y.add(inPoint);

        }

        for(int i = 0 ; i < q ; i++){
            containSet.clear();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int cnt = 0;

            point startPoint = new point(x1, y1);
            point endPoint = new point(x2, y2);
            
            point curPoint = pointSet_X.ceiling(startPoint);
            while(curPoint != pointSet_X.higher(endPoint)){
                containSet.add(curPoint);
                curPoint = pointSet_X.higher(curPoint);
            }

            curPoint = pointSet_Y.ceiling(startPoint);
            while(curPoint != pointSet_Y.higher(endPoint)){
                if(containSet.contains(curPoint)){
                    cnt++;
                }
                curPoint = pointSet_Y.higher(curPoint);
            }
            System.out.println(cnt);
        }
    }
}