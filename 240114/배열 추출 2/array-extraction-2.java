import java.util.*;

class condtion implements Comparable<condtion>{
    int num;

    public condtion(int num){
        this.num = num;
    }

    @Override
    public int compareTo(condtion c){
        if(Math.abs(this.num) == Math.abs(c.num)){
            return this.num - c.num;
        }
        else{
            return Math.abs(this.num) - Math.abs(c.num);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<condtion> pq = new PriorityQueue<>();

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll().num);
                }   
                continue;
            }

            pq.add(new condtion(num));
        }
    }
}