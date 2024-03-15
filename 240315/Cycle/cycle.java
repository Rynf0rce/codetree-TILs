import java.util.*;
public class Main {
    public static HashSet<Integer> numSet = new HashSet<>();
    public static HashSet<Integer> ansSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int num = N;
        while(!ansSet.contains((num * N) % P)){
            num = (num * N) % P;
            if(numSet.contains(num)){
                ansSet.add(num);
            }
            else{
                numSet.add(num);
            }
        }
        System.out.print(ansSet.size());

    }
}