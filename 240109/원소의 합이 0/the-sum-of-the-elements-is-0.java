import java.util.*;

public class Main {
    public static final int MAX_INPUT = 5000;
    public static final int NUM_SEQUENCE = 4;
    public static int[][] table = new int[NUM_SEQUENCE][MAX_INPUT];
    public static int n;

    public static void mkHash(int r1, int r2, HashMap<Integer, Integer> map){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int value = table[r1][i] + table[r2][j];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        HashMap<Integer, Integer> map_AB = new HashMap<>();
        HashMap<Integer, Integer> map_CD = new HashMap<>();

        for(int i = 0 ; i < NUM_SEQUENCE ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        mkHash(0, 1, map_AB);
        mkHash(2, 3, map_CD);

        // System.out.println(map_AB.size());
        // System.out.println(map_CD.size());

        int output = 0;

        for(Integer key : map_AB.keySet()){
            if(map_CD.containsKey(-key)){
                output += map_CD.get(-key) * map_AB.get(key);
            }
        }

        System.out.print(output);
    }
}