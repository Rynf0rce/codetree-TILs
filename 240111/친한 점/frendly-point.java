import java.util.*;

class point implements Comparable<point>{
    int x;
    int y;

    public point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(point o){
        if(this.x == o.x){
            return this.y - o.y;
        }
        else{
            return this.x - o.x;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<point> s = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            s.add(new point(x, y));
        }

        for(int i = 0 ; i < m ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            point p = s.ceiling(new point(x, y));
            System.out.println(p == null ? "-1 -1" : p.x + " " + p.y); 
        }
    }
}