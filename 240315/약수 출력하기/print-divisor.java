import java.util.*;
public class Main {
    public static ArrayList<Long> ansList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(long i = 1 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                ansList.add(i);
            }
        }
        
        int size = ansList.size();
        for(int i = 0 ; i < size ; i++){
            long num = ansList.get(i);
            long val = n / num;
            if(val != num){
                ansList.add(val);
            }
        }

        Collections.sort(ansList);
        for(long num : ansList){
            System.out.print(num + " ");
        }
        
    }
}