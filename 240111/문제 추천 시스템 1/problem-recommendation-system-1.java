import java.util.*;

class problem implements Comparable<problem>{
    int rank;
    int num;

    public problem(int rank, int num){
        this.rank = rank;
        this.num = num;
    }

    @Override
    public int compareTo(problem p){
        if(this.rank == p.rank){
            return this.num - p.num;
        }
        else{
            return this.rank - p.rank;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<problem> s = new TreeSet<>();
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            int rank = sc.nextInt();
            s.add(new problem(rank, num));
        }

        int m = sc.nextInt();
        for(int i = 0 ; i < m ; i++){
            String str = sc.next();
            int num = 0;
            int rank = 0;
            switch(str){
                case "ad" :
                    num = sc.nextInt();
                    rank = sc.nextInt();
                    s.add(new problem(rank, num));
                    break;
                case "sv" :
                    num = sc.nextInt();
                    rank = sc.nextInt();
                    s.remove(new problem(rank, num));
                    break;
                case "rc" :
                    num = sc.nextInt();
                    if(num == 1){
                        System.out.println(s.last().num);
                    }
                    else{
                        System.out.println(s.first().num);
                    }
                    break;
            }
        }
    }
}