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
        if(this.x == p.x){
            return this.y - p.y;
        }
        else{
            return this.x - p.x;
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
            int num = sc.nextInt();
            if(s.ceiling(new point(num, 0)) != null){
                point p = s.ceiling(new point(num, 0));
                System.out.println(p.x + " " + p.y);
                s.remove(p);
            }
            else{
                System.out.println("-1 -1");
            }
        }

    }
}