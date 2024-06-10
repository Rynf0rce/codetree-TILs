import java.util.*;

public class Main {
    public static final int MAX_RANGE = 8;
    public static boolean[] visited = new boolean[MAX_RANGE + 1];
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static int n;
    
    public static void sequence(int cnt){
        if(cnt >= n){
            for(int i = 0 ; i < vector.size() ; i++){
                System.out.print(vector.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = n ; i >= 1 ; i--){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            vector.add(i);

            sequence(cnt + 1);

            vector.remove(vector.size() - 1);
            visited[i] = false;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sequence(0);
    }
}