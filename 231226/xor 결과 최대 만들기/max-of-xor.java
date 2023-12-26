import java.util.*;

public class Main {
    public static final int MAX_INPUT = 1000000;
    public static int[] table = new int[20];
    public static int n;
    public static int m;
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static int[] input;
    public static int maxVal = Integer.MIN_VALUE;

    public static void tableClear(){
        for(int i = 0 ; i < table.length ; i++){
            table[i] = 0;
        }
    }

    public static int xor(){
        int output = 0;
        tableClear();

        for(int i = 0 ; i < vector.size(); i++){
            int num = vector.get(i);
            int cnt = 0;
            while(num != 0){
                if(num % 2 == 1){
                    table[cnt]++;
                }

                if(table[cnt] >= 2){
                    table[cnt] = 0;
                }

                num /= 2;
                cnt++;
            }
        }

        for(int i = 0 ; i < table.length ; i++){
            if(table[i] == 1){
                output += (int)Math.pow(2, i);
            }
        }
        return output;
    }

    public static void combination(int idx, int cnt){
        if(cnt >= m){
            maxVal = Math.max(maxVal, xor());
            return;
        }
        
        for(int i = idx ; i < n ; i++){
            vector.add(input[i]);
            combination(i + 1, cnt + 1);
            vector.remove(vector.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n];

        for(int i = 0 ; i < n ; i++){
            input[i] = sc.nextInt();
        }

        combination(0, 0);
        System.out.print(maxVal);

    }
}