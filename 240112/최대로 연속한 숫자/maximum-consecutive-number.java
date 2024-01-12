import java.util.*;

class range implements Comparable<range>{
    int start;
    int end;
    int length;

    public range(int start, int end){
        this.start = start;
        this.end = end;
        this.length = end - start + 1;
    }

    public boolean inRange(int point){
        return point >= start && point <= end;
    }

    @Override
    public int compareTo(range r){
        if(this.length == r.length){
            return this.start - r.start;
        }
        else{
            return this.length - r.length;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<range> s = new TreeSet<>();
        // TreeSet<Integer> inputSet = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        s.add(new range(0, n));

        for(int i = 0 ; i < m ; i++){
            int num = sc.nextInt();
            for(range r : s){
                if(r.inRange(num)){
                    if(r.start <= num - 1){
                        s.add(new range(r.start, num - 1));
                    }

                    if(r.end >= num + 1){
                        s.add(new range(num + 1, r.end));
                    }
                    s.remove(r);
                    break;
                }
            }
            System.out.println(s.last().length);
        }      
    }
}