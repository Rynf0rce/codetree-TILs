import java.util.*;
public class Main {
    public static int K = 0;
    public static int N = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void simulation(int cnt){
        if(cnt > N){
            System.out.println(sb.toString());
            return;
        }

        for(int i = 1 ; i <= K ; i++){
            sb.append(i + " ");
            simulation(cnt + 1);
            sb.setLength(sb.length() - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        simulation(1);
    }
}