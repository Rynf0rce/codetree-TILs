import java.util.*;
public class Main {
    public static int N = 0;
    public static int M = 0;

    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void simulation(int idx, int cnt){
        if(cnt == M){
            for(int i = 0 ; i < arr.size() ; i++){
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        if(idx > N){
            return;
        }

        arr.add(idx);
        simulation(idx + 1, cnt + 1);
        arr.remove(arr.size() - 1);

        simulation(idx + 1, cnt);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        simulation(1, 0);
    }
}