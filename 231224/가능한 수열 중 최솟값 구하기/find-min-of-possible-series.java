import java.util.*;

public class Main {
    public static int n;
    public static int output = -1;
    public static ArrayList<Integer> vector = new ArrayList<>();

    public static boolean conditional(){
        for(int i = 0 ; i < vector.size() ; i++){
            int range = Math.min(i, vector.size() - 1 - (i + 1));
            for(int j = 0 ; j <= range ; j++){
                int idx = i + 1;
                int cnt = 0;
                for(int k = i - j ; k <= i ; k++){
                    if(vector.get(k) == vector.get(idx)){
                        cnt++;
                    }
                    if(cnt >= j + 1){
                        return false;
                    }
                    idx++;
                }
            }
        }
        return true;
    }

    public static void search(int num){
        if(num >= n){
            if(conditional()){
                for(int i = 0 ; i < vector.size() ; i++){
                    System.out.print(vector.get(i));
                }
                System.exit(0);
            }
            return;
        }

        for(int i = 4 ; i <= 6 ; i++){
            vector.add(i);
            search(num + 1);
            vector.remove(vector.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        search(0);
        System.out.println(output);
    }
}