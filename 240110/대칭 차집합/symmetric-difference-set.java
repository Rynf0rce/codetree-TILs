import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        HashSet<Integer> group = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            group.add(num);
        }

        for(int i = 0 ; i < m ; i++){
            int num = sc.nextInt();
            if(group.contains(num)){
                group.remove(num);
            }
            else{
                group.add(num);
            }
        }
        System.out.print(group.size());
    }
}