import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> s = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            if(s.size() == m + 1){
                break;
            }

            int num = sc.nextInt();
            boolean chack = true;
            for(int j = num ; j > 0 ; j--){
                if(!s.contains(j)){
                    s.add(j);
                    chack = false;
                    break;
                }
            }

            if(chack){
                break;
            }
        }

        System.out.println(s.size());
        
    }
}