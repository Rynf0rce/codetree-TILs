import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static ArrayList<Integer> vector = new ArrayList<>();
    
    public static void printCom(){
        for(int i = 0 ; i < vector.size() ; i++){
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();
    }

    public static void combination(int num, int cnt){
        if(cnt >= m){
            printCom();
            return;
        }

        for(int i = num ; i <= n ; i++){
            vector.add(i);
            combination(i + 1, cnt + 1); // 선택한거 이후의 값을 고르게 하면 조합 완성.
            vector.remove(vector.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combination(1, 0);
    }
}