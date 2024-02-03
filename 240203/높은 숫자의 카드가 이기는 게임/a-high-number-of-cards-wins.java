import java.util.*;

public class Main {
    public static final int MAX_CARD = 50000;
    public static int[] arr = new int[MAX_CARD];
    public static TreeSet<Integer> cardSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1 ; i <= 2 * n ; i++){
            cardSet.add(i);
        }

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            cardSet.remove(arr[i]);
        }


        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(cardSet.isEmpty()){
                break;
            }

            if(cardSet.higher(arr[i]) != null){
                cardSet.remove(cardSet.higher(arr[i]));
                ans++;
            }
            else{
                cardSet.remove(cardSet.first());
            }
        }

        System.out.print(ans);
    }
}