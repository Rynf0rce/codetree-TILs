import java.util.*;
import java.io.*;

public class Main {
    public static int[] oneRowArr = new int[]{-2, -1, 0, 1 , 2};
    public static int[] oneColArr = new int[]{0, 0, 0, 0, 0};

    public static int[] twoRowArr = new int[]{-1, 0, 1, 0, 0};
    public static int[] twoColArr = new int[]{0, 1, 0, -1, 0};

    public static int[] threeRowArr = new int[]{-1, -1, 1, 1, 0};
    public static int[] threeColArr = new int[]{-1, 1, 1, -1, 0};

    public static final int MAX_LENGTH = 20;
    public static int ans = 0;
    public static int n = 0;

    public static ArrayList<Integer> rowArr = new ArrayList<>();
    public static ArrayList<Integer> colArr = new ArrayList<>();
    public static ArrayList<Integer> numArr = new ArrayList<>();
    public static boolean[][] bombed = new boolean[MAX_LENGTH][MAX_LENGTH];

    public static void Clear(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                bombed[i][j] = false;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    public static void check(){
        Clear();
        for(int i = 0 ; i < rowArr.size() ; i++){
            switch(numArr.get(i)){
                case 1 :
                    for(int j = 0 ; j < oneRowArr.length ; j++){
                        int preRow = rowArr.get(i) + oneRowArr[j];
                        int preCol = colArr.get(i) + oneColArr[j];
                        if(inRange(preRow, preCol)){
                            bombed[preRow][preCol] = true;
                        }
                    }
                break;
                case 2 :
                    for(int j = 0 ; j < twoRowArr.length ; j++){
                        int preRow = rowArr.get(i) + twoRowArr[j];
                        int preCol = colArr.get(i) + twoColArr[j];
                        if(inRange(preRow, preCol)){
                            bombed[preRow][preCol] = true;
                        }
                    }
                break;
                case 3 :
                    for(int j = 0 ; j < threeRowArr.length ; j++){
                        int preRow = rowArr.get(i) + threeRowArr[j];
                        int preCol = colArr.get(i) + threeColArr[j];
                        if(inRange(preRow, preCol)){
                            bombed[preRow][preCol] = true;
                        }
                    }
                break;
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(bombed[i][j]){
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    public static void simulation(int idx){
        if(idx > rowArr.size()){
            check();
            return;
        }

        for(int i = 1 ; i <= 3 ; i++){
            numArr.add(i);
            simulation(idx + 1);
            numArr.remove(numArr.size() - 1);
        }
    }
  
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    rowArr.add(i);
                    colArr.add(j);
                }
            }
        }

        simulation(0);

        System.out.print(ans);
        
    }
}