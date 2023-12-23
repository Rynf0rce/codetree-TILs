import java.util.*;

public class Main {
    public static int K;
    public static int N;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void print(){
        for(int i = 0 ; i < answer.size() ; i++){
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

    public static void recursion(int num){
        if(num > N){
            print();
            return;
        }

        for(int i = 1 ; i <= K ; i++){
            if( num <= 2 || !( i == answer.get(answer.size() - 1) && i == answer.get(answer.size() - 2) ) ){
                answer.add(i);
                recursion(num + 1);
                answer.remove(answer.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        recursion(1);
    }
}